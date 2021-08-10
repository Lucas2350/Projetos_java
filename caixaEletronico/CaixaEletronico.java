package caixaEletronico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

    
public class CaixaEletronico implements ICaixaEletronico{
    
@Override
public String pegaRelatorioCedulas() {
String resposta = "Valor                Quantidade\n";


String comandoSql = "select valor, quantidade from notas";
Connection con = new Conexao().getConnection();

    try {
        PreparedStatement ps = con.prepareStatement(comandoSql);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            resposta = resposta + "\n";
            resposta = resposta +"R$"+ rs.getInt("valor");
            resposta = resposta +"                       "+ rs.getInt("quantidade");
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(CaixaEletronico.class.getName()).log(Level.SEVERE, null, ex);
    }

return resposta;
}


@Override
public String pegaValorTotalDisponivel() {
    
    String resposta = "";
    Connection con = new Conexao().getConnection();
    int notas2=0, notas5=0, notas10=0, notas20=0, notas50=0, notas100=0;

    //logica de pega o valor total disponivel no caixa eletronio
    String select1 = "select * from notas where valor=2";
    String select2 = "select * from notas where valor=5";
    String select3 = "select * from notas where valor=10";
    String select4 = "select * from notas where valor=20";
    String select5 = "select * from notas where valor=50";
    String select6 = "select * from notas where valor=100";

    try {
        PreparedStatement ps1 = con.prepareStatement(select1);
        PreparedStatement ps2 = con.prepareStatement(select2);
        PreparedStatement ps3 = con.prepareStatement(select3);
        PreparedStatement ps4 = con.prepareStatement(select4);
        PreparedStatement ps5 = con.prepareStatement(select5);
        PreparedStatement ps6 = con.prepareStatement(select6);
        
        ResultSet rs1 = ps1.executeQuery();
        ResultSet rs2 = ps2.executeQuery();
        ResultSet rs3 = ps3.executeQuery();
        ResultSet rs4 = ps4.executeQuery();
        ResultSet rs5 = ps5.executeQuery();
        ResultSet rs6 = ps6.executeQuery();
        
        if(rs1.next()) notas2 = rs1.getInt("quantidade");
        if(rs2.next()) notas5 = rs2.getInt("quantidade");
        if(rs3.next()) notas10 = rs3.getInt("quantidade");
        if(rs4.next()) notas20 = rs4.getInt("quantidade");
        if(rs5.next()) notas50 = rs5.getInt("quantidade");
        if(rs6.next()) notas100 = rs6.getInt("quantidade");
        
        int lolk = (notas2*2) + (notas5*5) + (notas10*10) + (notas20*20) + (notas50*50) + (notas100*100); 
        return(String.valueOf(lolk));
        
    } catch (SQLException ex) {
        Logger.getLogger(CaixaEletronico.class.getName()).log(Level.SEVERE, null, ex);
    }

    return resposta;
}


@Override
public String reposicaoCedulas(Integer notas, Integer quantidade) {
String resposta = "";

//logica de fazer a reposicao de cedulas e criar uma mensagem
String comandoSQL = "update notas set quantidade=quantidade+? where valor=?";
Connection con = new Conexao().getConnection();

    try {
        PreparedStatement ps = con.prepareStatement(comandoSQL);
        ps.setString(1, String.valueOf(quantidade));
        ps.setString(2, String.valueOf(notas));
        
        if(ps.executeUpdate() != 0 )
            resposta = "OperaÃ§Ã£o concluida com sucesso!\n\n"+quantidade+
                    " notas de R$"+notas+",00 foram inseridadas com sucesso!\n";
        else
            resposta = "Falha na operação!\n\nNão foi possivel efetuar a inserção, tente mais tarde.";
        
    } catch (SQLException ex) {
        Logger.getLogger(CaixaEletronico.class.getName()).log(Level.SEVERE, null, ex);
    }

//(resposta)ao usuario
return resposta;
}


@Override
public String sacar(Integer valor) {
    
    String resposta = "";
    Connection con = new Conexao().getConnection();

    int notas2=0, notas5=0, notas10=0, notas20=0, notas50=0, notas100=0;
    String select1 = "select * from notas where valor=2";
    String select2 = "select * from notas where valor=5";
    String select3 = "select * from notas where valor=10";
    String select4 = "select * from notas where valor=20";
    String select5 = "select * from notas where valor=50";
    String select6 = "select * from notas where valor=100";

    try {
        PreparedStatement ps1 = con.prepareStatement(select1);
        PreparedStatement ps2 = con.prepareStatement(select2);
        PreparedStatement ps3 = con.prepareStatement(select3);
        PreparedStatement ps4 = con.prepareStatement(select4);
        PreparedStatement ps5 = con.prepareStatement(select5);
        PreparedStatement ps6 = con.prepareStatement(select6);
        
        ResultSet rs1 = ps1.executeQuery();
        ResultSet rs2 = ps2.executeQuery();
        ResultSet rs3 = ps3.executeQuery();
        ResultSet rs4 = ps4.executeQuery();
        ResultSet rs5 = ps5.executeQuery();
        ResultSet rs6 = ps6.executeQuery();
        
        if(rs1.next()) notas2 = rs1.getInt("quantidade");
        if(rs2.next()) notas5 = rs2.getInt("quantidade");
        if(rs3.next()) notas10 = rs3.getInt("quantidade");
        if(rs4.next()) notas20 = rs4.getInt("quantidade");
        if(rs5.next()) notas50 = rs5.getInt("quantidade");
        if(rs6.next()) notas100 = rs6.getInt("quantidade");
        
    } catch (SQLException ex) {
        Logger.getLogger(CaixaEletronico.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    int lolk = valor;
    
    int v100 = valor/100;
    if( notas100 < v100 ) v100 = 0;
    valor = valor - (v100*100);
    
    int v50 = valor/50;
    if( notas50 < v50 ) v50 = 0;
    valor = valor - (v50*50);
    
    int v20 = valor/20;
    if( notas20 < v20 ) v20 = 0;
    valor = valor - (v20*20);
    
    int v10 = valor/10;
    if( notas10 < v10 ) v10 = 0;
    valor = valor - (v10*10);
    
    int v5 = valor/5;
    if( notas5 < v5 ) v5 = 0;
    valor = valor - (v5*5);
    
    int v2 = valor/2;
    if( notas2 < v2 ) v2 = 0;
    valor = valor - (v2*2);
    
    if( v2+v5+v10+v20+v50+v100 > 30 ){
        resposta = "\nNão e possiel realizar o saque pois é nessaria uma quantia igual ou superior a 30 notas.\n";
        
    }else if( valor == 1 ){
        resposta = "\nNao é possivel sacar este valor, tente um valor maior";
        
    }else if( valor > 0 || valor < 0 ){
        resposta = "\nSaque nao realizado por falta de notas, tente novamente mais tarde.\n";
        
    }else{
        resposta = "\nSaque realizado com sucesso!\nNotas utilizadas:\n\n";
        resposta = resposta + "\nNotas de R$2,00:     " + v2;
        resposta = resposta + "\nNotas de R$5,00:     " + v5;
        resposta = resposta + "\nNotas de R$10,00:    " + v10;
        resposta = resposta + "\nNotas de R$20,00:    " + v20;
        resposta = resposta + "\nNotas de R$50,00:    " + v50;
        resposta = resposta + "\nNotas de R$100,00:   " + v100;
        
        try{
            
            String sqlRemove="";
            
            if(v2>0){
                sqlRemove = "update notas set quantidade= quantidade-"+v2+" where valor=2";
                PreparedStatement ps = con.prepareStatement(sqlRemove);
                ps.executeUpdate();
            }
            
            if(v5>0){
                sqlRemove = "update notas set quantidade = quantidade-"+v5+" where valor=5";
                PreparedStatement ps = con.prepareStatement(sqlRemove);
                ps.executeUpdate();
            }
            
            if(v10>0){
                sqlRemove = "update notas set quantidade = quantidade-"+v10+" where valor=10";
                PreparedStatement ps = con.prepareStatement(sqlRemove);
                ps.executeUpdate();
            }
            
            if(v20>0){
                sqlRemove = "update notas set quantidade = quantidade-"+v20+" where valor=20";
                PreparedStatement ps = con.prepareStatement(sqlRemove);
                ps.executeUpdate();
            }
            
            if(v50>0){
                sqlRemove = "update notas set quantidade = quantidade-"+v50+" where valor=50";
                PreparedStatement ps = con.prepareStatement(sqlRemove);
                ps.executeUpdate();
            }
            
            if(v100>0){
                sqlRemove = "update notas set quantidade = quantidade-"+v100+" where valor=100";
                PreparedStatement ps = con.prepareStatement(sqlRemove);
                ps.executeUpdate();
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
return resposta;
}


@Override
public String armazenaCotaMinima(Integer minimo) {
String resposta = "";
return resposta;
}


public static void main(String arg[]){
    GUI janela = new GUI();
    janela.setVisible(true);

} 

}

    
