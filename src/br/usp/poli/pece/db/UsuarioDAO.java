package br.usp.poli.pece.db;

import java.util.List;

import org.hibernate.Session;

import br.usp.poli.pece.bl.Usuario;

public class UsuarioDAO {
	
	//TODO: BD
	public static List<Usuario> ConsultaUsuario(String strFiltro) {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		

		//O filtro passado como parametro vai conter um pedaço do nome do
		//usuario. Pode ser vazio tambem.
	    List<Usuario> result = (List<Usuario>)dbs.createQuery("from Pessoa").list();
	    System.out.println("TESTE");
	    //dbs.getTransaction().commit();
	    
	    return result;
	}
	
	//TODO: BD
	public static void cadastraUsuario(Usuario objUsuario) {
		
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		
		dbs.save(objUsuario);
		dbs.getTransaction().commit();
		
	}
	
	//TODO: BD
	public static void atualizaUsuario(Usuario objUsuario)
	{
		
	}
	
}
