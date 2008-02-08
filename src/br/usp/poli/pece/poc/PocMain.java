package br.usp.poli.pece.poc;

import java.util.List;

public class PocMain {


	public static void main(String[] args) {

		PocIntegracao poc = new PocIntegracao();
		List<String> lista = poc.listaAlunos();
		System.out.println(lista);
	}

}
