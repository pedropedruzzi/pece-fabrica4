package br.usp.poli.pece.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name="AcademicoFinanceiro")
public interface AcademicoFinanceiro {
	/*
	 * Deve ser chamado pelo m�dulo financeiro quando o pagamento
	 * relativo a solicita��o idSolicitacao for quitado.
	 */
	@WebMethod
	public abstract void informaPagamento(long idSolicitacao);
}
