package br.com.treinamentos.principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.treinamentos.model.Carro;
import br.com.treinamentos.model.ChipSeguranca;

public class ExemploCarro {

	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpaexemplo");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		ChipSeguranca chip = new ChipSeguranca();
		chip.setNumeroserial("9999999876");
		em.persist(chip);
		
		Carro carro = new Carro();
		carro.setNome("Fiat UNO");
		carro.setNumeroserial(chip);
		em.persist(carro);
		em.getTransaction().commit();
		
	}

}
