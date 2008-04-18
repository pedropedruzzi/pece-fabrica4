package br.usp.poli.pece.ws;

public interface AcademicoFinanceiro {
	/*
	 * Deve ser chamado pelo módulo financeiro quando o pagamento
	 * relativo a solicitação idSolicitacao for quitado.
	 */
	public abstract void informaPagamento(long idSolicitacao);
}
