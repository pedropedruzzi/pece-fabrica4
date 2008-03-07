package br.usp.poli.pece.ws;

import java.util.List;

import javax.jws.WebService;

import br.usp.poli.pece.bl.Usuario;

@WebService(name="listaAlunos")
public interface AcademicoUsuario {
	
	public List<Usuario> consultaUsuarios(String strFiltro);
}
