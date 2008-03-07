package br.usp.poli.pece.bl;

public class main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	Aluno aluno = new Aluno();
	aluno.setNome("testeNomeAluno");
	aluno.setEmail("testeEmailAluno");
	aluno.setLogin("loginTeste");
	aluno.setSenha("senhaTeste");
	System.out.println(aluno.getCpf());
	aluno.cadastraUsuario();
		
		
	}
}

