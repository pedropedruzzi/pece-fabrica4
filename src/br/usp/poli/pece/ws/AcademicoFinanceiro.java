package br.usp.poli.pece.ws;

public interface AcademicoFinanceiro {
	/*
	 * Deve ser chamado pelo m�dulo financeiro quando o pagamento
	 * relativo a solicita��o idSolicitacao for quitado.
	 */
	public abstract void informaPagamento(long idSolicitacao);
}
