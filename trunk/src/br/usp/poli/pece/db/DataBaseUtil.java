package br.usp.poli.pece.db;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.usp.poli.pece.bl.*;

public class DataBaseUtil {

	private static final SessionFactory sessionFactory;
	private static final AnnotationConfiguration cfg;

	static {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			cfg = new AnnotationConfiguration();
			cfg.configure();
			
			cfg.addAnnotatedClass(Aluno.class);
			cfg.addAnnotatedClass(Curso.class);
			cfg.addAnnotatedClass(Disciplina.class);
			cfg.addAnnotatedClass(Funcionario.class);
			cfg.addAnnotatedClass(Inscricao.class);
			cfg.addAnnotatedClass(Matricula.class);
			cfg.addAnnotatedClass(Nota.class);
			cfg.addAnnotatedClass(Pessoa.class);
			cfg.addAnnotatedClass(Professor.class);
			cfg.addAnnotatedClass(Turma.class);
			cfg.addAnnotatedClass(Usuario.class);
			
			
			sessionFactory = cfg.buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	

	
	public static void main(String[] args) throws ParseException {
		//criaPedro();
		exportaSchema();
	}
	
	private static void exportaSchema() {
		boolean criaMesmo = false;
		SchemaExport schema = new SchemaExport(cfg);
		schema.setOutputFile("sql/create.sql");
		schema.create(false, criaMesmo);
	}
	
	private static void criaPedro() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		
		Pessoa p = new Pessoa();
		try {
			p.setNascimento(sdf.parse("27/04/1986"));
		} catch (ParseException e) {}
		p.setNome("Pedro Rodrigues Nacione Pedruzzi");
		p.setEndereco("Alameda Rouxinol, 180 - Jardim do Sol - Santo Andr� - SP");
		p.setTelefone(1144210284);
		
		dbs.save(p);
		dbs.getTransaction().commit();
		
	}

}
