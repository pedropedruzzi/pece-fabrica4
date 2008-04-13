package br.usp.poli.pece.bl;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.usp.poli.pece.db.DAOFactory;

@Entity
public class Disciplina {
	@Id @GeneratedValue
	protected long id;
	
	@Column(nullable=false, unique=true)
	private String codDisciplina;
	
	@Column(nullable=false)
	private String nome;
	
	private short cargaHoraria;
	private String descricao;
	private String materialApoio;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(nullable=false, updatable=false)
	private Curso curso;

	public String getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public short getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(short cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMaterialApoio() {
		return materialApoio;
	}

	public void setMaterialApoio(String materialApoio) {
		this.materialApoio = materialApoio;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public void persist(Disciplina disciplina) {
		DAOFactory.getDisciplinaDAO().makePersistent(disciplina);
	}
	
	
}
