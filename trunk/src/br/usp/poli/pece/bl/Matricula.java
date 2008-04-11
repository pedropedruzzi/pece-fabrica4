package br.usp.poli.pece.bl;

import java.util.Date;
import java.util.List;

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

import br.usp.poli.pece.db.MatriculaDAO;
import br.usp.poli.pece.db.UsuarioDAO;

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

	public void cadastrarMatricula(Matricula matricula) {
		MatriculaDAO.cadastroMatricula(matricula);
	}
	
	public void matricularAluno(Matricula matricula) {
		
	}
	
	public static boolean realizaMatricula(long idAluno, int codCurso) {
		try {
			Aluno a = (Aluno)UsuarioDAO.getUsuarioById(idAluno);
			
			//TODO: REALIZAR A PORRA DA MATRICULA
		
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public static enum Status { PAGAMENTO_PENDENTE, PAGO, AGENDAR_ENTREVISTA, MATRICULADO, RECUSADO }
}
