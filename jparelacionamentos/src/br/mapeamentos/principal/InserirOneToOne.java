package br.mapeamentos.principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.treinamento.model.Carro;
import br.com.treinamento.model.Fabricante;
import br.com.treinamento.model.*;

public class InserirOneToOne {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//cria objeto fabricante e persiste
		Fabricante fabricante1 = new Fabricante();
		fabricante1.setId(1);
		fabricante1.setNome("VOLKSWAGEN");
		em.persist(fabricante1);
		
		//cria objeto carro e persiste carro e id do fabricante em carro
		Carro carro1 = new Carro();
		carro1.setId(1);
		carro1.setNome("FOX");
		carro1.setQtdRodas(4);
		carro1.setFabricante(fabricante1);
		em.persist(carro1);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}

}
