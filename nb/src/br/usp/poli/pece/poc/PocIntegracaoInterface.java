package br.usp.poli.pece.poc;

import java.util.List;

import javax.jws.WebService;

import br.usp.poli.pece.bl.Pessoa;
import br.usp.poli.pece.bl.Usuario;

@WebService(name="listaAlunos")
public interface PocIntegracaoInterface {
	
	public List<Pessoa> listaAlunos();
	
	public List<Usuario> consultaUsuarios(String strFiltro);
}
