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
	
	public static void cadastroAluno(Pessoa aluno) {
				
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		
		//try {
		//	aluno.setNascimento(sdf.parse("27/04/1986"));
		//} catch (ParseException e) {}
		//p.setNome("Pedro Rodrigues Nacione Pedruzzi");
		//p.setEndereco("Alameda Rouxinol, 180 - Jardim do Sol - Santo André - SP");
		//p.setTelefone(1144210284);
		
		dbs.save(aluno);
		dbs.getTransaction().commit();
		
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
