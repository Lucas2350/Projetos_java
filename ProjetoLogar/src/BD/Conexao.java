/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class Conexao {
    public static void main(String arg[]){
        
         try { String endereco= "Jdbc:mysql://localhost/login";
            String user = "root";
            String ps="";
        
           Class.forName("com.mysql.jdbc.Driver");
             Connection conexao = (Connection) DriverManager.getConnection (endereco,user,ps);
             System.out.println("Conectado");
            // } catch()
        } catch (Exception ex) {
               System.out.println(" "+ex);
        }
        
        
        
    }
    
    
    
    
    
    
}
