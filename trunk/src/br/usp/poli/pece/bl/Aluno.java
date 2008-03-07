package br.usp.poli.pece.bl;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Aluno extends Usuario {
	
	//Construtor
	public Aluno ()
	{
		//TODO:
	}
	
	@OneToMany(mappedBy="aluno")
	private Set<Matricula> matriculas;
	
	@OneToMany(mappedBy="aluno")
	private Set<Inscricao> inscricoes;

	public Set<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(Set<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Set<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(Set<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}
	
	
	
}
