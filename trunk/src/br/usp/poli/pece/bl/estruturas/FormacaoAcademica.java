package br.usp.poli.pece.bl.estruturas;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FormacaoAcademica {

	@Id @GeneratedValue
	private long id;
	
	private String formacao;
	private String escola;
	private Date anoFormacao;
	
	public long getId() {
		return id;
	}
	protected void setId(long id) {
		this.id = id;
	}
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	public String getEscola() {
		return escola;
	}
	public void setEscola(String escola) {
		this.escola = escola;
	}
	public Date getAnoFormacao() {
		return anoFormacao;
	}
	public void setAnoFormacao(Date anoFormacao) {
		this.anoFormacao = anoFormacao;
	}
}