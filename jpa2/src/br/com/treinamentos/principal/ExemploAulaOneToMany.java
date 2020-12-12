package br.com.treinamentos.principal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.treinamentos.model.Aula;
import br.com.treinamentos.model.Carro;
import br.com.treinamentos.model.ChipSeguranca;
import br.com.treinamentos.model.Exercicio;

public class ExemploAulaOneToMany {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpaexemplo");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		List<Exercicio> exe = new ArrayList();
		Exercicio ex1 = new Exercicio();
		ex1.setTitulo("exe 1");
		ex1.setDescricao("Nova Descrição");
		
		Exercicio ex2 = new Exercicio();
		ex2.setTitulo("exe 2");
		ex2.setDescricao("Nova Descrição 2");
		
		
		exe.add(ex1);
		exe.add(ex2);
		
		Aula aula = new Aula();
		aula.setTitulo("nova");
		aula.setData(new Date("11/12/2020"));
		aula.setExecicios(exe);
		
		em.persist(aula);
		em.getTransaction().commit();

	}

}
