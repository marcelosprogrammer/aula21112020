package br.com.treinamento.model;


import java.io.Serializable;
import java.sql.Date;
public class Cliente implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private Integer	codigo;
	private String  nome;
	private String  telefone;
	private String  email;
	private Date dataCadastro;
	private String observacao;
	
	
	public Cliente() {
		super();

	}


	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}


	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}


	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}


	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}


	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the dataCadastro
	 */
	public Date getDataCadastro() {
		return dataCadastro;
	}


	/**
	 * @param dataCadastro the dataCadastro to set
	 */
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	/**
	 * @return the observacao
	 */
	public String getObservacao() {
		return observacao;
	}


	/**
	 * @param observacao the observacao to set
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email
				+ ", dataCadastro=" + dataCadastro + ", observacao=" + observacao + "]";
	}
	
	

	
	
}
