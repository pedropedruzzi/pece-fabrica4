package br.usp.poli.pece.db;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;

import br.usp.poli.pece.bl.Aluno;
import br.usp.poli.pece.bl.Pessoa;
import br.usp.poli.pece.bl.Usuario;
import br.usp.poli.pece.poc.PocIntegracao;

public class UsuarioDAO {
	public static List<Usuario> ConsultaUsuario(String strFiltro) {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		
		//TODO:
		//O filtro passado como parametro vai conter um pedaço do nome do
		//usuario. Pode ser vazio tambem.
	    List<Usuario> result = (List<Usuario>)dbs.createQuery("from Pessoa").list();
	    System.out.println("TESTE");
	    //dbs.getTransaction().commit();
	    
	    return result;
	}
	
	public static void cadastraUsuario(Usuario usuario) {
		
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		
		//try {
		//	aluno.setNascimento(sdf.parse("27/04/1986"));
		//} catch (ParseException e) {}
		//p.setNome("Pedro Rodrigues Nacione Pedruzzi");
		//p.setEndereco("Alameda Rouxinol, 180 - Jardim do Sol - Santo André - SP");
		//p.setTelefone(1144210284);
		
		//dbs.save(aluno);
		//dbs.getTransaction().commit();
		
	}
	
	public static void atualizaUsuario(Usuario objUsuario)
	{
		
	}
	
}
