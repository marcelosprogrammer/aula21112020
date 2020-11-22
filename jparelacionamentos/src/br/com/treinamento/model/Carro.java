package br.com.treinamento.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name="carros")
public class Carro implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5021116158227599770L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="quantidadeRodas")
	private int qtdRodas;
	
	@OneToOne
	@JoinColumn(name="numeroserial")
	private ChipSeguranca chipseguranca;
	
	public Carro() {
		
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the qtdRodas
	 */
	public int getQtdRodas() {
		return qtdRodas;
	}

	/**
	 * @param qtdRodas the qtdRodas to set
	 */
	public void setQtdRodas(int qtdRodas) {
		this.qtdRodas = qtdRodas;
	}

	/**
	 * @return the chipseguranca
	 */
	public ChipSeguranca getChipseguranca() {
		return chipseguranca;
	}

	/**
	 * @param chipseguranca the chipseguranca to set
	 */
	public void setChipseguranca(ChipSeguranca chipseguranca) {
		this.chipseguranca = chipseguranca;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chipseguranca == null) ? 0 : chipseguranca.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + qtdRodas;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (chipseguranca == null) {
			if (other.chipseguranca != null)
				return false;
		} else if (!chipseguranca.equals(other.chipseguranca))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (qtdRodas != other.qtdRodas)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Carro [id=" + id + ", nome=" + nome + ", qtdRodas=" + qtdRodas + ", chipseguranca=" + chipseguranca
				+ "]";
	}


	
	
	

}
