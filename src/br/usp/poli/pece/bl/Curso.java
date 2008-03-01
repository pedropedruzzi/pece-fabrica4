package br.usp.poli.pece.bl;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Curso {
	private String nome;
	
	@Id
	private String codCurso;
	
	
	private int cargaHoraria;
	private Professor coordenador;
	
	@OneToMany(mappedBy="curso")
	private Set<Disciplina> disciplinas;

	@OneToMany(mappedBy="curso")
	private Set<Matricula> matriculas;
}
