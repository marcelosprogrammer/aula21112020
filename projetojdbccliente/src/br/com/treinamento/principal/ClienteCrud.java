package br.com.treinamento.principal;
import br.com.treinamento.model.*;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class ClienteCrud {
	
	public void salvar(Cliente Cliente) throws SQLException {
		Connection conexao = this.geraConexao();
		PreparedStatement insereSt = null;
		String sql = "insert into Cliente (nome, telefone, email, data_cadastro, obs) values (?, ?, ?, ?, ?)";
		
		try {
			insereSt = conexao.prepareStatement(sql);
			
			insereSt.setString(1, Cliente.getNome());
			insereSt.setString(2, Cliente.getTelefone());
			insereSt.setString(3, Cliente.getEmail());
			insereSt.setDate(4, Cliente.getDataCadastro());
			insereSt.setString(5, Cliente.getObservacao());
			
			insereSt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao incluir Cliente. Mensagem: "
					+ e.getMessage());
		} catch(Exception f){
			
		}	
		finally {
		
			try {
				insereSt.close();
				conexao.close();
			} catch (Throwable e) {
				System.out
						.println("Erro ao fechar operações de inserção. Mensagem: "
								+ e.getMessage());
			}
		}
		
	}

	public void atualizar(Cliente Cliente) {
		Connection conexao = this.geraConexao();
		PreparedStatement atualizaSt = null;


		String sql = "update Cliente set nome=?, telefone=?, email=?, obs=? where codigo=?";

		try {
			atualizaSt = conexao.prepareStatement(sql);
			atualizaSt.setString(1, Cliente.getNome());
			atualizaSt.setString(2, Cliente.getTelefone());
			atualizaSt.setString(3, Cliente.getEmail());
			atualizaSt.setString(4, Cliente.getObservacao());
			atualizaSt.setInt(5, Cliente.getCodigo());
			atualizaSt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar Cliente. Mensagem: " + e.getMessage());
		} finally {
			try {
				atualizaSt.close();
				conexao.close();
			} catch (Throwable e) {
				System.out
						.println("Erro ao fechar operações de atualização. Mensagem: "
								+ e.getMessage());
			}
		}
	}

	public void excluir(Cliente Cliente) {
		Connection conexao = this.geraConexao();
		PreparedStatement excluiSt = null;

		String sql = "delete from Cliente where codigo = ?";

		try {
			excluiSt = conexao.prepareStatement(sql);
			
			excluiSt.setInt(1, Cliente.getCodigo());
			
			
			excluiSt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro na exclusão. Mensagem: "
					+ e.getMessage());
		} finally {
			try {
				excluiSt.close();
				conexao.close();
			} catch (Throwable e) {
				System.out
						.println("Erro ao fechar operações ao excluir. Mensagem: "
								+ e.getMessage());
			}
		}
	}

	public List<Cliente> listar() {
		
		Connection conexao = this.geraConexao();
		
		List<Cliente> Clientes = new ArrayList<Cliente>();
		
		Statement consulta = null;
		ResultSet resultado = null;
		Cliente Cliente = null;
		String sql = "select * from Cliente";
		
		try {
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			while (resultado.next()) {
				
				Cliente = new Cliente();
				Cliente.setCodigo(resultado.getInt("codigo"));
				Cliente.setNome(resultado.getString("nome"));
				Cliente.setTelefone(resultado.getString("telefone"));
				Cliente.setEmail(resultado.getString("email"));
				Cliente.setDataCadastro(resultado.getDate("data_cadastro"));
				Cliente.setObservacao(resultado.getString("obs"));
				Clientes.add(Cliente);
				
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar Cliente. Mensagem: "
					+ e.getMessage());
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				System.out
						.println("Erro ao fechar operações. Mensagem: "
								+ e.getMessage());
			}
		}
		return Clientes;
	}

	public Cliente buscaCliente(int valor) {
		Connection conexao = this.geraConexao();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		
		Cliente Cliente = null;

		String sql = "select * from Cliente where codigo = ?";

		try {
			consulta = conexao.prepareStatement(sql);
			consulta.setInt(1, valor);
			resultado = consulta.executeQuery();

			if (resultado.next()) {
				Cliente = new Cliente();
				Cliente.setCodigo(resultado.getInt("codigo"));
				Cliente.setNome(resultado.getString("nome"));
				Cliente.setTelefone(resultado.getString("telefone"));
				Cliente.setEmail(resultado.getString("email"));
				Cliente.setDataCadastro(resultado.getDate("data_cadastro"));
				Cliente.setObservacao(resultado.getString("obs"));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar Cliente. Mensagem: "
					+ e.getMessage());
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				System.out
						.println("Erro ao fechar operações. Mensagem: "
								+ e.getMessage());
			}
		}
		return Cliente;
	}

	public Connection geraConexao() {
		Connection conexao = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/aula21112020";
			String usuario = "root";
			String senha = "";
			conexao = DriverManager.getConnection(url, usuario, senha);
		} catch (ClassNotFoundException e) {
			System.out
					.println("Não achou a classe. Erro: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro de SQL. Erro: "
					+ e.getMessage());
		}
		return conexao;
	}

	public static void main(String[] args) throws SQLException {
		ClienteCrud ClienteCrud = new ClienteCrud();

		// Cliente 1
		Cliente cliente1 = new Cliente();
		cliente1.setNome("cliente1");
		cliente1.setTelefone("(49) 25636-3333");
		cliente1.setEmail("cliente1@uol.com.br");
		cliente1.setDataCadastro(new Date(System.currentTimeMillis()));
		cliente1.setObservacao("Novo cliente 1 ");
		ClienteCrud.salvar(cliente1);

		// Cliente 2
		Cliente cliente2 = new Cliente();
		cliente2.setNome("cliente2");
		cliente2.setTelefone("(48) 95555-5245");
		cliente2.setEmail("cliente2@bol.com.br");
		cliente2.setDataCadastro(new Date(System.currentTimeMillis()));
		cliente2.setObservacao("Novo Cliente 2");
		ClienteCrud.salvar(cliente2);
		System.out.println("Clientes cadastrados: " + ClienteCrud.listar().size());
	}

}
