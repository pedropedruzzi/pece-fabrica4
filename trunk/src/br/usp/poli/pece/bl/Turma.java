package br.usp.poli.pece.bl;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.usp.poli.pece.db.TurmaDAO;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"codigo", "disciplina_id"})})
public class Turma {
	@Id @GeneratedValue
	protected long id;
	
	@Column(nullable=false)
	private Integer codigo;
	
	private Date dataRegistro;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="disciplina_id", nullable=false, updatable=false)
	private Disciplina disciplina;
	
	@OneToMany(mappedBy="turma")
	private Set<Inscricao> inscricoes;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Set<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(Set<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}
	
	
	
	public Curso getCurso() {
		return this.getDisciplina().getCurso();
	}
	
	
	// varrer a tabela de matícula e verificar o numero de alunos em
	// cada curso e criar as turmas
	public void criarTurmas() {
		this.setCodigo(TurmaDAO.getSeqNumber());
		TurmaDAO.cadastroTurma(Turma turma);
	}
	
	
}
