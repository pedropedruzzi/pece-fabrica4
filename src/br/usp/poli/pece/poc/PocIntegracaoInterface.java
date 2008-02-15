package br.usp.poli.pece.poc;

import java.util.List;

import javax.jws.*;

import br.usp.poli.pece.bl.Pessoa;

@WebService(name="listaAlunos")

public interface PocIntegracaoInterface {
	
	public List<Pessoa> listaAlunos();
}
