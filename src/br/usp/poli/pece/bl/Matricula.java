package br.usp.poli.pece.bl;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.usp.poli.pece.db.DAOFactory;
import br.usp.poli.pece.ws.Financeiro;
import br.usp.poli.pece.ws.WebServicesClient;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"aluno_id", "curso_id"}), @UniqueConstraint(columnNames={"numero"})})
@SequenceGenerator(name="MATRICULA", sequenceName="seq_matricula")
public class Matricula {
	@Id @GeneratedValue
	protected long id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="aluno_id", nullable=false, updatable=false)
    private Aluno aluno;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="curso_id", nullable=false, updatable=false)
	private Curso curso;
	
	@Column(nullable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MATRICULA")
	private int numero;
	
	private Date data;
	
	private Status status;
	
	
	public Matricula() {
		
	}
	
	public Matricula(Aluno aluno, Curso curso) {
		this.aluno = aluno;
		this.curso = curso;
		
		this.status = Status.PAGAMENTO_PENDENTE;
	}
	

	protected long getId() {
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

	public int getNumero() {
		return numero;
	}

	protected void setNumero(int numero) {
		this.numero = numero;
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

		final Financeiro f = WebServicesClient.getFinanceiroWS();
		if (!f.solicitaCobrancaTaxaInscricao(new br.usp.poli.pece.ws.bl.Aluno(aluno), curso.getCodCurso()))
			System.err.println("Atenção: Financeiro não aceitou solicitacao de cobrança de taxa de inscrição!");

		Matricula matricula = new Matricula(aluno, curso);
		DAOFactory.getMatriculaDAO().makePersistent(matricula);

		return matricula;
	}
	
	public static enum Status { PAGAMENTO_PENDENTE, PAGO, AGENDAR_ENTREVISTA, MATRICULADO, RECUSADO }
}
