package br.usp.poli.pece.ws;

import java.util.List;
import javax.jws.WebService;
import br.usp.poli.pece.ws.bl.Disciplina;


@WebService(name="listaDisciplinas")
public interface AcademicoDisciplina {
	
	public List<Disciplina> listaTodasDisciplinas();
}
