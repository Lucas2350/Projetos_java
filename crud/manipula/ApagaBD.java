package manipula;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conecta.BD;

public class ApagaBD {
	
	public static void main(String[] args) {
		
		BD bd = new BD();
		
		if (bd.abreConexao() ) {
			
			try {
				
				String sql = "DELETE FROM pessoa WHERE id = ?";
				PreparedStatement stmt = bd.con.prepareStatement(sql);
				
				String id = JOptionPane.showInputDialog(null, "Informe o código da pessoa");
				
				// preparo a passagem de parametros 
				stmt.setString(1, id);
								
				int LinhasAlteradas = stmt.executeUpdate();
				if (LinhasAlteradas != 0) {
					System.out.println("Registro alterado com sucesso");
				} else {
					System.out.println("Registro não encontrado");
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
