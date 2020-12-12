package br.com.treinamentos.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ProjetoExtensao {

	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private Long id;
	  private String nome;
	  @ManyToMany(mappedBy="projetoextensao", cascade = CascadeType.ALL)
	  private List<Aluno> alunos;
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
	 * @return the alunos
	 */
	public List<Aluno> getAlunos() {
		return alunos;
	}
	/**
	 * @param alunos the alunos to set
	 */
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	  
	  
	  
	  
	  
}