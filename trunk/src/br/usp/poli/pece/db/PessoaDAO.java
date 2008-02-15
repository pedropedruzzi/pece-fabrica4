package br.usp.poli.pece.db;

import java.util.List;

import org.hibernate.Session;

import br.usp.poli.pece.bl.Pessoa;
import br.usp.poli.pece.poc.PocIntegracao;

public class PessoaDAO {
	public static List<Pessoa> listaAlunos() {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();

	    List<Pessoa> result = (List<Pessoa>)dbs.createQuery("from Pessoa").list();

	    dbs.getTransaction().commit();

	    return result;
	}
	
	public static void main(String[] args) {
		System.out.println("Vou chamar!!");
		List<Pessoa> l = PessoaDAO.listaAlunos();
		System.out.println("Retornou!");
		
		System.out.println("Tamanho: " + l.size());
		
		for (Pessoa p : l)
			System.out.println(p.getNome());
	}
}
