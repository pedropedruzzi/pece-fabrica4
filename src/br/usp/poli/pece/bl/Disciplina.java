package br.usp.poli.pece.bl;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Disciplina {
	@Id
	private String codDisciplina;
	
	private String nome;
	private short cargaHoraria;
	private String descricao;
	private String materialApoio;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Curso curso;
}
