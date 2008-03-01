package br.usp.poli.pece.bl;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Inscricao {
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Turma turma;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Aluno aluno;
	
	private short presencas;
	
	private Map<String, Short> notas;
	

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public short getPresencas() {
		return presencas;
	}

	public void setPresencas(short presencas) {
		this.presencas = presencas;
	}

	public Map<String, Short> getNotas() {
		return notas;
	}

	public void setNotas(Map<String, Short> notas) {
		this.notas = notas;
	}
	
	
	
}
