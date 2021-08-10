package br.com.hospital.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.hospital.bean.Pacientes;
import br.com.hospital.util.ConnectionFactory;

public class PacientesDAO {
	private Connection conn;
	private PreparedStatement ps;

	//chamando o ConnectionFactory
		public PacientesDAO() throws Exception {
			try {
				this.conn = ConnectionFactory.getConnection();
			} catch (Exception e) {
				throw new Exception("erro: \n" + e.getMessage());
			}
		}
		
		//metódo para cadastrar 
		public void salvar (Pacientes pacientes) throws Exception{
			if (pacientes == null)
				throw new Exception("A informacao nao pode ser nula");
			try {
				//estrutura SQL
				String SQL = "INSERT INTO paciente (pnome, "
						
						+ "pconvenio) "
						+ "values (?, ?)";
				
				ps = this.conn.prepareStatement(SQL);
				ps.setString(1, pacientes.getNome());
				ps.setString(2, pacientes.getConvenio());
				ps.executeUpdate();
			}catch (Exception sqle) {
				throw new Exception("Erro ao inserir dados " + sqle);
			}
			finally {
				ConnectionFactory.closeConnection(conn, ps);
			}
		}	
	
		
		
		public List<Pacientes> listar() throws Exception {
			

			List<Pacientes> listaPacientes= new ArrayList<Pacientes>();
			try
			{
			         String SQL = "Select * from paciente";

			         ps = this.conn.prepareStatement(SQL);
			         ResultSet dados = ps.executeQuery();

			         while(dados.next())
			         {
			        	 
			     Pacientes pacientes = new Pacientes();
			     pacientes.setNome(dados.getString("pnome"));
			     pacientes.setConvenio(dados.getString("pconvenio"));
			    

			     listaPacientes.add(pacientes);}
			      
			  }catch(Exception sqle) {
				  throw new Exception("erro ao consultar o banco" + sqle);
				  
			  }
			  finally {
				  ConnectionFactory.closeConnection(conn, ps);
			  }
					return listaPacientes;
				}
		
		
		
		public void alterar (String nome) throws Exception{
			if (nome == null)
				throw new Exception("A informacao nao pode ser nula");
			try {
				//estrutura SQL
				String SQL = "update paciente SET pnome = ?,pconvenio = ? where pnome = ?";
						
									
				ps = this.conn.prepareStatement(SQL);
				ps.setString(1,nome);
				
				
				
				ps.executeUpdate();
			}catch (Exception sqle) {
				throw new Exception("Erro ao inserir dados " + sqle);
			}
			finally {
				ConnectionFactory.closeConnection(conn, ps);
			}
		}	
		public void excluir(String nome) throws Exception {
		
			try {
			
				
				String SQL ="DELETE FROM paciente WHERE pnome = ?";
				ps = this.conn.prepareStatement(SQL);
				ps.setString(1,nome);
				ps.executeUpdate();
			}catch(SQLException sqle) {
				throw new Exception("Erro ao deletar os dados"+ sqle);
			}finally {
				ConnectionFactory.closeConnection(conn, ps);
			}
			
		}
		public Pacientes buscar(String nome) throws Exception{
			Pacientes pacientes = new Pacientes();
			try {
				String SQL = "SELECT * FROM paciente WHERE pnome = ?";
				ps = this.conn.prepareStatement(SQL);
				ps.setString(1,nome);

				ResultSet dados = ps.executeQuery();
				while(dados.next()) {
					pacientes.setNome(dados.getString("pnome"));
					pacientes.setConvenio(dados.getString("pconvenio"));
					
				}
				
			}catch(SQLException sqle) {
				throw new Exception("Erro ao deletar os dados"+ sqle);
			}finally {
				ConnectionFactory.closeConnection(conn, ps);
			}
			
			
			return pacientes;
		}
		

	

		
		
		
				
	

	

}
