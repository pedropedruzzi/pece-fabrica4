package br.usp.poli.pece.bl;

import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class Aluno extends Usuario {
	@OneToMany(mappedBy="aluno")
	private Set<Matricula> matriculas;
	
	/*
	@OneToMany(mappedBy="aluno")
	private Set<Inscricao> inscricoes;
	*/
	
	@OneToMany(mappedBy="aluno")
	private Set<Inscricao> inscricoes;
	
}
