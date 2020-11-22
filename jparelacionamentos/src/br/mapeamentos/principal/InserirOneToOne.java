package br.mapeamentos.principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.treinamento.model.Carro;
import br.com.treinamento.model.ChipSeguranca;
import br.com.treinamento.model.*;

public class InserirOneToOne {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		//cria objeto chpipseguranca e persiste
		ChipSeguranca chips = new ChipSeguranca();
		chips.setId(1);
		chips.setNumero("898787678");
		em.persist(chips);
				//cria objeto carro e persiste carro e id do chip de segurança em carro
		Carro carro1 = new Carro();
		carro1.setId(1);
		carro1.setNome("FOX");
		carro1.setQtdRodas(4);
		carro1.setChipseguranca(chips);
		em.persist(carro1);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
