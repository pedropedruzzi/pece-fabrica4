package br.usp.poli.pece.ws;

import br.usp.poli.pece.bl.Matricula;
import br.usp.poli.pece.bl.Matricula.Status;
import br.usp.poli.pece.db.DAOFactory;
import br.usp.poli.pece.db.DataBaseUtil;

public class AcademicoFinanceiroImpl implements AcademicoFinanceiro {

	@Override
	public void informaPagamento(long idSolicitacao) {
		DataBaseUtil.getSessionFactory().getCurrentSession().beginTransaction();
		
		// por conven��o o idSolicitacao � um idMatricula
		Matricula m = DAOFactory.getMatriculaDAO().findById(idSolicitacao);
		if (m == null) {
			System.err.println("WSFinanceiro: Erro! idSolicitacao n�o corresponde a nenhuma matr�cula!");
			return;
		}
		
		if (m.getStatus() != Status.PAGAMENTO_PENDENTE) {
			System.err.println("WSFinanceiro: Erro! Matr�cula j� estava paga!");
			return;
		}
		
		m.setStatus(Status.PAGO);
		DAOFactory.getMatriculaDAO().makePersistent(m);
		
		DataBaseUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		
	}

}
