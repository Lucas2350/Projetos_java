package manipula;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conecta.BD;

public class ConsultaBD {
	
	public static void main(String[] args) {
		
		BD bd = new BD();
		
		if (bd.abreConexao() ) {
			
			try {
				
				String sql = "SELECT id, nome, telefone FROM pessoa WHERE id >= ? ORDER BY id";
				PreparedStatement stmt = bd.con.prepareStatement(sql);
				
				stmt.setString(1, "2");
								
				ResultSet rs = stmt.executeQuery();
				
				System.out.println("ID        NOME                        TELEFONE");
				System.out.println("--------  -------------------------   ---------------");
				
				while (rs.next()) {
					String id = rs.getString("id");
					String nome = rs.getString("nome");
					String tel = rs.getString("telefone");
					System.out.println(id + "        " + nome + "                         " + tel);
				}
				
				rs.close();
				stmt.close();
				bd.fechaConexao();
				
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
			
		} else {
			System.out.println("Erro ao conectar");
		}
		
	}
	
}
