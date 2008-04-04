package br.usp.poli.pece.db;

import java.util.List;

import org.hibernate.Session;
import br.usp.poli.pece.bl.Usuario;
import br.usp.poli.pece.bl.Aluno;

public class UsuarioDAO {
	
	public static Usuario getUsuarioByLogin(String login) {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		
		Usuario u = (Usuario) dbs.createQuery("from Usuario as u where u.login=?")
	    	.setString(0, login).uniqueResult();
		
		dbs.getTransaction().commit();
		
		return u;
	}
	
	public static Usuario getUsuarioById(long id) {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		
		Usuario u = (Usuario) dbs.createQuery("from Usuario as u where u.id=?")
	    	.setLong(0, id).uniqueResult();
		
		dbs.getTransaction().commit();
		
		return u;
	}
	
	/** Consulta Usuario
	 *  
	 * @param 		strFiltro		Filtro da consulta (parte do nome)
	 * @return		List<Usuario>	Lista de usuarios correspondente a pesquisa
	 */
	@SuppressWarnings("unchecked")
	public static List<Usuario> consultaUsuario(String strFiltro) {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();

	    List<Usuario> result = (List<Usuario>)dbs.createQuery("from Usuario as u where u.nome like ?")
	    	.setString(0, strFiltro).list();
	    
	    dbs.getTransaction().commit();
	    
	    return result;
	}

	/** Consulta Alunos
	 * @param 		strFiltro		Filtro da consulta
	 * @return		List<Aluno>		Lista de alunos	correspondente a pesquisa
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static List<Aluno> consultaAluno(String strFiltro) {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		
	    List<Aluno> result = (List<Aluno>)dbs.createQuery("from Aluno as a where a.nome like ?")
	    	.setString(0, strFiltro).list();
	    
	    dbs.getTransaction().commit();
	    
	    return result;
	}

	/**
	 * Lista todos os alunos
	 * 
	 * @return		List<Aluno>		Lista de todos os alunos cadastrados
	 */
	@SuppressWarnings("unchecked")
	public static List<Aluno> listaTodosAlunos() {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		
	    List<Aluno> result = (List<Aluno>)dbs.createQuery("from Aluno").list();
	    
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
	public static void updateUsuario(Usuario usuario) {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		
		dbs.update(usuario);
		
		dbs.getTransaction().commit();
	}
	
}
