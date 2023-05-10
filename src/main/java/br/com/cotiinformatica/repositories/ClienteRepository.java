package br.com.cotiinformatica.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cotiinformatica.entities.Cliente;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class ClienteRepository {

	public void create(Cliente cliente) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		String sql = "insert into cliente(nome, email, cpf, telefone, observacoes) values(?,?,?,?,?)";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getCpf());
		statement.setString(4, cliente.getTelefone());
		statement.setString(5, cliente.getObservacoes());
		statement.execute();

		connection.close();
	}

	public void update(Cliente cliente) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		String sql = "update cliente set nome=?, email=?, cpf=?, telefone=?, observacoes=? where idcliente=?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getCpf());
		statement.setString(4, cliente.getTelefone());
		statement.setString(5, cliente.getObservacoes());
		statement.setInt(6, cliente.getIdCliente());
		statement.execute();

		connection.close();
	}

	public void delete(Cliente cliente) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		String sql = "delete from cliente where idcliente=?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, cliente.getIdCliente());
		statement.execute();

		connection.close();
	}

	public List<Cliente> findAll() throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		String sql = "select * from cliente";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		List<Cliente> lista = new ArrayList<Cliente>();

		while (resultSet.next()) {

			Cliente cliente = new Cliente();

			cliente.setIdCliente(resultSet.getInt("idcliente"));
			cliente.setNome(resultSet.getString("nome"));
			cliente.setEmail(resultSet.getString("email"));
			cliente.setCpf(resultSet.getString("cpf"));
			cliente.setTelefone(resultSet.getString("telefone"));
			cliente.setObservacoes(resultSet.getString("observacoes"));

			lista.add(cliente);
		}

		connection.close();
		return lista;
	}

	public Cliente findById(Integer idCliente) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		String sql = "select * from cliente where idcliente=?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, idCliente);
		ResultSet resultSet = statement.executeQuery();

		Cliente cliente = null;

		if (resultSet.next()) {

			cliente = new Cliente();

			cliente.setIdCliente(resultSet.getInt("idcliente"));
			cliente.setNome(resultSet.getString("nome"));
			cliente.setEmail(resultSet.getString("email"));
			cliente.setCpf(resultSet.getString("cpf"));
			cliente.setTelefone(resultSet.getString("telefone"));
			cliente.setObservacoes(resultSet.getString("observacoes"));

		}

		connection.close();
		return cliente;
	}
}
