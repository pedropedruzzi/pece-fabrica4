package br.usp.poli.pece.bl;

import java.util.Date;
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
	
	@OneToMany(mappedBy="turma")
	private Set<Professor> professores;

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
	
	public Set<Professor> getProfessor(){
		return professores;
	}
	
	public String getNomeProfessor() {
	/*Retorna uma string contendo os nomes dos professores concatenados.
	 * 
	 */	
		String Nomes = null;
		if(this.professores.size()<=1){
			Nomes = professores.iterator().next().getNome();
		}
		else{
			for(int k=1;k< professores.size(); k++){
				Nomes = Nomes.concat(this.professores.iterator().next().getNome()).concat(", ");
			}
			Nomes = Nomes.concat(this.professores.iterator().next().getNome());
		}
			return Nomes;
	}
	
	public void setProfessor (Set<Professor> professor){
		this.professores = professor;
	}

}
