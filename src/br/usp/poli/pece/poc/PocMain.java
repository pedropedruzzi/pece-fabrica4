package br.usp.poli.pece.poc;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class PocMain {
	
	
	public static void main(String[] args)
	{
	
	PocIntegracao poc = new PocIntegracao();
	ArrayList lista = poc.ListaAlunos();
	System.out.println(lista);
	}
	
}
