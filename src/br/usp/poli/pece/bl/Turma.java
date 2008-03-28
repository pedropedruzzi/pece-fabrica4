package br.usp.poli.pece.bl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.Session;

import br.usp.poli.pece.db.CursoDAO;
import br.usp.poli.pece.db.DataBaseUtil;
import br.usp.poli.pece.db.DisciplinaDAO;
import br.usp.poli.pece.db.TurmaDAO;
import br.usp.poli.pece.db.UsuarioDAO;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"codigo", "disciplina_id"})})
@SequenceGenerator(name="TURMA", sequenceName="seq_turma")
public class Turma {
	@Id @GeneratedValue
	protected long id;
	
	@Column(nullable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TURMA")
	private int codigo;
	
	private Date dataRegistro;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="disciplina_id", nullable=false, updatable=false)
	private Disciplina disciplina;
	
	@OneToMany(mappedBy="turma")
	private Set<Inscricao> inscricoes;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Set<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(Set<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}
	
	
	
	public Curso getCurso() {
		return this.getDisciplina().getCurso();
	}
	
	
	// varrer a tabela de matícula e verificar o numero de alunos em
	// cada curso e criar as turmas
	public void criarTurmas() {
		this.setCodigo(TurmaDAO.getSeqNumber());
		//TurmaDAO.cadastroTurma(Turma turma);
	}
	
	public static void criatudo() {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		
		Professor p = new Professor();
		p.setNome("Jorge Risco");
		p.setEmail("jrisco@poli.usp.br");
		p.setLogin("jrisco");
		p.setSenha("1234");
		p.setCelular(1234);
		p.setTelefone(12345);
		
		dbs.save(p);

		Curso c = new Curso();
		c.setCargaHoraria((short)480);
		c.setCodCurso("1234");
		c.setNome("12345678");
		c.setCoordenador(p);
		
		dbs.save(c);
		
		Disciplina d = new Disciplina();
		d.setCodDisciplina("XYZ1234");
		d.setCargaHoraria((short)240);
		d.setNome("Discplina XYZ");
		d.setCurso(c);
		
		dbs.save(d);
		
		Turma t = new Turma();
		t.setDisciplina(d);
		
		dbs.save(t);
	    
	    dbs.getTransaction().commit();
	}
	
	public static void old() {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		
		dbs.get(Turma.class, new Long(0));
		
		Professor risco = (Professor) dbs.createQuery("from Professor as p where p.login=?")
	    	.setString(0, "jrisco").uniqueResult();
		
		System.out.println(risco.getNome());

	}
	
	public static void main(String[] args) {
		Professor risco = (Professor) UsuarioDAO.getUsuarioByLogin("jrisco");
		Curso c = CursoDAO.getCursoByCodigo("1234");
		Disciplina d = DisciplinaDAO.getDisciplinaByCodigo("XYZ1234");
		
		System.out.println(risco.getNome());
		System.out.println(c.getNome());
		System.out.println(d.getNome());
		
		Turma t2 = new Turma();
		t2.setDisciplina(d);
		

		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		dbs.save(t2);
		dbs.getTransaction().commit();
		
		
		/*
		Professor x = new Professor();
		x.setId(risco.getId());
		x.setNome("Jorge Risco");
		x.setEmail("jrisco@poli.usp.br");
		x.setLogin("jrisco");
		x.setSenha("4321");
		x.setCelular(1234);
		x.setTelefone(12345);
		
		UsuarioDAO.updateUsuario(x);*/
	}
	
	
}
