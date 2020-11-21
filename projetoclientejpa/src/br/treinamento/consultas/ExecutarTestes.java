package br.treinamento.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.treinamento.conexao.Conexao;

public class ExecutarTestes {

	public static void main(String[] args) {
		
		//inicializando a consulta
		Conexao con = new Conexao();
		EntityManager em  = con.getEntityManager();
		
		//inserindo em professor
		Professor p = new Professor();
	    p.setId(1);
	    p.setName("Jorge");
	    em.getTransaction().begin();
	    em.persist(p);
	    em.getTransaction().commit();
		
	    
	    //listando professores:
	    
	    List<Professor> l = em.createQuery("SELECT e FROM Professor e").getResultList();
	    for(Professor h:l){
	      System.out.println(h);
	    }
	}

}
