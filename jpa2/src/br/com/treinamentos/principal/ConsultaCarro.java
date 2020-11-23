package br.com.treinamentos.principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.treinamentos.model.Carro;
import br.com.treinamentos.model.ChipSeguranca;

public class ConsultaCarro {

	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpaexemplo");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Carro carro = em.find(Carro.class, 1);
		ChipSeguranca chip = (ChipSeguranca) carro.getNumeroserial();
		System.out.println(carro);
		System.out.println(chip);
		
		System.out.println();
		ChipSeguranca chip2 = em.find(ChipSeguranca.class, 1);
		System.out.println(chip2);
		System.out.println(chip2.getCarro());
		

	}

}
