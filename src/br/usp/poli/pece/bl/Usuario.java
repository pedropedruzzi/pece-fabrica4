package br.usp.poli.pece.bl;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import br.usp.poli.pece.db.UsuarioDAO;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Usuario {
	
	//Construtor da Classe usu�rio
	public Usuario ()
	{
		//por enquanto vazio
	}
		
	
	@Id @GeneratedValue
	private long id;
	
	@Column(unique=true, nullable=false)
	private String nome;
	
	@Column(unique=true, nullable=false)
	private String email;
	
	@Column(unique=true, nullable=false, updatable=false)
	private String login;
	
	@Column(nullable=false)
	private String senha;
	
	@Column(unique=true)
	private long rg;
	
	@Column(unique=true)
	private long cpf;
	
	private Date dataExpRg;
	private String localNascimento;
	private Date dataNascimento;
	private String nomeMae;
	private String enderecoRes;
	private String cep;
	private String cidade;
	private String uf;
	private long telefone;
	private long celular;
	private String formacaoAcademica;
	private String cursosComplementares;
	private String historicoProfissional;
	private String _strUltimoErro;
	
		
	public long getId() {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public long getRg() {
		return rg;
	}
	public void setRg(long rg) {
		this.rg = rg;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public Date getDataExpRg() {
		return dataExpRg;
	}
	public void setDataExpRg(Date dataExpRg) {
		this.dataExpRg = dataExpRg;
	}
	public String getLocalNascimento() {
		return localNascimento;
	}
	public void setLocalNascimento(String localNascimento) {
		this.localNascimento = localNascimento;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public String getEnderecoRes() {
		return enderecoRes;
	}
	public void setEnderecoRes(String enderecoRes) {
		this.enderecoRes = enderecoRes;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public long getTelefone() {
		return telefone;
	}
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	public long getCelular() {
		return celular;
	}
	public void setCelular(long celular) {
		this.celular = celular;
	}
	public String getFormacaoAcademica() {
		return formacaoAcademica;
	}
	public void setFormacaoAcademica(String formacaoAcademica) {
		this.formacaoAcademica = formacaoAcademica;
	}
	public String getCursosComplementares() {
		return cursosComplementares;
	}
	public void setCursosComplementares(String cursosComplementares) {
		this.cursosComplementares = cursosComplementares;
	}
	public String getHistoricoProfissional() {
		return historicoProfissional;
	}
	public void setHistoricoProfissional(String historicoProfissional) {
		this.historicoProfissional = historicoProfissional;
	}
	
	//Metodos
	
	public static List<Usuario> consultaUsuario(String strFiltro)
	{
		return UsuarioDAO.ConsultaUsuario(strFiltro);
	}
	
	//Cadastra usuario no banco e retorna um booleano de confirmacao.
	public boolean cadastraUsuario(Usuario objUsuario)
	{
		boolean blnRetVal = true;
		if (ValidaUsuario(objUsuario))
			UsuarioDAO.cadastraUsuario(objUsuario);
		else
			blnRetVal = false;
		
		return blnRetVal;
		
	}
		
	//Update no banco
	public boolean atualizaUsuario(Usuario objUsuario)
	{
		boolean blnRetVal = true;
		if (ValidaUsuario(objUsuario))
			UsuarioDAO.atualizaUsuario(objUsuario);
		else
			blnRetVal = false;
		
		return blnRetVal;
	}
	
	// Verifica preenchimento das propriedades "nome" e "email" de um 
	// usuario.
	private boolean ValidaUsuario(Usuario objUsuario)
	{
		boolean blnRetVal = true;
		if (objUsuario.nome == "")
		{
			_strUltimoErro = "O campo 'nome' deve ser preenchido";
			blnRetVal = false;
		}
		if (objUsuario.email == "")
		{
			_strUltimoErro = "O campo 'email' deve ser preenchido";
			blnRetVal = false;
		}
		return blnRetVal;
	}
	
	public String ObtemUltimoErro()
	{
		return _strUltimoErro;
	}
			
}
