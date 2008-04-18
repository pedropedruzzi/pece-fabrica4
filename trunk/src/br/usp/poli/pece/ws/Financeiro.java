package br.usp.poli.pece.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.usp.poli.pece.ws.bl.Aluno;

@WebService(name="Financeiro")
public interface Financeiro {
	/**
	 * Deverá ser chamado pelo módulo acadêmico para solicitar a cobrança da taxa de inscrição padrão
	 * sobre o aluno. O sistema deverá guardar o id da solicitação para informar a quitação do pagamento.
	 * @param aluno
	 * @param curso
	 * @param idSolicitacao
	 * @return true, se a solicitação foi aceita
	 */
	@WebMethod
	public abstract boolean solicitaCobrancaTaxaInscricao(Aluno aluno, String curso, long idSolicitacao);
	
	/**
	 * 
	 * Deverá ser chamado pelo módulo acadêmico ao realizar uma matrícula, informando ao sistema
	 * financeiro que o aluno deve ser cobrado mensalmente com o valor do curso
	 * @param aluno
	 * @param curso
	 * @param idMatricula
	 * @return true, se a solicitação foi aceita
	 */
	@WebMethod
	public abstract boolean solicitaMatricula(Aluno aluno, String curso, long idMatricula);
}
