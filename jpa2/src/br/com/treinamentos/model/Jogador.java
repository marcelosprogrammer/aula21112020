package br.com.treinamentos.model;

import javax.persistence.*;

@Entity
@Table(name="jogador")
public class Jogador {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="posicao")
	private String posicao;
	
	
	@Column(name="valor")
	private Double valor;
	
	

}
