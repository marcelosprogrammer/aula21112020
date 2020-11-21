package br.treinamento.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.treinamento.conexao.Conexao;

public class ExecutarTestes03Propriedades {

	public static void main(String[] args) {
		
		//inicializando a consulta
		Conexao con = new Conexao();
		EntityManager em  = con.getEntityManager();
		
		em.getTransaction().begin();
		Professor p = new Professor();
	    p.setId(9);
	    p.setName("TOM");
	    
	    Department d = new Department();
	    d.setId(6);
	    d.setName("Design");
	    
	    p.setDepartment(d);
	    d.getProfessors().add(p);
	    
	    em.persist(p);
	    em.persist(d);
	    
	    em.getTransaction().commit();
	    
	    //selecionando:
	    List l = em.createQuery("SELECT e.name, e.salary FROM Professor e")
	            .getResultList();
	        for (Object h : l) {
	          exibirResultado(h);
	        }
	        
	        
	    
	    
	    
	}
	
	private static void exibirResultado(Object result) {
	    if (result == null) {
	      System.out.print("NULL");
	    } else if (result instanceof Object[]) {
	      Object[] row = (Object[]) result;
	      System.out.print("[");
	      for (int i = 0; i < row.length; i++) {
	        exibirResultado(row[i]);
	      }
	      System.out.print("]");
	    } else if (result instanceof Long || result instanceof Double
	        || result instanceof String) {
	      System.out.print(result.getClass().getName() + ": " + result);
	    } else {
	      System.out.print(result);
	    }
	    System.out.println();
	  }

}
