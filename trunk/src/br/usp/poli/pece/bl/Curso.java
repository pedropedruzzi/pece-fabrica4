package br.usp.poli.pece.bl;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.usp.poli.pece.db.DAOFactory;


/**
 * @author virgilio.vettorazzo
 *
 */
@Entity
public class Curso {
	@Id @GeneratedValue
	protected long id;
	
	@Column(unique=true, nullable=false)
	private String nome;
	
	@Column(unique=true, nullable=false)
	private String codCurso;
	
	private short cargaHoraria;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(nullable=false)
	private Professor coordenador;
	
	@OneToMany(mappedBy="curso")
	private Set<Disciplina> disciplinas;

	@OneToMany(mappedBy="curso")
	private Set<Matricula> matriculas;
	
	private String descricao;
	
	


	protected long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}

	public short getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(short cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Professor getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Professor coordenador) {
		this.coordenador = coordenador;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Set<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(Set<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * Cadastro de Curso
	 *
	 * @param  objCurso	Objeto contendo informacoes do curso a ser cadastrado
	 */	
	public static void cadstroCurso(Curso curso) {
		DAOFactory.getCursoDAO().makePersistent(curso);
	}
	
	public static Curso getCursoByCodigo(String codigo) {
		return DAOFactory.getCursoDAO().findByCodigo(codigo);
	}
	
}
