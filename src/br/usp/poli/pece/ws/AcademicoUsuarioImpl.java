package br.usp.poli.pece.ws;

import java.util.List;

import javax.jws.WebService;

import br.usp.poli.pece.bl.Usuario;
import br.usp.poli.pece.db.UsuarioDAO;

@WebService(endpointInterface="br.usp.poli.pece.ws.AcademicoUsuario")
public class AcademicoUsuarioImpl implements AcademicoUsuario {
	
	//Lista alunos
	public List<Usuario> consultaUsuarios(String strFiltro) {
		return UsuarioDAO.ConsultaUsuario(strFiltro);
	}
}
