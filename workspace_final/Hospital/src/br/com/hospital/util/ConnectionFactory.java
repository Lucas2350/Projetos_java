package br.com.hospital.util;

import java.sql.*;

public class ConnectionFactory {
// criar um metodo pra cira a conexao
	public static  Connection getConnection() throws Exception {
		try {
			// qual o tipo do banco de dados
			Class.forName("com.mysql.jdbc.Driver");

			// estabelecer a conexao
			String url = "jdbc:mysql://localhost:3308/hospital";
			String login = "root";
			String senha = "";
			return DriverManager.getConnection(url, login, senha);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	// fecha uma conexão de três formas: conn, stmt, rs

	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception {
		close(conn, stmt, rs);
	}

	public static void closeConnection(Connection conn, Statement stmt) throws Exception {
		close(conn, stmt, null);
	}

	public static void closeConnection(Connection conn) throws Exception {
		close(conn, null, null);
	}

	private static void close(Connection conn, Statement stmt, ResultSet rs) throws Exception {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
