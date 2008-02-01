package br.usp.poli.pece.poc;

import java.util.ArrayList;

public class PocMain {
	
	
	public static void main(String[] args)
	{
	
	PocIntegracao poc = new PocIntegracao();
	ArrayList<String> lista = poc.ListaAlunos();
	System.out.println(lista);
	}
	
}
