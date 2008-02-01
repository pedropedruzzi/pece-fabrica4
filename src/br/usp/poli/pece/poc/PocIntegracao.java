package br.usp.poli.pece.poc;

import java.util.ArrayList;
import javax.jws.*;

@WebService(endpointInterface="br.usp.poli.pece.poc.PocIntegracaoInterface")

public class PocIntegracao implements PocIntegracaoInterface {
	
	public PocIntegracao()
	{
	}
	
	public ArrayList<String> ListaAlunos()
	{
		ArrayList<String> listaAlunos = new ArrayList<String>(); 
		
		String[] nome = {"Virgilio", "Gabriel"};
		listaAlunos.add(nome[0]);
		listaAlunos.add(nome[1]);
		
		return listaAlunos;
	}
}
