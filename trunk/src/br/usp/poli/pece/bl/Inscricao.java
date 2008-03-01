package br.usp.poli.pece.bl;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Inscricao {
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Turma turma;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Aluno aluno;
	
	private short presencas;
	
	private Map<String, Short> notas;
}
