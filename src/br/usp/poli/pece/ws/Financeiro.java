package br.usp.poli.pece.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.usp.poli.pece.ws.bl.Aluno;

@WebService(name="Financeiro")
public interface Financeiro {
	/**
	 * Dever� ser chamado pelo m�dulo acad�mico para solicitar a cobran�a da taxa de inscri��o padr�o
	 * sobre o aluno. O sistema dever� guardar o id da solicita��o para informar a quita��o do pagamento.
	 * @param aluno
	 * @param curso
	 * @param idSolicitacao
	 * @return true, se a solicita��o foi aceita
	 */
	@WebMethod
	public abstract boolean solicitaCobrancaTaxaInscricao(Aluno aluno, String curso, long idSolicitacao);
	
	/**
	 * 
	 * Dever� ser chamado pelo m�dulo acad�mico ao realizar uma matr�cula, informando ao sistema
	 * financeiro que o aluno deve ser cobrado mensalmente com o valor do curso
	 * @param aluno
	 * @param curso
	 * @param idMatricula
	 * @return true, se a solicita��o foi aceita
	 */
	@WebMethod
	public abstract boolean solicitaMatricula(Aluno aluno, String curso, long idMatricula);
}
