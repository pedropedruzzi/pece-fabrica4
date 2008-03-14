package br.usp.poli.pece.db;

import java.util.List;

import org.hibernate.Session;

import br.usp.poli.pece.bl.Usuario;
import br.usp.poli.pece.bl.Aluno;

public class UsuarioDAO {
	
	/*
	 * Consulta usuarios passando parte do nome
	 */
	/** Consulta Usuario
	 *  
	 * @param 		strFiltro		Filtro da consulta
	 * @return		List<Usuario>	Lista de usuarios correspondente a pesquisa
	 */
	public static List<Usuario> consultaUsuario(String strFiltro) {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();

		//TODO: Considerar o filtro
	    List<Usuario> result = (List<Usuario>)dbs.createQuery("from Usuario").list();
	    
	    dbs.getTransaction().commit();
	    
	    return result;
	}

	/** Consulta Alunos
	 * @param 		strFiltro		Filtro da consulta
	 * @return		List<Aluno>		Lista de alunos	correspondente a pesquisa
	 * 
	 */
	public static List<Aluno> consultaAluno(String strFiltro) {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();

		//TODO: Considerar o filtro e o tipo==aluno
	    List<Aluno> result = (List<Aluno>)dbs.createQuery("from Usuario").list();
	    
	    dbs.getTransaction().commit();
	    
	    return result;
	}

	
	/** Cadastra Usuário
	 * @param		objUsuario		Usuario validado
	 * @return		boolean			Verdadeiro (cadastro com sucesso)/Falso
	 */
	public static void cadastraUsuario(Usuario objUsuario) {
		
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		
		dbs.save(objUsuario);
		dbs.getTransaction().commit();
		
	}
	
	/** Atualiza Usuario
	 *  @param 		objUsuario	Usuario validado
	 *  @return 		boolean		Confirmacao da atualizacao (verdadeiro/falso)
	 *	TODO: criar funcao atualizaUsuario
	 */
	public static void atualizaUsuario(Usuario objUsuario)
	{
		
	}
	
}
