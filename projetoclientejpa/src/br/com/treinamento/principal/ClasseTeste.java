package br.com.treinamento.principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClasseTeste {

	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projetoclientejpa");
		EntityManager em = emf.createEntityManager();
		
		System.out.println(em);
		
		

	}

}
