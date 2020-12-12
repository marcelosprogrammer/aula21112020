package br.com.treinamentos.model;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.*;


@Entity
@Table(name="times")
public class Time {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="nome")
	private String nome;
	@Column(name="ano_criacao")
	private int anocriacao;
	@Column(name="renda_anual")
	private Double rendaAnual;
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
	 * @return the anocriacao
	 */
	public int getAnocriacao() {
		return anocriacao;
	}
	/**
	 * @param anocriacao the anocriacao to set
	 */
	public void setAnocriacao(int anocriacao) {
		this.anocriacao = anocriacao;
	}
	/**
	 * @return the rendaAnual
	 */
	public Double getRendaAnual() {
		return rendaAnual;
	}
	/**
	 * @param rendaAnual the rendaAnual to set
	 */
	public void setRendaAnual(Double rendaAnual) {
		this.rendaAnual = rendaAnual;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anocriacao;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((rendaAnual == null) ? 0 : rendaAnual.hashCode());
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
		Time other = (Time) obj;
		if (anocriacao != other.anocriacao)
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
		if (rendaAnual == null) {
			if (other.rendaAnual != null)
				return false;
		} else if (!rendaAnual.equals(other.rendaAnual))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Time [id=" + id + ", nome=" + nome + ", anocriacao=" + anocriacao + ", rendaAnual=" + rendaAnual + "]";
	}
	
	
	

}
