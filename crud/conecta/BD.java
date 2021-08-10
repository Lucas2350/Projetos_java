package conecta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {
	
	public Connection con = null;
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String DBNAME = "agenda"; 
	private final String URL = "jdbc:mysql://localhost:3306/" + DBNAME;
	private final String LOGIN = "root";
	private final String SENHA = "root";
	
	public boolean abreConexao() {
		try { 						// obrigatorio para conexao com BD
			Class.forName(DRIVER);  // indica qual a CONSTANTE a classe usa
			
			// abertura da conexao com parametros de login e senha  
			con = DriverManager.getConnection(URL, LOGIN, SENHA);
			
			System.out.println("Classe BD - Conectou");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Classe BD - Driver nao encontrado" + e.toString());
			return false;
		} catch (SQLException e) {
			System.out.println("Classe BD - Falha ao conectar" + e.toString());
			return false;
		}
	}
	
	public void fechaConexao() {
		try {
			con.close();
			System.out.println("Classe BD - Desconectou");
		} catch (SQLException e) {			
		}
	}
}

