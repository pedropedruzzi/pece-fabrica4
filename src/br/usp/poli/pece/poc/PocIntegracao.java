package br.usp.poli.pece.poc;

import java.util.List;

import javax.jws.WebService;

import br.usp.poli.pece.bl.Pessoa;
import br.usp.poli.pece.bl.Usuario;
import br.usp.poli.pece.db.PessoaDAO;
import br.usp.poli.pece.db.UsuarioDAO;

@WebService(endpointInterface="br.usp.poli.pece.poc.PocIntegracaoInterface")
public class PocIntegracao implements PocIntegracaoInterface {
	
	public List<Pessoa> listaAlunos() {
		System.out.println("teste");
		return PessoaDAO.listaAlunos();
	}
	
	//Lista alunos
	public List<Usuario> consultaUsuarios(String strFiltro) {
		return UsuarioDAO.ConsultaUsuario(strFiltro);
	}
}
