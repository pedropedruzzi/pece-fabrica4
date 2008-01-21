package br.usp.poli.pece.bl;

import javax.persistence.*;

import java.util.Date;

@Entity
public class Pessoa {
	@Id @GeneratedValue
	@Column(name="pessoa_id")
	private long id;
	
	
	private String nome;
	private Date nascimento;
	private String endereco;
	private long telefone;
	
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public long getId() {
		return id;
	}
	protected void setId(long id) {
		this.id = id;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getTelefone() {
		return telefone;
	}
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	
}
