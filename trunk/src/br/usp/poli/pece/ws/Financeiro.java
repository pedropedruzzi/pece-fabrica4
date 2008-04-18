package br.usp.poli.pece.ws;

import br.usp.poli.pece.ws.bl.Aluno;

public interface Financeiro {
	public abstract boolean solicitaCobrancaTaxaInscricao(Aluno aluno, String curso);
	public abstract boolean solicitaMatricula(Aluno aluno, String curso);
}
