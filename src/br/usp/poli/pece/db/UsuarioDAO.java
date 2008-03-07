package br.usp.poli.pece.db;

import java.util.List;

import org.hibernate.Session;

import br.usp.poli.pece.bl.Usuario;
import br.usp.poli.pece.bl.Aluno;

public class UsuarioDAO {
	
	/*
	 * Consulta usuarios passando parte do nome
	 */
	public static List<Usuario> consultaUsuario(String strFiltro) {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();

		//TODO: Considerar o filtro
	    List<Usuario> result = (List<Usuario>)dbs.createQuery("from Usuario").list();
	    
	    dbs.getTransaction().commit();
	    
	    return result;
	}

	/*
	 * Consulta alunos passando parte do nome
	 */
	public static List<Aluno> consultaAluno(String strFiltro) {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();

		//TODO: Considerar o filtro e o tipo==aluno
	    List<Aluno> result = (List<Aluno>)dbs.createQuery("from Usuario").list();
	    
	    dbs.getTransaction().commit();
	    
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
