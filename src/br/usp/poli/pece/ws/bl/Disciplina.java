package br.usp.poli.pece.ws.bl;

public class Disciplina {

	public long id;
	public String codDisciplina;
	public String nome;
	public short cargaHoraria;
	public String descricao;
	public String materialApoio;

	public Disciplina(br.usp.poli.pece.bl.Disciplina d) {

		cargaHoraria = d.getCargaHoraria();
		codDisciplina = d.getCodDisciplina();
		descricao = d.getDescricao();
		materialApoio = d.getMaterialApoio();
		nome = d.getNome();
				
	}

}
