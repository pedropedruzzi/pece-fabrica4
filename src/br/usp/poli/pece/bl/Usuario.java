package br.usp.poli.pece.bl;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import br.usp.poli.pece.bl.estruturas.CursosComplementares;
import br.usp.poli.pece.bl.estruturas.FormacaoAcademica;
import br.usp.poli.pece.bl.estruturas.HistoricoProfissional;
import br.usp.poli.pece.bl.estruturas.Motivacao;
import br.usp.poli.pece.bl.estruturas.PesquisaPECE;
import br.usp.poli.pece.bl.estruturas.Qualificacao;
import br.usp.poli.pece.db.UsuarioDAO;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Usuario {

	@Id @GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String nome = "";
	
	@Column(unique=true, nullable=false)
	private String email = "";
	
	@Column(unique=true, nullable=false, updatable=false)
	private String login;
	
	@Column(nullable=false)
	private String senha;
	
	@Column(unique=true)
	private Long rg;
	
	@Column(unique=true)
	private Long cpf;
	
	private Date dataExpRg;
	private String localNascimento;
	private Date dataNascimento;
	private String nomeMae;
	private String ruaEndereco;
	private String numeroEndereco;
	private String bairroEndereco;
	private String complementoEndereco;
	private String cep;
	private String cidade;
	private String uf;
	private long telefone;
	private long celular;
	
	@OneToMany(fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	private List<FormacaoAcademica> formacao;
	@OneToMany(fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	private List<CursosComplementares> cursosComplementares;
	@OneToMany(fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	private List<HistoricoProfissional> historicoProfissional;
	@OneToMany(fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	private List<Qualificacao> qualificacao;
	@OneToMany(fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	private List<Motivacao> motivacao;
	private PesquisaPECE pesquisaPece;
				
	@Transient
	private String _strUltimoErro;
	
	// construtor
	
	
	
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
	public Long getRg() {
		return rg;
	}
	public void setRg(Long rg) {
		this.rg = rg;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
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
	public String getRuaEndereco() {
		return ruaEndereco;
	}

	public void setRuaEndereco(String ruaEndereco) {
		this.ruaEndereco = ruaEndereco;
	}
	public String getNumeroEndereco() {
		return numeroEndereco;
	}
	public void setNumeroEndereco(String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}
	public String getBairroEndereco() {
		return bairroEndereco;
	}
	public void setBairroEndereco(String bairroEndereco) {
		this.bairroEndereco = bairroEndereco;
	}
	public String getComplementoEndereco() {
		return complementoEndereco;
	}
	public void setComplementoEndereco(String complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}
	
	// 	Metodos
	public static List<Usuario> consultaUsuario(String strFiltro)
	{
		return UsuarioDAO.consultaUsuario(strFiltro);
	}

	public static List<Aluno> consultaAluno(String strFiltro)
	{
		return UsuarioDAO.consultaAluno(strFiltro);
	}
	
	public boolean cadastraUsuario()
	{
		boolean blnRetVal = true;
		if (ValidaUsuario())
			UsuarioDAO.cadastraUsuario(this);
		else
			blnRetVal = false;
		
		return blnRetVal;
	}
		
	public boolean atualizaUsuario()
	{
		boolean blnRetVal = true;
		if (ValidaUsuario())
			UsuarioDAO.updateUsuario(this);
		else
			blnRetVal = false;
		
		return blnRetVal;
	}
	
	/**  Valida Usuario
	 * @return 		boolean 		Usuario válido/não válido
	 */
	private boolean ValidaUsuario()
	{
		boolean blnRetVal = true;
		if (nome.trim().length() == 0)
		{
			_strUltimoErro = "O campo 'nome' deve ser preenchido";
			blnRetVal = false;
		}
		if (email.trim().length() == 0)
		{
			_strUltimoErro = "O campo 'email' deve ser preenchido";
			blnRetVal = false;
		}
		return blnRetVal;
	}
	
	/** Obtem ultimo erro
	 * @return		string		Ultimo erro gerado pelos processos 
	 * 
	 */
	public String ObtemUltimoErro()
	{
		return _strUltimoErro;
	}
		
}
