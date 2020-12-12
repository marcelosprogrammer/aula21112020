package br.com.treinamentos.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import java.util.List;

@Entity
public class Aluno implements Serializable{

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private Long id;
	  private String nome;
	  private Long matricula;
	  
	  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	  @JoinTable(name="ALUNO_CANETA",
	             joinColumns={@JoinColumn(name = "ALUNO_ID")},
	             inverseJoinColumns={@JoinColumn(name = "CANETA_ID")})
	  private List<Caneta> canetas;
	  
	  
	  @ManyToMany(cascade = CascadeType.ALL)
	  @JoinTable(name="PROJETOEXTENSAO_ALUNO",
	             joinColumns={@JoinColumn(name="PROJETO_ID")},
	             inverseJoinColumns={@JoinColumn(name="ALUNO_ID")})
	  private List<ProjetoExtensao> projetoextensao;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
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
	 * @return the matricula
	 */
	public Long getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	/**
	 * @return the canetas
	 */
	public List<Caneta> getCanetas() {
		return canetas;
	}

	/**
	 * @param canetas the canetas to set
	 */
	public void setCanetas(List<Caneta> canetas) {
		this.canetas = canetas;
	}

	/**
	 * @return the projetoextensao
	 */
	public List<ProjetoExtensao> getProjetoextensao() {
		return projetoextensao;
	}

	/**
	 * @param projetoextensao the projetoextensao to set
	 */
	public void setProjetoextensao(List<ProjetoExtensao> projetoextensao) {
		this.projetoextensao = projetoextensao;
	}
	  
	  
	  
	  
}