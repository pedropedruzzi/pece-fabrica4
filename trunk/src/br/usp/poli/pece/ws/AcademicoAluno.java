package br.usp.poli.pece.ws;

import java.util.List;
import javax.jws.WebService;

import br.usp.poli.pece.ws.bl.Aluno;

@WebService(name="listaAlunos")
public interface AcademicoAluno {
	
	public List<Aluno> consultaAluno(String strFiltro);
	public List<Aluno> listaTodosAlunos();
}
