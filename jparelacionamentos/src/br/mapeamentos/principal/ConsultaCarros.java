package br.mapeamentos.principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.treinamento.model.Carro;
import br.com.treinamento.model.ChipSeguranca;

public class ConsultaCarros {

	public static void main(String[] args) {

		//selecionando um carro
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		ConsultaCarros c = new ConsultaCarros();
		c.selecionarCarro(1,em);

	}

	private void selecionarCarro(int id, EntityManager e) {
		e.getTransaction().begin();
		Carro carro = e.find(Carro.class, new Integer(1));
		ChipSeguranca fabricante = e.find(ChipSeguranca.class, carro.getChipseguranca().getId());
		e.getTransaction().commit();
		
		System.out.println(carro);
		System.out.println(fabricante);
		
		
	}
}
