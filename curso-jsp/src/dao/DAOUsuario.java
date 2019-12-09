package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeanCursoJsp;
import connection.SingleConnection;

public class DAOUsuario {

	private Connection connection;
	
	public DAOUsuario() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(BeanCursoJsp usuario) throws SQLException {
		
		try {
		
		String sql = "INSERT INTO usuarios(login, senha) values (?, ?)";
		PreparedStatement insert = connection.prepareStatement(sql);
		insert.setString(1,  usuario.getLogin());
		insert.setString(2,  usuario.getSenha());
		insert.execute();
		//se der certo, ele faz o commit no banco
		connection.commit();
		
	}catch(Exception e)
		{
		//se der errado ele faz o rollback
		connection.rollback();
	     }
		
	}

	
	public List<BeanCursoJsp> listar() throws Exception {

		List<BeanCursoJsp> listar = new ArrayList<BeanCursoJsp>(); // Criando a lista do tipo BeanCursoJsp

		String sql = "select * from usuarios"; // Preparação da url SQL para select no banco

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {

			BeanCursoJsp beanCursoJsp = new BeanCursoJsp(); // A cada verificação positiva é criado um novo objeto
			beanCursoJsp.setLogin(resultSet.getString("login"));
			beanCursoJsp.setSenha(resultSet.getString("senha"));
		

			// ADICIONANDO OS OBJETOS NA LISTA BEANCURSOJSP
			listar.add(beanCursoJsp);
		}
		return listar; // Retornando a lista com os objetos
	}
	
	
	public void delete(String login) throws SQLException {
		
		try {
			String sql = "DELETE FROM usuarios WHERE login='"+login+"' ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			connection.commit();
		}catch(Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public BeanCursoJsp consultar(String login) throws Exception {
		
		//String sql = "SELECT * FROM usuarios WHERE login='"+ login +"'";
		String sql = "select * from usuarios where login= '" + login + "'";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql); // Fazendo o Prepared Statement para
		// preparar a conexão.
		ResultSet resultSet = preparedStatement.executeQuery();

	if(resultSet.next()) {
		BeanCursoJsp beanCursoJsp = new BeanCursoJsp();
		beanCursoJsp.setLogin(resultSet.getString("login"));
		beanCursoJsp.setSenha(resultSet.getString("senha"));
	
		return	beanCursoJsp;
	}
	return null;

	}
}
