package br.usp.poli.pece.ws;

import java.util.LinkedList;
import java.util.List;
import javax.jws.WebService;

import br.usp.poli.pece.db.DAOFactory;
import br.usp.poli.pece.db.DataBaseUtil;
import br.usp.poli.pece.ws.bl.Aluno;
import br.usp.poli.pece.ws.bl.Disciplina;

@WebService(endpointInterface="br.usp.poli.pece.ws.AcademicoAluno")
public class AcademicoEstrategicoImpl implements AcademicoEstrategico {
	
	/***
	 * ALUNO
	 **/
	public List<Aluno> consultaAluno(String strFiltro) {
		List<br.usp.poli.pece.bl.Aluno> lista = br.usp.poli.pece.bl.Aluno.consultaAluno(strFiltro);
		List<Aluno> listaD = new LinkedList<Aluno>();
		
		for (br.usp.poli.pece.bl.Aluno a : lista) {
			listaD.add(new Aluno(a));
		}
		
		return listaD;
	}

	@Override
	public List<Aluno> listaTodosAlunos() {
		DataBaseUtil.getSessionFactory().getCurrentSession().beginTransaction();
		List<br.usp.poli.pece.bl.Aluno> lista = DAOFactory.getAlunoDAO().findAll();
		List<Aluno> listaD = new LinkedList<Aluno>();
		
		for (br.usp.poli.pece.bl.Aluno a : lista) {
			listaD.add(new Aluno(a));
		}
		
		DataBaseUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		return listaD;
	}
	
	/***
	 * DISCIPLINAS
	 */
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
	
	/***
	 * DESEMPENHO
	 */
	//TODO: implementar funcoes
	public List<Aluno> consultaDesempenhoAluno(String strFiltro)
	{
		List<Aluno> listaD = new LinkedList<Aluno>();
		return listaD;
	}
	public List<Aluno> listaDesempenhoTodosAlunos()
	{
		List<Aluno> listaD = new LinkedList<Aluno>();
		return listaD;
	}
	
	
	
	
	
//	public static void main(String[] args) {
//		AcademicoAluno aa = new AcademicoAlunoImpl();
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
