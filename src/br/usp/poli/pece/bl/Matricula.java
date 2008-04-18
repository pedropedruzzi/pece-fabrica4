package br.usp.poli.pece.bl;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.usp.poli.pece.db.DAOFactory;
import br.usp.poli.pece.ws.Financeiro;
import br.usp.poli.pece.ws.WebServicesClient;

@Entity
@Table(uniqueConstraints={ @UniqueConstraint(columnNames={"aluno_id", "curso_id"}) })
public class Matricula {
	@Id @GeneratedValue
	protected long id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="aluno_id", nullable=false, updatable=false)
    private Aluno aluno;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="curso_id", nullable=false, updatable=false)
	private Curso curso;
	
	private Date data;
	
	private Status status;
	
	
	public Matricula() {
		
	}
	
	public Matricula(Aluno aluno, Curso curso) {
		this.aluno = aluno;
		this.curso = curso;
		
		this.status = Status.PAGAMENTO_PENDENTE;
	}
	

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	// TODO: TESTAR!
	public static Matricula realizaMatricula(long idAluno, long idCurso) {
		
		Aluno aluno = DAOFactory.getAlunoDAO().findById(idAluno);
		Curso curso = DAOFactory.getCursoDAO().findById(idCurso);

		Matricula matricula = new Matricula(aluno, curso);
		DAOFactory.getMatriculaDAO().makePersistent(matricula);

		final Financeiro f = WebServicesClient.getFinanceiroWS();
		try {
			if (!f.solicitaCobrancaTaxaInscricao(new br.usp.poli.pece.ws.bl.Aluno(aluno), curso.getCodCurso(), matricula.getId()))
				System.err.println("Atenção: Financeiro não aceitou solicitacao de cobrança de taxa de inscrição!");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return matricula;
	}
	
	public static enum Status { PAGAMENTO_PENDENTE, PAGO, AGENDAR_ENTREVISTA, MATRICULADO, RECUSADO }
}
