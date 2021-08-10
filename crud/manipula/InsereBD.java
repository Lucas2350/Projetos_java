package manipula;

import conecta.BD;
import java.sql.*;

import javax.swing.JOptionPane;

public class InsereBD {

	public static void main(String[] args) {
		
		BD bd = new BD();
		
		if (bd.abreConexao() ) {
			
			try {
				
				String sql = "INSERT INTO pessoa (nome, telefone) VALUES (? , ?)";
				PreparedStatement stmt = bd.con.prepareStatement(sql);
				
				String nome = JOptionPane.showInputDialog(null, "Informe o nome");
				String telefone = JOptionPane.showInputDialog(null, "Informe o telefone");
				
				// preparo a passagem de parametros 
				stmt.setString(1, nome);
				stmt.setString(2, telefone);
								
				int LinhasInseridas = stmt.executeUpdate();
				if (LinhasInseridas != 0) {
					System.out.println("Registro inserido com sucesso");
				}				
				
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
