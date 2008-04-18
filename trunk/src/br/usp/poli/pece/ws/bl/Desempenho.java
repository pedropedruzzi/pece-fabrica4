package br.usp.poli.pece.ws.bl;

import br.usp.poli.pece.bl.Inscricao;

public class Desempenho {

	public long cpf;
	public String codDisciplina;
	public float nota;
	
	public Desempenho(Inscricao i) {
		this.cpf = i.getAluno().getCpf();
		this.codDisciplina = i.getTurma().getDisciplina().getCodDisciplina();
		this.nota = i.getNota()/10f;
	}
	
}
