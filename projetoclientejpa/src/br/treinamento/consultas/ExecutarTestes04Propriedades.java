package br.treinamento.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.treinamento.conexao.Conexao;

public class ExecutarTestes04Propriedades {

	public static void main(String[] args) {
		
		//inicializando a consulta
		Conexao con = new Conexao();
		EntityManager em  = con.getEntityManager();
		
		em.getTransaction().begin();
		Professor p = new Professor();
	    p.setId(10);
	    p.setName("TOM");
	    
	    Department d = new Department();
	    d.setId(8);
	    d.setName("Design");
	    
	    p.setDepartment(d);
	    d.getProfessors().add(p);
	    
	    em.persist(p);
	    em.persist(d);
	    
	    em.getTransaction().commit();
	    
	    
	    List l = em.createQuery(    "SELECT e " +
	        "FROM Professor e " +
	        "WHERE e.department = :dept AND " +
	        "      e.salary = (SELECT MAX(e2.salary) " +
	        "                  FROM Professor e2 " +
	        "                  WHERE e2.department = :dept)")
	        .setParameter("dept", d)
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
