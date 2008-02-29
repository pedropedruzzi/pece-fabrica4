package br.usp.poli.pece.bl;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import br.usp.poli.pece.db.UsuarioDAO;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Usuario {
	
	//Construtor da Classe usuário
	public Usuario ()
	{
		//por enquanto vazio
	}
		
	@Id @GeneratedValue
	private long idUsuario;
	
	private String nome;
	private String email;
	private String login;
	private String senha;
	private long rg;
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
		
	public long getIdUsuario() {
		return idUsuario;
	}
	protected void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
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
	
	//Métodos
	
	public static List<Usuario> consultaUsuario(String strFiltro)
	{
		return UsuarioDAO.ConsultaUsuario(strFiltro);
	}
	
	public static void cadastraUsuario(Usuario usuario)
	{
		//TODO: Valida campos, etc..
		
		
		//
		UsuarioDAO.cadastraUsuario(usuario);
	}
	
	//Update no banco
	public static void atualizaUsuario(Usuario objUsuario)
	{
		
	}
	
	
	
	



}
