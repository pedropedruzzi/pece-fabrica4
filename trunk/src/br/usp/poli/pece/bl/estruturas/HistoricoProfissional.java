package br.usp.poli.pece.bl.estruturas;

import java.util.Date;

public class HistoricoProfissional {
	
	// instituicao/empresa onde trabalha 
	private String empresaAtual;
	// ramo de atividade
	private String ramoAtividade;
	// cargo
	private String cargo;
	// endereco comercial
	private String endComercial;
	private String endComplemento;
	private String endBairro;
	private String endCEP;
	private String endCidade;
	private String endUF;
	// telefone + ramal
	private String telefone;
	// email empresa
	private String email;
	// atividades profissionais anteriores
	private String atividadesAnteriores;
		
	public String getEmpresaAtual() {
		return empresaAtual;
	}
	public void setEmpresaAtual(String empresaAtual) {
		this.empresaAtual = empresaAtual;
	}
	public String getRamoAtividade() {
		return ramoAtividade;
	}
	public void setRamoAtividade(String ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getEndComercial() {
		return endComercial;
	}
	public void setEndComercial(String endComercial) {
		this.endComercial = endComercial;
	}
	public String getEndComplemento() {
		return endComplemento;
	}
	public void setEndComplemento(String endComplemento) {
		this.endComplemento = endComplemento;
	}
	public String getEndBairro() {
		return endBairro;
	}
	public void setEndBairro(String endBairro) {
		this.endBairro = endBairro;
	}
	public String getEndCEP() {
		return endCEP;
	}
	public void setEndCEP(String endCEP) {
		this.endCEP = endCEP;
	}
	public String getEndCidade() {
		return endCidade;
	}
	public void setEndCidade(String endCidade) {
		this.endCidade = endCidade;
	}
	public String getEndUF() {
		return endUF;
	}
	public void setEndUF(String endUF) {
		this.endUF = endUF;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAtividadesAnteriores() {
		return atividadesAnteriores;
	}
	public void setAtividadesAnteriores(String atividadesAnteriores) {
		this.atividadesAnteriores = atividadesAnteriores;
	}
}