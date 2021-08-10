/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BancoDeDados;

import Negocio.Logica;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Gildo Lima
 */
public class DAO {
    
        Connection conexao;
    
      public void InserirAluno (Logica logi)
    {
        //é string, pois vai receber os comandos do sql como "insert, select"
        String sqlAluno;
        
        //Inserindo os dados no banco
        try 
            {                       
            conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/cecijava","root","");
            sqlAluno = "Insert into aluno (nome, alergias, dataAdmissao, dataNasc, doencas, sexo, turma, desenvolvimento) values(?,?,?,?,?,?,?,?)";
            //PreparedStatement faz o insert receber os parametros, metodo par pegar os parametros
            PreparedStatement stAluno = conexao.prepareStatement(sqlAluno);
            
            //Insertamos os parametros em ordem dos ? e usamos o get da classe
            stAluno.setString(1,logi.getNome());
            stAluno.setString(2,logi.getAlergias());
            stAluno.setString(3,logi.getDataAdmissao());
            stAluno.setString(4,logi.getDataNasc());
            stAluno.setString(5,logi.getDoencas());
            stAluno.setString(6,logi.getSexo());  
            stAluno.setString(7,logi.getTurma());
            stAluno.setString(8,logi.getDesenvolvimento());
            
            stAluno.execute();
            stAluno.close();
            
            JOptionPane.showMessageDialog(null, "Aluno registrados com sucesso!");
            
            } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Aluno");
        }
    }
      
        public void InserirEndereco (Logica logi)
    {
        //é string, pois vai receber os comandos do sql como "insert, select"
        String sqlEndereco;
        
        try 
        {
       
            
            
            conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/cecijava","root","");
            sqlEndereco = "Insert into endereco (rua, numero, complemento, bairro, cep, cidade, estado, idAlunofk) values(?,?,?,?,?,?,?,?)";
            //PreparedStatement faz o insert receber os parametros, metodo par pegar os parametros
            PreparedStatement stEndereco = conexao.prepareStatement(sqlEndereco);
            
            //Insertamos os parametros em ordem dos ? e usamos o get da classe
            stEndereco.setString(1,logi.getRua());
            stEndereco.setString(2,logi.getNumero());
            stEndereco.setString(3,logi.getComplemento());
            stEndereco.setString(4,logi.getBairro());
            stEndereco.setString(5,logi.getCep());
            stEndereco.setString(6,logi.getCidade());  
            stEndereco.setString(7,logi.getEstado());
            stEndereco.setInt(8,logi.getIdAlunofk());
            
            stEndereco.execute();
            stEndereco.close();
            
             JOptionPane.showMessageDialog(null, " Endereço registrado com sucesso!");
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar endereço");
        }
    }        
  
          
       //Método para pesquisar o Código do aluno do banco para que possa inserir este código na chave estrangeira
        public void pesquisarCodigo(Logica logi) throws SQLException{     
           
        conexao = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/cecijava","root","");
       
        
        String sql= "Select * from aluno where nome=?";
     
        PreparedStatement st = conexao.prepareStatement(sql);        
        st.setString(1,logi.getNome());
        ResultSet rs =st.executeQuery();
        while(rs.next()){
            logi.setIdAluno(rs.getInt(1));
            logi.setNome(rs.getString(2));          
           
            
                   }
        
    }
        
        public void pesquisarAlunoNome(Logica logi) throws SQLException{       
      
     
        conexao = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/cecijava","root","");
       
        
        String sql= "select * from aluno, endereco where idAlunofk = idAluno and nome like ?";
     
        PreparedStatement st = conexao.prepareStatement(sql);        
        st.setString(1,logi.getNome());
        ResultSet rs =st.executeQuery();
        while(rs.next()){
            logi.setIdAluno(rs.getInt(1));
            logi.setNome(rs.getString(2));
            logi.setDataNasc(rs.getString(3));
            logi.setDoencas(rs.getString(4));
            logi.setAlergias(rs.getString(5));
            logi.setDataAdmissao(rs.getString(6)); 
            logi.setTurma(rs.getString(7));
            logi.setSexo(rs.getString(8));
            logi.setDesenvolvimento(rs.getString(9));
            logi.setIdEndereco(rs.getInt(10));
            logi.setRua(rs.getString(11));
            logi.setNumero(rs.getString(12));
            logi.setComplemento(rs.getString(13));
            logi.setBairro(rs.getString(14));
            logi.setCep(rs.getString(15));
            logi.setCidade(rs.getString(16));
            logi.setEstado(rs.getString(17));
            logi.setIdAlunofk(rs.getInt(18));
            
            
            
            
                   }
        
    }
         public ArrayList BuscarDadosTodos(String strSQL)throws SQLException
     {
         ArrayList<Logica>valores = new ArrayList<Logica>();
         com.mysql.jdbc.Connection cone= (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/cecijava","root","");
         String sql = "select * from aluno, endereco where idAlunofk = idAluno";
         PreparedStatement stmt = cone.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery();
            while (rs.next())
                
            {
            Logica logi = new Logica();
          
            
       logi.setNome(rs.getString(2));      
       logi.setRua(rs.getString(11));
       logi.setDataAdmissao(rs.getString(4));
       logi.setBairro(rs.getString(14));
       logi.setDataNasc(rs.getString(3));
       logi.setCidade(rs.getString(16));
       logi.setTurma(rs.getString(7));
       
       
            valores.add(logi);
            }
                
     
     
     return valores;}
         
              
     
              public void excluirEndereco (int idAtual){
     try{
       
         conexao = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/cecijava","root","");
         String comandoSql = "DELETE FROM endereco WHERE idAlunofk=?";
         
         PreparedStatement st= conexao.prepareStatement(comandoSql);
         st.setInt(1,idAtual);
         st.execute();
         st.close();
         
        JOptionPane.showMessageDialog(null,"Endereço excluido com sucesso","Delete Sucedido", JOptionPane.INFORMATION_MESSAGE);
     }catch (SQLException ex){
         JOptionPane.showMessageDialog(null, "Erro ao deletar estes dados");
     }
     
     }
         
         
         
         
         
         public void excluirAluno (int idAtual){
     try{
       
         conexao = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/cecijava","root","");
         String comandoSql = "DELETE FROM aluno WHERE idAluno=?";
         
         PreparedStatement st= conexao.prepareStatement(comandoSql);
         st.setInt(1,idAtual);
         st.execute();
         st.close();
         
        JOptionPane.showMessageDialog(null,"Aluno excluido com sucesso","Delete Sucedido", JOptionPane.INFORMATION_MESSAGE);
     }catch (SQLException ex){
         JOptionPane.showMessageDialog(null, "Erro ao deletar estes dados");
     }
     
     }
         
            public void AtualizarEndereco (Logica logi) throws SQLException
    {
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cecijava", "root", "");
            
            String sql = "Update endereco set rua = ?, numero = ?, complemento = ?, bairro = ?, cep = ?, cidade = ?, estado = ? where idAlunoFk= ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(8, logi.getIdAlunofk());
            st.setString(1, logi.getRua());            
            st.setString(2, logi.getNumero());
            st.setString(3, logi.getComplemento());
            st.setString(4, logi.getBairro());
            st.setString(5, logi.getCep());
            st.setString(6, logi.getCidade());
            st.setString(7, logi.getEstado());
            
            
            st.execute();
            st.close();
            
            JOptionPane.showMessageDialog(null, "Endereço atualizado com sucesso", "Insert sucedido!", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
            public void AtualizarAluno (Logica logi) throws SQLException
    {
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cecijava", "root", "");
            
            String sql = "Update aluno set nome = ?, dataNasc = ?, doencas = ?, alergias = ?, dataAdmissao = ?, turma = ?, sexo = ?, desenvolvimento = ? where idAluno = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(9, logi.getIdAluno());
            st.setString(1, logi.getNome());            
            st.setString(2, logi.getDataNasc());
            st.setString(3, logi.getDoencas());
            st.setString(4, logi.getAlergias());
            st.setString(5, logi.getDataAdmissao());
            st.setString(6, logi.getTurma());
            st.setString(7, logi.getSexo());
            st.setString(8, logi.getDesenvolvimento());
            
            st.execute();
            st.close();
            
            JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso", "Insert sucedido!", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
         
}

    

