
package caixaEletronico;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class GUI extends javax.swing.JFrame {
    
    private DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Historico"},0);
    private int cotaMinima=0;
    
  
    public GUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonRelatorio = new javax.swing.JButton();
        jButtonSaque = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jButtonValorTotal = new javax.swing.JButton();
        jButtonReposicao = new javax.swing.JButton();
        jButtonCotaMinima = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Caixa eletronico");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Modulo do Cliente:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Modulo do Administrador:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Modulo do Ambos:");

        jButtonRelatorio.setText("Relatorio de Cedulas");
        jButtonRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRelatorioActionPerformed(evt);
            }
        });

        jButtonSaque.setText("Efetuar Saque");
        jButtonSaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaqueActionPerformed(evt);
            }
        });

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jButtonValorTotal.setText("Valor total disponivel");
        jButtonValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValorTotalActionPerformed(evt);
            }
        });

        jButtonReposicao.setText("Reposicao de Cedulas");
        jButtonReposicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReposicaoActionPerformed(evt);
            }
        });

        jButtonCotaMinima.setText("Cota Minima");
        jButtonCotaMinima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCotaMinimaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(0, 141, Short.MAX_VALUE))
                    .addComponent(jButtonSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonReposicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCotaMinima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButtonSaque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonReposicao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCotaMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addComponent(jButtonSaque, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(278, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButtonRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRelatorioActionPerformed
        
        CaixaEletronico caixa = new CaixaEletronico();
        String resposta = caixa.pegaRelatorioCedulas();
        JOptionPane.showMessageDialog(null, resposta, "Relatorio", JOptionPane.INFORMATION_MESSAGE);
    }

    private void jButtonValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValorTotalActionPerformed
        
        CaixaEletronico caixa = new CaixaEletronico();
        String resposta = caixa.pegaValorTotalDisponivel();
        JOptionPane.showMessageDialog(null, "\nValor total disponivel: R$" + resposta+",00", "Relatorio", JOptionPane.INFORMATION_MESSAGE);
        
    }
    private void jButtonReposicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReposicaoActionPerformed
        
        
        int valor=0;
        int vn=0;
        
        do{
            try{
                String valorAux = JOptionPane.showInputDialog(null, "Informe o valor da nota para efetuar reposicao: ",
                        "Reposicao", JOptionPane.QUESTION_MESSAGE);
                valor = Integer.parseInt(valorAux);
                
                if( valor!=2 && valor!=5 && valor!=10 && valor!=20 && valor!=50 && valor!=100 ){
                    JOptionPane.showMessageDialog(null, 
                            "Valores possiveis: \n2, 5, 10, 20, 50 e 100.", 
                            "O valor informado Ã© invalido.", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                break;
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Informe apenas valores numerais.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }while(true);
        
        do{
        
            try{
                
                String vnAux = JOptionPane.showInputDialog(null, "Informe a quantidade de notas para inserir: ",
                        "Reposicao", 3);
               int n = Integer.parseInt(vnAux);
                
                if( vn<=0 ){
                    JOptionPane.showMessageDialog(null, 
                            "Não é possivel inserir uma quantidade menor ou igual a zero de notas.", 
                            "O valor informado é invalido.", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                break;
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Informe apenas valores numerais.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }while(true);
        
        if( valor!=0 && vn!=0 ){
            CaixaEletronico caixa = new CaixaEletronico();
            String resposta = caixa.reposicaoCedulas(valor, vn);
            
            JOptionPane.showMessageDialog(null, resposta);
            
            
            Object obj[] = new Object[]{"Reposição de " + vn + " cédulas de R$" + valor};
            tableModel.addRow(obj);
            
        }else
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu e não foi possivel efetuar a reposicao", "ERROR", JOptionPane.ERROR_MESSAGE);
        
    }

    private void jButtonSaqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaqueActionPerformed
        
        int valor;
        String valorAux;
        
        do{
            try{
                valorAux = JOptionPane.showInputDialog(null, "Informe o valor para sacar: ");
                valor = Integer.parseInt(valorAux);
                
                if(valor <= 0){
                    JOptionPane.showMessageDialog(null, "Não é possivel sacar um valor menor ou igual a zero.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                break;
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Informe apenas valores numerais.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }while(true);
        
        CaixaEletronico caixa = new CaixaEletronico();
        
        if( Integer.parseInt(caixa.pegaValorTotalDisponivel()) < cotaMinima ){
            JOptionPane.showMessageDialog(null, "Caixa abaixo da cota minima, chame um operador", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if( Integer.parseInt(caixa.pegaValorTotalDisponivel()) < valor ){
            
            JOptionPane.showMessageDialog(null, "Saque nÃ£o realizado por falta de notas.", "Saque", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        String resposta = caixa.sacar(valor);
        
        JOptionPane.showMessageDialog(null, resposta, "Saque", JOptionPane.INFORMATION_MESSAGE);
        
        Object obj[] = new Object[]{"Saque de R$" + valor + "."};
        tableModel.addRow(obj);
        
    }
        private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        
        Extrato e = new Extrato(tableModel);
        e.setVisible(true);
        
    }

    private void jButtonCotaMinimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCotaMinimaActionPerformed
        
        int valor;
        String valorAux;
        
        do{
            try{
                valorAux = JOptionPane.showInputDialog(null, "Informe o valor para setar a cota minima: ");
                valor = Integer.parseInt(valorAux);
                
                if(valor < 0){
                    JOptionPane.showMessageDialog(null, "Não é possivel colocar um valor menor que zero como cota minima",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                break;
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Informe apenas valores numerais.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }while(true);
        
        this.cotaMinima = valor;
        
    }
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    
    private javax.swing.JButton jButtonCotaMinima;
    private javax.swing.JButton jButtonRelatorio;
    private javax.swing.JButton jButtonReposicao;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonSaque;
    private javax.swing.JButton jButtonValorTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    
}