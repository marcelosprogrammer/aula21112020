package br.treinamento.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.treinamento.conexao.Conexao;

public class ExecutarTestes02 {

	public static void main(String[] args) {
		
		//inicializando a consulta
		Conexao con = new Conexao();
		EntityManager em  = con.getEntityManager();
		
		em.getTransaction().begin();
		Professor p = new Professor();
	    p.setId(8);
	    p.setName("TOM");
	    
	    Department d = new Department();
	    d.setId(5);
	    d.setName("Design");
	    
	    p.setDepartment(d);
	    d.getProfessors().add(p);
	    
	    em.persist(p);
	    em.persist(d);
	    
	    em.getTransaction().commit();
	    
	    //selecionando:
	    List l = em.createQuery("SELECT d, m  FROM Department d, Professor m WHERE d = m.department").getResultList();
	    for(Object g:l){
	      System.out.println(g);
	    }
	    
	    
	    
	    
	}

}
