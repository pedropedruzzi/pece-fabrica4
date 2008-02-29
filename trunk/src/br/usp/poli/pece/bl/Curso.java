package br.usp.poli.pece.bl;

import javax.persistence.Entity;

@Entity
public class Curso {
	private String nome;
	private String codCurso;
	private int cargaHoraria;
	private Professor coordenador;
	//private Set<Disciplinas> disciplinas;
}
