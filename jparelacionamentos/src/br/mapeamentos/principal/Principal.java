package br.mapeamentos.principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {

	public static void main(String args[]) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		System.out.println(em.getProperties());
		
	}
	
}
