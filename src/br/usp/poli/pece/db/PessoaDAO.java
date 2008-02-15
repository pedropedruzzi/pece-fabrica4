package br.usp.poli.pece.db;

import java.util.List;

import org.hibernate.Session;

import br.usp.poli.pece.bl.Pessoa;

public class PessoaDAO {
	public static List<Pessoa> listaAlunos() {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();

	    List<Pessoa> result = (List<Pessoa>)dbs.createQuery("from Pessoa").list();

	    dbs.getTransaction().commit();

	    return result;
	}
}
