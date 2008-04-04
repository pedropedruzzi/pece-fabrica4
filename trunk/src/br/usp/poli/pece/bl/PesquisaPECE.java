package br.usp.poli.pece.bl;

import java.util.Date;

public class PesquisaPECE {
	
	// conhecimento do curso?
	private boolean malaDiretaFolheto = false;
	private boolean malaDiretaEmail = false;
	private boolean indicacaoProfessorPECE = false;
	private boolean indicacaoEmpresa = false;
	private boolean indicacaoAlunoPECE = false;
	private boolean indicacaoExAlunoPECE = false;
	private boolean anuncioJornal = false;
	private boolean anuncioRevista = false;
	private boolean internetSitePesquisa = false;
	
	private boolean outros = false;
	private String descricaoOutros;
	
	public boolean isMalaDiretaFolheto() {
		return malaDiretaFolheto;
	}
	public void setMalaDiretaFolheto(boolean malaDiretaFolheto) {
		this.malaDiretaFolheto = malaDiretaFolheto;
	}
	public boolean isMalaDiretaEmail() {
		return malaDiretaEmail;
	}
	public void setMalaDiretaEmail(boolean malaDiretaEmail) {
		this.malaDiretaEmail = malaDiretaEmail;
	}
	public boolean isIndicacaoProfessorPECE() {
		return indicacaoProfessorPECE;
	}
	public void setIndicacaoProfessorPECE(boolean indicacaoProfessorPECE) {
		this.indicacaoProfessorPECE = indicacaoProfessorPECE;
	}
	public boolean isIndicacaoEmpresa() {
		return indicacaoEmpresa;
	}
	public void setIndicacaoEmpresa(boolean indicacaoEmpresa) {
		this.indicacaoEmpresa = indicacaoEmpresa;
	}
	public boolean isIndicacaoAlunoPECE() {
		return indicacaoAlunoPECE;
	}
	public void setIndicacaoAlunoPECE(boolean indicacaoAlunoPECE) {
		this.indicacaoAlunoPECE = indicacaoAlunoPECE;
	}
	public boolean isIndicacaoExAlunoPECE() {
		return indicacaoExAlunoPECE;
	}
	public void setIndicacaoExAlunoPECE(boolean indicacaoExAlunoPECE) {
		this.indicacaoExAlunoPECE = indicacaoExAlunoPECE;
	}
	public boolean isAnuncioJornal() {
		return anuncioJornal;
	}
	public void setAnuncioJornal(boolean anuncioJornal) {
		this.anuncioJornal = anuncioJornal;
	}
	public boolean isAnuncioRevista() {
		return anuncioRevista;
	}
	public void setAnuncioRevista(boolean anuncioRevista) {
		this.anuncioRevista = anuncioRevista;
	}
	public boolean isInternetSitePesquisa() {
		return internetSitePesquisa;
	}
	public void setInternetSitePesquisa(boolean internetSitePesquisa) {
		this.internetSitePesquisa = internetSitePesquisa;
	}
	public boolean isOutros() {
		return outros;
	}
	public void setOutros(boolean outros) {
		this.outros = outros;
	}
	public String getDescricaoOutros() {
		return descricaoOutros;
	}
	public void setDescricaoOutros(String descricaoOutros) {
		this.descricaoOutros = descricaoOutros;
	}
	
	

}