package caixaEletronico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
   public Connection con = null;
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String DBNAME = "projetoCaixa"; 
	private final String URL = "jdbc:mysql://localhost:3306/" + DBNAME + "?serverTimezone=UTC";
	private final String LOGIN = "root";
	private final String SENHA = null;
	
	public Connection getConnection() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, LOGIN, SENHA);
			return con;
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		}
                return con;
	}
    
        public void close() {
		try {
			con.close();
		} catch (SQLException e) {			
		}
	}
}

