package br.usp.poli.pece.bl;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Curso {
	private String nome;
	
	@Id
	private String codCurso;
	
	
	private int cargaHoraria;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Professor coordenador;
	
	@OneToMany(mappedBy="curso")
	private Set<Disciplina> disciplinas;

	@OneToMany(mappedBy="curso")
	private Set<Matricula> matriculas;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Professor getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Professor coordenador) {
		this.coordenador = coordenador;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Set<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(Set<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	
	
	
}
