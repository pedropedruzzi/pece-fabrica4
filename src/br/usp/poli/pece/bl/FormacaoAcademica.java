package br.usp.poli.pece.bl;

import java.util.Date;

public class FormacaoAcademica {
	
	private String formacao;
	private String escola;
	private Date anoFormacao;
	
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