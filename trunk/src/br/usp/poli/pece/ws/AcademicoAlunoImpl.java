package br.usp.poli.pece.ws;

import java.util.List;

import javax.jws.WebService;

import br.usp.poli.pece.bl.Aluno;
import br.usp.poli.pece.db.UsuarioDAO;

@WebService(endpointInterface="br.usp.poli.pece.ws.AcademicoAluno")
public class AcademicoAlunoImpl implements AcademicoAluno {
	
	//Lista alunos
	public List<Aluno> consultaAluno(String strFiltro) {
		return UsuarioDAO.consultaAluno(strFiltro);
	}
}
