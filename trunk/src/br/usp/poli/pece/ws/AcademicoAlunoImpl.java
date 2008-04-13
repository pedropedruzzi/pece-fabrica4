package br.usp.poli.pece.ws;

import java.util.LinkedList;
import java.util.List;
import javax.jws.WebService;

import br.usp.poli.pece.db.DAOFactory;
import br.usp.poli.pece.ws.bl.Aluno;

@WebService(endpointInterface="br.usp.poli.pece.ws.AcademicoAluno")
public class AcademicoAlunoImpl implements AcademicoAluno {
	
	//Lista alunos
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
		List<br.usp.poli.pece.bl.Aluno> lista = DAOFactory.getAlunoDAO().findAll();
		List<Aluno> listaD = new LinkedList<Aluno>();
		
		for (br.usp.poli.pece.bl.Aluno a : lista) {
			listaD.add(new Aluno(a));
		}
		
		return listaD;
	}
	
	public static void main(String[] args) {
		AcademicoAluno aa = new AcademicoAlunoImpl();
		
		List<Aluno> alunos = aa.consultaAluno(null);
		
		System.out.println("Found " + alunos.size() + " alunos!");
		
		for (Aluno a : alunos) {
			System.out.println(a.cpf);
		}
	}
}
