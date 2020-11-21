package br.com.treinamento.model;


import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "codigo")
	private Integer	codigo;

	@Column(name = "nome", length = 50, nullable = true)
	private String	nome;

	@Column(name = "telefone", length = 50, nullable = true)
	private String	telefone;

	@Column(name = "email", length = 50, nullable = true)
	private String	email;

	@Column(name = "data_cadastro", nullable = true)
	private Date		dataCadastro;

	@Column(name = "obs", nullable = true)
	private String	observacao;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getObservacao() {
		return observacao;
	}

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
