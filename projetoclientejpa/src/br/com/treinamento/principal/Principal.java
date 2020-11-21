package br.com.treinamento.principal;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.treinamento.conexao.*;
import br.com.treinamento.model.*;

public class Principal {

	private EntityManager em;
	Conexao con = new Conexao();
	
	
	public Principal() {
	
		this.em = con.getEntityManager();
	}

	public void salvar(Cliente Cliente) {
		this.em = con.getEntityManager();
		em.getTransaction().begin();
		em.persist(Cliente);
		em.getTransaction().commit();
		em.close();
	}

	public void atualizar(Cliente Cliente) {
		this.em = con.getEntityManager();
		em.getTransaction().begin();
		em.merge(Cliente);
		em.getTransaction().commit();
		em.close();
	}

	public void excluir(Cliente Cliente) {
		this.em = con.getEntityManager();
		em.getTransaction().begin();
		Cliente cli = em.find(Cliente.class,Cliente.getCodigo());
		em.remove(cli);
		em.getTransaction().commit();
		em.close();
	}

	public List<Cliente> listar() {
		this.em = con.getEntityManager();
		Query consulta = em.createQuery("select e from Cliente e");
		return consulta.getResultList();
	}

	public Cliente buscaCliente(int valor) {
		this.em = con.getEntityManager();
		Query consulta = (Query) em.find(Cliente.class, valor);
		return (Cliente) consulta.getSingleResult();
	}

	public static void main(String[] args) {

		Principal p = new Principal();

		Cliente Cliente1 = new Cliente();
		Cliente1.setNome("SBUBA");
		Cliente1.setTelefone("(46) 99989-0944");
		Cliente1.setEmail("vilao@terra.com.br");
		Cliente1.setDataCadastro(new Date(System.currentTimeMillis()));
		Cliente1.setObservacao("Novo cliente");
		p.salvar(Cliente1);

		Cliente1.setObservacao("Retomar Cliente");
		p.atualizar(Cliente1);

		Cliente Cliente2 = new Cliente();
		Cliente2.setNome("CALUNA");
		Cliente2.setTelefone("(48) 75893-5905");
		Cliente2.setEmail("vilao2@bol.com.br");
		Cliente2.setDataCadastro(new Date(System.currentTimeMillis()));
		Cliente2.setObservacao("Cliente em dia");
		p.salvar(Cliente2);

		System.out.println("Total de registros cadastrados: " + p.listar().size());
		p.excluir(Cliente2);
		System.out.println("Total de registros cadastrados: " + p.listar().size());
	
	}

}
