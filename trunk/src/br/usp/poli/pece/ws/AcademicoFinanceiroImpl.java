package br.usp.poli.pece.ws;

import br.usp.poli.pece.bl.Matricula;
import br.usp.poli.pece.bl.Matricula.Status;
import br.usp.poli.pece.db.DAOFactory;
import br.usp.poli.pece.db.DataBaseUtil;

public class AcademicoFinanceiroImpl implements AcademicoFinanceiro {

	@Override
	public void informaPagamento(long idSolicitacao) {
		DataBaseUtil.getSessionFactory().getCurrentSession().beginTransaction();
		
		// por convenção o idSolicitacao é um idMatricula
		Matricula m = DAOFactory.getMatriculaDAO().findById(idSolicitacao);
		if (m == null) {
			System.err.println("WSFinanceiro: Erro! idSolicitacao não corresponde a nenhuma matrícula!");
			return;
		}
		
		if (m.getStatus() != Status.PAGAMENTO_PENDENTE) {
			System.err.println("WSFinanceiro: Erro! Matrícula já estava paga!");
			return;
		}
		
		m.setStatus(Status.PAGO);
		DAOFactory.getMatriculaDAO().makePersistent(m);
		
		DataBaseUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		
	}

}
