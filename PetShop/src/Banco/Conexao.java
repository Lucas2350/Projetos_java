/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import Negocio.Logica;
import com.mysql.jdbc.Connection;
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
 * @author Aluno
 */
public class Conexao {
      public Connection conexao;
   
      
      
      Logica logi= new Logica();//instancia a classe logica
    String sql;//declara uma string para receber sql;
      public Conexao() throws SQLException //inicia a conexao com o banco
    {
       
            conexao= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/petshop","root","");
        //Ele vai ultilizar o driver jdbc para puxar o caminho do banco.
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
      
            System.out.println("Conectado");
                 
    }
      public static void Conectar() 
      {
          try
          {
          Class.forName("com.mysql.jdbc.Driver");
              java.sql.Connection Con = DriverManager.getConnection("jdbc:mysql://localhost/petshop","root","");
         System.out.println("Conectado");
          }
          catch(ClassNotFoundException ex)
          {
              System.out.println("Classe não conectada");
          }
          catch (SQLException e)
                  {
                      System.out.println(e);
                      throw new RuntimeException(e);
                  }
          
          
      }
     public void inserir(Logica logi) throws SQLException{   
       conexao= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/petshop","root","");
           //abaixo a variavel sql esta recebendo o camando insert do sql
       sql = "Insert Into cliente(nome,telefone,nomeanimal,especie,estetica,tosa)values(?,?,?,?,?,?)";
     PreparedStatement st= conexao.prepareStatement(sql);  //ele esta preparando os parametros do banco que irao se alocar nas determinadas variaveis
     
     
     st.setString(1,logi.getNome());//1 representa a coluna do campo nome no banco, logi e a classe logica getNome pega a variavel nome da classe logica 
     st.setString(2,logi.getTelefone());
      st.setString(3,logi.getNomeanimal());
       st.setString(4,logi.getEspecie());
        st.setString(5,logi.getEstetica());
      st.setString(6,logi.getTosa());
       st.execute();//executa
    st.close();//encerra
     
    JOptionPane.showMessageDialog(null,"Dados registrados com sucesso"); 
    
    
     } 
      public void atualizar(Logica logi)
    {
        try{
            java.sql.Connection cone = DriverManager.getConnection("jdbc:mysql://localhost/petshop","root","");
            String sql = "Update cliente set nome=?,telefone=?,nomeanimal=?,especie=?,estetica=?,tosa=? where id=?";
            PreparedStatement st = cone.prepareStatement(sql);
            st.setInt(7,logi.getId());//no caso do id a coluna ta 7 pq no banco ela é igual a 0 então coloque o numero que vem depois do ultimo pro java aceita e nois
           
            st.setString(1,logi.getNome());
            st.setString(2,logi.getTelefone());
            st.setString(3,logi.getNomeanimal());
            st.setString(4,logi.getEspecie());
            st.setString(5,logi.getEstetica());
            st.setString(6,logi.getTosa());
            st.execute();
            st.close();
            
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso","Insert sucedido",JOptionPane.INFORMATION_MESSAGE);
        }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Erro ao atualizar");
            
        }
        
          
    }
     
           
      public void pesquisar(Logica logi) throws SQLException{
        
      
     
            conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/petshop","root","");
       
        
        String sql="Select * from cliente";
     
        PreparedStatement st = conexao.prepareStatement(sql);        
        //st.setInt(1,logi.getId());
        ResultSet rs =st.executeQuery();
        while(rs.next()){
            logi.setId(rs.getInt(0));
            logi.setNome(rs.getString(1));
            logi.setTelefone(rs.getString(2));
            logi.setNomeanimal(rs.getString(3));
             logi.setEspecie(rs.getString(4));
              logi.setEstetica(rs.getString(5));
             logi.setTosa(rs.getString(6));
              System.out.println(rs.getString("Id")+",");
            System.out.println(rs.getString("Nome")+",");
             System.out.println(rs.getString("Telefone")+",");
            System.out.println(rs.getString("Nomeanimal")+",");
            System.out.println(rs.getString("Especie")+",");
            System.out.println(rs.getString("Estetica")+",");
            System.out.println(rs.getString("Tosa")+",");
            
             
             
        
        }
        
    }
     public ArrayList BuscarDados(String strSQL)throws SQLException
     {
         ArrayList<Logica>valores = new ArrayList<Logica>();//vai puxar os valores da classe logica
         Connection cone= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/petshop","root","");
         String sql = "SELECT * FROM cliente";
         PreparedStatement stmt = cone.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery();
            while (rs.next())
                
            {
                Logica logi = new Logica();
                logi.setId(rs.getInt(1));
               logi.setNome(rs.getString(2));
                logi.setTelefone(rs.getString(3).trim());
                logi.setNomeanimal(rs.getString(4).trim());
                logi.setEspecie(rs.getString(5).trim());
                logi.setEstetica(rs.getString(6).trim());
                logi.setTosa(rs.getString(7).trim());
                valores.add(logi);
            }
                
     
     
     return valores;}

    
   
      public void Excluir (int idAtual)
    {
        try
        {
            Connection con = (Connection) DriverManager.getConnection ("jdbc:mysql://localhost/petshop","root","");
                String comandoSql = "DELETE FROM cliente WHERE id = ?";
                
             PreparedStatement st = con.prepareStatement(comandoSql);
            st.setInt(1,idAtual);
            st.execute();
            st.close();
        
         JOptionPane.showMessageDialog(null,"Pessoa excluida com sucesso de sua agenda!","Delete sucedido!",
         JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException ex)
          {
                    JOptionPane.showMessageDialog(null,"Erro ao deletar este dado.");
          }
    }
     
     
     
     
     
     
     
     
     
     
     
}

      
      
      
      
      
      
      
      
     

