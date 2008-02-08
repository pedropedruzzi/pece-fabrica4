package br.usp.poli.pece.poc;

import java.util.ArrayList;
import java.util.List;

import javax.jws.*;

@WebService(endpointInterface="br.usp.poli.pece.poc.PocIntegracaoInterface")

public class PocIntegracao implements PocIntegracaoInterface {
	
	public List<String> listaAlunos() {
		List<String> listaAlunos = new ArrayList<String>();
		
		listaAlunos.add("Virgilio");
		listaAlunos.add("Gabriel");
		
		return listaAlunos;
	}
}
