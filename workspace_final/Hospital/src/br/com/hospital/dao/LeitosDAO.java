package br.com.hospital.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.hospital.util.ConnectionFactory;
import br.com.hospital.bean.Leitos;

public class LeitosDAO {
private Connection conn;
private PreparedStatement ps;

//chamando o ConnectionFactory
	public LeitosDAO() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}
	
	// metodo de salvar
	public void salvar (Leitos leito) throws Exception{
		if (leito == null)
			throw new Exception("A informacao nao pode ser nula");
		try {
			//estrutura SQL
			String SQL = "INSERT INTO leito(numCama, localPredio) VALUES (?, ?)";
			
			ps = this.conn.prepareStatement(SQL);
			ps.setInt(1, leito.getNumeroLeitos());
			ps.setString(2, leito.getLocal());
			ps.executeUpdate();
		}catch (Exception sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		}
		finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	// metodo de listar 
	public List<Leitos> listar () throws Exception{
		List<Leitos> listaLeitos = new ArrayList<Leitos>();
		
		try {
			
			String SQL = "SELECT *FROM leito";
			ps = this.conn.prepareStatement(SQL);
			ResultSet dados = ps.executeQuery(SQL);
			
			 while(dados.next())
	         {
			
			Leitos leitos = new Leitos();
			
			leitos.setNumeroLeitos(dados.getInt("numCama"));
			leitos.setLocal(dados.getString("localPredio"));
			
			listaLeitos.add(leitos);}
			
		} catch (Exception sqle) {
			throw new Exception ("Erro ao consultar o banco " + sqle);
		}finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
		return listaLeitos;	
	}
		
		// exluir
		public void excluir(int numLeitos) throws Exception {
			
			try {
			
				
				String SQL ="DELETE FROM leito WHERE numCama = ?";
				ps = this.conn.prepareStatement(SQL);
				ps.setInt(1,numLeitos);
				ps.executeUpdate();
			}catch(SQLException sqle) {
				throw new Exception("Erro ao deletar os dados"+ sqle);
			}finally {
				ConnectionFactory.closeConnection(conn, ps);
			}
			
		}
		public Leitos buscar(int numLeitos) throws Exception{
			Leitos leito = new Leitos();
			try {
				String SQL = "SELECT * FROM leito WHERE numCama = ?";
				ps = this.conn.prepareStatement(SQL);
				ps.setInt(1,numLeitos);

				ResultSet dados = ps.executeQuery();
				while(dados.next()) {
					leito.setNumeroLeitos(dados.getInt("numCama"));
					leito.setLocal(dados.getString("localPredio"));
					
				}
				
			}catch(SQLException sqle) {
				throw new Exception("Erro ao deletar os dados"+ sqle);
			}finally {
				ConnectionFactory.closeConnection(conn, ps);
			}
			return leito;	
		}
	}

