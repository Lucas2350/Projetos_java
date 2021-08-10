/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BancoDeDados;

import Negocio.Logica;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class Conexao {
    
    Connection conexao;
    
   //Método de conexão com o banco
    public void Conectar() 
    {
          try 
        {
            //Driver Manager gerencia os  driver de conexao, que no caso é o jdbc
            conexao = (Connection) DriverManager.getConnection("Jdbc:mysql://localhost/ceci", "root", "");
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null,"Conectado");
        
         try 
        {
            //parametro de conexao
            //.com são pacotes
            Class.forName("com.mysql.Jdbc.Driver");
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }       
    
    }
   
    
}
