package br.usp.poli.pece.bl.estruturas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CursoComplementar {

	@Id @GeneratedValue
	private long id;
	
	private String descricao; // descricao do curso
	
	private String periodo; // periodo do curso
	
	private short duracao; // duracao em horas do curso

	
	public long getId() {
		return id;
	}
	protected void setId(long id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getPeriodo() {
		return periodo;
	}
	
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	public short getDuracao() {
		return duracao;
	}
	
	public void setDuracao(short duracao) {
		this.duracao = duracao;
	}
	
}