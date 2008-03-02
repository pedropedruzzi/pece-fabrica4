package br.usp.poli.pece.bl;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"turma_id", "aluno_id"})})
public class Inscricao {
	@Id @GeneratedValue
	private long id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="turma_id", nullable=false, updatable=false)
	private Turma turma;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="aluno_id", nullable=false, updatable=false)
	private Aluno aluno;
	
	private short presencas;
	
	@OneToMany(mappedBy="inscricao")
	private Set<Nota> notas;
	

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public short getPresencas() {
		return presencas;
	}

	public void setPresencas(short presencas) {
		this.presencas = presencas;
	}

	public Set<Nota> getNotas() {
		return notas;
	}

	public void setNotas(Set<Nota> notas) {
		this.notas = notas;
	}
	
	
}
