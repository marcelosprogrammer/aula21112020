package br.com.treinamentos.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="chip_seguranca")
public class ChipSeguranca implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4735435267812329047L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="numeroserial")
	private String numeroserial;
	
	@OneToOne(mappedBy="numeroserial",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Carro carro;
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
	 * @return the numeroserial
	 */
	public String getNumeroserial() {
		return numeroserial;
	}
	/**
	 * @param numeroserial the numeroserial to set
	 */
	public void setNumeroserial(String numeroserial) {
		this.numeroserial = numeroserial;
	}
	/**
	 * @return the carro
	 */
	public Carro getCarro() {
		return carro;
	}
	/**
	 * @param carro the carro to set
	 */
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carro == null) ? 0 : carro.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numeroserial == null) ? 0 : numeroserial.hashCode());
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
		ChipSeguranca other = (ChipSeguranca) obj;
		if (carro == null) {
			if (other.carro != null)
				return false;
		} else if (!carro.equals(other.carro))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numeroserial == null) {
			if (other.numeroserial != null)
				return false;
		} else if (!numeroserial.equals(other.numeroserial))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChipSeguranca [id=" + id + ", numeroserial=" + numeroserial + "]";
	}

	

}
