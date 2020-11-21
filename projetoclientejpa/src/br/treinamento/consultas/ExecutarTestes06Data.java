package br.treinamento.consultas;

import java.util.Date;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TemporalType;

import br.com.treinamento.conexao.Conexao;

public class ExecutarTestes06Data {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// inicializando a consulta
		Conexao con = new Conexao();
		EntityManager em = con.getEntityManager();

		em.getTransaction().begin();
		
		 Address address = new Address();
		 	address.setId(1);
		    address.setState("BC");
		    
		    Professor p = new Professor();
		    p.setId(21);
		    p.setName("TOM");
		    p.setSalary(1111L);
		    p.setAddress(address);

		    Department d = new Department();
		    d.setId(21);
		    d.setName("Design");

		    p.setDepartment(d);
		    d.getProfessors().add(p);

		    Phone phone = new Phone();
		    phone.setId(21);
		    phone.setNumber("111-111-1111");
		    phone.setProfessor(p);
		    
		    em.persist(p);
		    em.persist(phone);
		    em.persist(address);
		    em.persist(d);
		    
		    
		    Collection<Professor> c =  
		    	    em.createQuery("SELECT e " +
		    	                   "FROM Professor e " +
		    	                   "WHERE e.startDate BETWEEN :start AND :end")
		    	      .setParameter("start", new Date(), TemporalType.DATE)
		    	      .setParameter("end", new Date(), TemporalType.DATE)
		    	      .getResultList();
		    	    for (Iterator i = c.iterator(); i.hasNext();) {
		    	      Professor u = (Professor) i.next();
		    	      exibirResultado(u);
		    	    }
		    	    
		em.getTransaction().commit();
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
		} else if (result instanceof Long || result instanceof Double || result instanceof String) {
			System.out.print(result.getClass().getName() + ": " + result);
		} else {
			System.out.print(result);
		}
		System.out.println();
	}

}
