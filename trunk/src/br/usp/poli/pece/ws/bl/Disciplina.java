package br.usp.poli.pece.ws.bl;

public class Disciplina {

	protected long id;
	private String codDisciplina;
	private String nome;
	private short cargaHoraria;
	private String descricao;
	private String materialApoio;

	public Disciplina(br.usp.poli.pece.bl.Disciplina d) {

		cargaHoraria = d.getCargaHoraria();
		codDisciplina = d.getCodDisciplina();
		descricao = d.getDescricao();
		materialApoio = d.getMaterialApoio();
		nome = d.getNome();
				
	}

}
