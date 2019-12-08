package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Respons�vel por fazer a conex�o com o banco de dados
 * 
 * @author erikm
 *
 */
public class SingleConnection {

	private static String banco = "jdbc:postgresql://localhost:5432/curso-jsp?autoReconnect=true";
	private static String password = "admin";
	private static String user = "postgres";
	private static Connection connection = null; // Connection do java.sql.Connection;

	// M�todo conectar � static para garantir que sempre ser� executado ao chamar
	// esta classe, com isso garantimos a conex�o ao banco.
	static {
		conectar();
	}

	// Construtor da classe
	public SingleConnection() {
		conectar();
	}

	// M�todo para se conectar ao banco, observe que o c�digo est� em um try/catch
	// para eventuais problemas ao se conectar
	private static void conectar() {
		try {
			System.out.println("Conectando ao banco");
			
			if (connection == null) {//UTILIZE O BRAKPOINT PARA DEBUG NESSA LINHA PARA ACOMPANHAR AS MENSAGENS DE CONEX�O NO CONSOLE!
				Class.forName("org.postgresql.Driver"); //Driver do banco PostgreSQL
				connection = DriverManager.getConnection(banco, user, password); //Passando os par�metros de conex�o ao banco
				connection.setAutoCommit(false); //Configurando o auto commit para desligado, assim podemos controlar quando os commits ser�o realizados
				
			}
			
		} catch (Exception e) {
			System.out.println("Exibindo erro de conex�o: "); //Ser� exibida no console em caso de erro com a conex�o do banco.
			e.printStackTrace(); //Erro armazenado em e que ser� exibido no console pelo printStackTrace
			throw new RuntimeException("Erro ao conectar com o banco de dados");
		}
	}
	
	//M�todo que retorna a conex�o
	public static Connection getConnection() {
		return connection;
	}
	
}