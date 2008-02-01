package br.usp.poli.pece.poc;

import java.util.ArrayList;

import javax.jws.*;

@WebService(name="listaAlunos")

public interface PocIntegracaoInterface {
	
	public ArrayList ListaAlunos();
}
