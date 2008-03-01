package br.usp.poli.pece.bl;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Turma {
	@Id
	private String codTurma;
	
	private Date dataRegistro;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Disciplina disciplina;
	
	@OneToMany(mappedBy="turma")
	private Set<Inscricao> inscricoes;
}
