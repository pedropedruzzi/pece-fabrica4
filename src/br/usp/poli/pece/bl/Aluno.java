package br.usp.poli.pece.bl;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import br.usp.poli.pece.bl.estruturas.CursosComplementares;
import br.usp.poli.pece.bl.estruturas.FormacaoAcademica;
import br.usp.poli.pece.bl.estruturas.HistoricoProfissional;
import br.usp.poli.pece.bl.estruturas.PesquisaPECE;

@Entity
public class Aluno extends Usuario {
	
	//@OneToMany(mappedBy="aluno")
	@Transient
	private Set<Matricula> matriculas;
	
	//@OneToMany(mappedBy="aluno")
	@Transient
	private Set<Inscricao> inscricoes;
	
	//@OneToMany(fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	@Transient
	private List<FormacaoAcademica> formacao;
	
	//@OneToMany(fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	@Transient
	private List<CursosComplementares> cursosComplementares;
	
	//@OneToOne
	@Transient
	private HistoricoProfissional historicoProfissional;
	
	private String qualificacao;
	
	private String motivacao;
	
	//@OneToOne
	@Transient
	private PesquisaPECE pesquisaPece;
	
	
	
	public Set<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(Set<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Set<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(Set<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}

	public List<FormacaoAcademica> getFormacao() {
		return formacao;
	}

	public void setFormacao(List<FormacaoAcademica> formacao) {
		this.formacao = formacao;
	}

	public List<CursosComplementares> getCursosComplementares() {
		return cursosComplementares;
	}

	public void setCursosComplementares(
			List<CursosComplementares> cursosComplementares) {
		this.cursosComplementares = cursosComplementares;
	}

	public HistoricoProfissional getHistoricoProfissional() {
		return historicoProfissional;
	}

	public void setHistoricoProfissional(HistoricoProfissional historicoProfissional) {
		this.historicoProfissional = historicoProfissional;
	}

	public String getQualificacao() {
		return qualificacao;
	}

	public void setQualificacao(String qualificacao) {
		this.qualificacao = qualificacao;
	}

	public String getMotivacao() {
		return motivacao;
	}

	public void setMotivacao(String motivacao) {
		this.motivacao = motivacao;
	}

	public PesquisaPECE getPesquisaPece() {
		return pesquisaPece;
	}

	public void setPesquisaPece(PesquisaPECE pesquisaPece) {
		this.pesquisaPece = pesquisaPece;
	}
	
}
