package br.usp.poli.pece.db;

import java.text.ParseException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.usp.poli.pece.bl.*;
import br.usp.poli.pece.bl.estruturas.CursoComplementar;
import br.usp.poli.pece.bl.estruturas.FormacaoAcademica;
import br.usp.poli.pece.bl.estruturas.HistoricoProfissional;
import br.usp.poli.pece.bl.estruturas.PesquisaPECE;

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
			cfg.addAnnotatedClass(Professor.class);
			cfg.addAnnotatedClass(Turma.class);
			cfg.addAnnotatedClass(Usuario.class);
			cfg.addAnnotatedClass(CursoComplementar.class);
			cfg.addAnnotatedClass(FormacaoAcademica.class);
			cfg.addAnnotatedClass(HistoricoProfissional.class);
			cfg.addAnnotatedClass(PesquisaPECE.class);
			
			
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
		//criaPedro2();
		exportaSchema();
	}
	
	private static void exportaSchema() {
		boolean criaMesmo = false;
		SchemaExport schema = new SchemaExport(cfg);
		schema.setOutputFile("sql/create.sql");
		schema.create(false, criaMesmo);
	}
}
