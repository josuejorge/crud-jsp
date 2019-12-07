package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.SingleConnection;

public class DAOLogin {

	// Precisamos de um objeto do tipo Connection para se conectar ao nosso banco.
	private Connection connection;

	// Craindo um construtor default ( SEM DIGITAR NADA PRESSIONE AS TECLAS CTRL +
	// ESPACO.
	public DAOLogin() {

		// Dizendo ao construtor que precisamos atribuir ao connection a conex�o do
		// banco de dados.
		connection = SingleConnection.getConnection();

	}

	// M�todo para validar os dados recebidos por parametros no login
	//� NECESS�RIO LAN�AR A EXCESS�O POIS O M�TODO IR� REALIZAR UMA CONSULTA AO BANCO DE DADOS.
	public boolean validarLogin(String login, String senha) throws SQLException {
		System.out.println("Entrando no m�todo validarLogin");
		
		String sql = "select * from usuarios where login = '" +login+ "' and senha = '" +senha+ "'";		//Utilizado ' pois se trata de uma String
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		System.out.println("A conex�o foi um sucesso!");
		
		//Se houver um resultSet � porque ele encontrou o usu�rio
		if (resultSet.next()) {
			
			System.out.println("Foi encontrado um usu�rio cadastrado com esse user e senha");
			
			return true;			//Possui usu�rio
			
		} else {
			
			System.out.println("N�o foi encontrado um usu�rio cadastrado com esse user e senha");
			
			return false;         //N�o possui usu�rio
		}
	}
}