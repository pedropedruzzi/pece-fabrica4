package br.usp.poli.pece.ws;

import java.util.List;
import javax.jws.WebService;

import br.usp.poli.pece.ws.bl.Aluno;

@WebService(name="listaDesempenhoAlunos")
public interface AcademicoDesempenho{
	
	public List<Aluno> consultaDesempenhoAluno(String strFiltro);
	public List<Aluno> listaDesempenhoTodosAlunos();
}