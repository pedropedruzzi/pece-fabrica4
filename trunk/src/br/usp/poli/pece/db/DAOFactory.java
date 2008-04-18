package br.usp.poli.pece.db;

import br.usp.poli.pece.bl.Funcionario;
import br.usp.poli.pece.bl.Professor;
import br.usp.poli.pece.bl.Turma;

public class DAOFactory {
	
	// Inline concrete DAO implementations with no business-related data access methods.
	public static class ProfessorDAO extends GenericDAO<Professor> {}
	public static class FuncionarioDAO extends GenericDAO<Funcionario> {}
	public static class TurmaDAO extends GenericDAO<Turma> {}
	
	private final static AlunoDAO alunoDAO = new AlunoDAO();
	private final static UsuarioDAO usuarioDAO = new UsuarioDAO();
	private final static DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
	private final static CursoDAO cursoDAO = new CursoDAO();
	private final static MatriculaDAO matriculaDAO = new MatriculaDAO();
	private final static ProfessorDAO professorDAO = new ProfessorDAO();
	private final static FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	private final static TurmaDAO turmaDAO = new TurmaDAO();
	
	protected DAOFactory() {
		
	}
	
	public static AlunoDAO getAlunoDAO() {
		return alunoDAO;
	}
	
	public static UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public static DisciplinaDAO getDisciplinaDAO() {
		return disciplinaDAO;
	}
	
	public static CursoDAO getCursoDAO() {
		return cursoDAO;
	}

	public static MatriculaDAO getMatriculaDAO() {
		return matriculaDAO;
	}

	public static ProfessorDAO getProfessorDAO() {
		return professorDAO;
	}

	public static FuncionarioDAO getFuncionarioDAO() {
		return funcionarioDAO;
	}

	public static TurmaDAO getTurmaDAO() {
		return turmaDAO;
	}
	
}
