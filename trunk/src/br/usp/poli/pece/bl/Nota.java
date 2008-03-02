package br.usp.poli.pece.bl;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Nota {
	//TODO: inscricao faz parte da chave primaria!! @Id
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Inscricao inscricao;
	
	@Id
	private String nome;
	
	private short nota;
	
	

	public Inscricao getInscricao() {
		return inscricao;
	}

	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public short getNota() {
		return nota;
	}

	public void setNota(short nota) {
		this.nota = nota;
	}
	
	
	
}
