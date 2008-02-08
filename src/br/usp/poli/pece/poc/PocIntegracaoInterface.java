package br.usp.poli.pece.poc;

import java.util.List;

import javax.jws.*;

@WebService(name="listaAlunos")

public interface PocIntegracaoInterface {
	
	public List<String> listaAlunos();
}
