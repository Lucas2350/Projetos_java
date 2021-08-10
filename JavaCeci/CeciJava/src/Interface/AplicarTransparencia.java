/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;

/**
 *
 * @author Aluno
 */
//Classe responsável por aplicar a transparencia na tela splash
public class AplicarTransparencia {
    
    public void aplicarTransparencia (JFrame frame)
    {
    frame.setUndecorated(true);
    frame.setBackground(new Color(0,0,0,0));
    }
    
   
    
    
}
