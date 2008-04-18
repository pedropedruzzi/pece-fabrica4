package br.usp.poli.pece.ws;

import java.util.List;
import javax.jws.WebService;

import br.usp.poli.pece.ws.bl.Aluno;
import br.usp.poli.pece.ws.bl.Disciplina;

//Fábrica do Elefantinho
@WebService(name="academicoEstrategico")
public interface AcademicoEstrategico {
	//aluno
	public List<Aluno> consultaAluno(String strFiltro);
	public List<Aluno> listaTodosAlunos();
	//desempenho
	public List<Aluno> consultaDesempenhoAluno(String strFiltro);
	public List<Aluno> listaDesempenhoTodosAlunos();
	//disciplina
	public List<Disciplina> listaTodasDisciplinas();
}
