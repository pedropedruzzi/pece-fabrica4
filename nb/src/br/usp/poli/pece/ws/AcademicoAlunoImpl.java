package br.usp.poli.pece.ws;

import java.util.List;
import javax.jws.WebService;
import br.usp.poli.pece.bl.Aluno;

@WebService(endpointInterface="br.usp.poli.pece.ws.AcademicoAluno")
public class AcademicoAlunoImpl implements AcademicoAluno {
	
	//Lista alunos
	public List<Aluno> consultaAluno(String strFiltro) {
		return  Aluno.consultaAluno(strFiltro);
	}
	
	/*public static void main(String[] args) {
		AcademicoAluno aa = new AcademicoAlunoImpl();
		
		List<Aluno> alunos = aa.consultaAluno(null);
		
		System.out.println("Found " + alunos.size() + " alunos!");
		
		for (Aluno a : alunos) {
			System.out.println(a.getNome());
		}
	}*/
}
