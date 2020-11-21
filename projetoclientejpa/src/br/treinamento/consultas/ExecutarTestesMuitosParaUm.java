package br.treinamento.consultas;

import java.util.Date;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TemporalType;

import br.com.treinamento.conexao.Conexao;

public class ExecutarTestesMuitosParaUm {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// inicializando a consulta
		Conexao con = new Conexao();
		EntityManager em = con.getEntityManager();

		em.getTransaction().begin();
		
		List l = em.createQuery(
		        "SELECT DISTINCT e.department FROM Project p JOIN p.employees e WHERE p.name = 'proj'")
		        .getResultList();
		    for (Object p : l) {
		      exibirResultado(p);
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
