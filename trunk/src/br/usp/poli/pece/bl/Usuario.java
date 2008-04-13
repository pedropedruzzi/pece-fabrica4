package br.usp.poli.pece.bl;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import br.usp.poli.pece.db.DAOFactory;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Usuario {

	@Id @GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(unique=true, nullable=false)
	private String email;
	
	@Column(unique=true, nullable=false, updatable=false)
	private String login;
	
	@Column(nullable=false)
	private String senha;
	
	@Column(unique=true)
	private Long rg;
	
	@Column(unique=true)
	private Long cpf;
	
	private char sexo;
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
	
	
	public Usuario() {
		sexo = 'M';
	}
	
	
	
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
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
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
	
	// Estou pensando muito seriamente em tirar este método!
	public static List<Usuario> consultaUsuario(String filtro) {
		return DAOFactory.getUsuarioDAO().findByNameFilter(filtro);
	}
	
	public void persist() {
		String erro = validaUsuario();
		
		if (erro == null)
			DAOFactory.getUsuarioDAO().makePersistent(this);
		else
			throw new RuntimeException(erro);
	}
	
	private String validaUsuario() {
		if (nome.trim().length() == 0) {
			return "O campo 'nome' deve ser preenchido";
		}
		
		if (email.trim().length() == 0)	{
			return "O campo 'email' deve ser preenchido";
		}
		
		return null;
	}

		
}
