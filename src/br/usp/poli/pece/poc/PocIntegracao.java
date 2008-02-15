package br.usp.poli.pece.poc;

import java.util.List;

import javax.jws.*;

import br.usp.poli.pece.bl.Pessoa;
import br.usp.poli.pece.db.PessoaDAO;

@WebService(endpointInterface="br.usp.poli.pece.poc.PocIntegracaoInterface")
public class PocIntegracao implements PocIntegracaoInterface {
	
	public List<Pessoa> listaAlunos() {
		System.out.println("teste");
		return PessoaDAO.listaAlunos();
	}
}