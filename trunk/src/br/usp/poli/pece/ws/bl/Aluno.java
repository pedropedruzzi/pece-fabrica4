package br.usp.poli.pece.ws.bl;

import java.util.Date;

import br.usp.poli.pece.bl.estruturas.HistoricoProfissional;

public class Aluno {
	
	public long id;
	public long cpf;
	public String nome;
	public char sexo;
	public Date dataNascimento;
	public String empresaAtual;
	public String ramoAtividade;
	public String cargo;

	public Aluno() {
		
	}
	
	public Aluno(br.usp.poli.pece.bl.Aluno a) {
		// Cria um ws.aluno a partir de bl.Aluno
		id = a.getId();
		cpf = a.getCpf();
		nome = a.getNome();
		sexo = a.getSexo();
		dataNascimento = a.getDataNascimento();
		
		HistoricoProfissional hp = a.getHistoricoProfissional();
		if (hp != null) {
			empresaAtual = hp.getEmpresaAtual();
			ramoAtividade = hp.getRamoAtividade();
			cargo = hp.getCargo();
		}
	}
}
