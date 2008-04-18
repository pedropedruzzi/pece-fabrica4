package br.usp.poli.pece.ws;

import java.util.LinkedList;
import java.util.List;
import javax.jws.WebService;

import br.usp.poli.pece.db.DAOFactory;
import br.usp.poli.pece.db.DataBaseUtil;
import br.usp.poli.pece.ws.bl.Disciplina;

@WebService(endpointInterface="br.usp.poli.pece.ws.AcademicoDisciplina")
public class AcademicoDisciplinaImpl implements AcademicoDisciplina {
	
	//lista todas disciplinas
	@Override
	public List<Disciplina> listaTodasDisciplinas() {
		DataBaseUtil.getSessionFactory().getCurrentSession().beginTransaction();
		List<br.usp.poli.pece.bl.Disciplina> lista = DAOFactory.getDisciplinaDAO().findAll();
		List<Disciplina> listaD = new LinkedList<Disciplina>();
		
		for (br.usp.poli.pece.bl.Disciplina d : lista) {
			listaD.add(new Disciplina(d));
		}
		
		DataBaseUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		return listaD;
	}
	
//	public static void main(String[] args) {
//		AcademicoAluno aa = new AcademicoDisciplinaImpl();
//		
//		List<Aluno> alunos = aa.consultaAluno(null);
//		
//		System.out.println("Found " + alunos.size() + " alunos!");
//		
//		for (Aluno a : alunos) {
//			System.out.println(a.cpf);
//		}
//	}
}
