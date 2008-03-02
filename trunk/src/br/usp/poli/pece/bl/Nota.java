package br.usp.poli.pece.bl;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"inscricao_id", "nome"})})
public class Nota {
	@Id
	protected long id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=Inscricao.class)
	@JoinColumn(name="inscricao_id", insertable=false, updatable=false, nullable=false)
	private Inscricao inscricao;
	
	@Column(nullable=false)
	private String nome;
	
	private short nota;

	public Inscricao getInscricao() {
		return inscricao;
	}

	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public short getNota() {
		return nota;
	}

	public void setNota(short nota) {
		this.nota = nota;
	}
	
	
	
}
