package manipula;

import conecta.BD;
import java.sql.*;

import javax.swing.JOptionPane;

public class AlteraBD {

	public static void main(String[] args) {
		
		BD bd = new BD();
		
		if (bd.abreConexao() ) {
			
			try {
				
				String sql = "UPDATE pessoa SET telefone = ? WHERE id = ?";
				PreparedStatement stmt = bd.con.prepareStatement(sql);
				
				String id = JOptionPane.showInputDialog(null, "Informe o código da pessoa");
				String telefone = JOptionPane.showInputDialog(null, "Informe o telefone");
				
				// preparo a passagem de parametros 
				stmt.setString(1, telefone);
				stmt.setString(2, id);
								
				int LinhasInseridas = stmt.executeUpdate();
				if (LinhasInseridas != 0) {
					System.out.println("Registro alterado com sucesso");
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
