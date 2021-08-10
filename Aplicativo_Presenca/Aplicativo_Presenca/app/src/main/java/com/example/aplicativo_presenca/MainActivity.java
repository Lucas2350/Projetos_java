package com.example.aplicativo_presenca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Botão de conectar
      Button btnConectar = (Button) findViewById(R.id.btnConectar);
      btnConectar.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              TextView idRGM = (TextView)findViewById(R.id.idRGM);
              TextView idSenha = (TextView)findViewById(R.id.idSenha);
              String rgm = idRGM.getText().toString();//pegando o texto das Textview e transformando em variavel
              String senha = idSenha.getText().toString();

              //os usuários validos são:rgm :1939  senha:lucas  // rgm :1959  senha:rafael8492
              // rgm :1879   senha:2071
              //caso validado entra no sistema

              if(rgm.equals("1939")&&senha.equals("lucas")){
                    alert("login com sucesso!!");
                  Intent segundaActivity = new Intent(MainActivity.this, Tela_de_Disciplina.class);
                  startActivity(segundaActivity);

              }
            else  if(rgm.equals("1959")&&senha.equals("rafael8492")){
                  alert("login com sucesso!!");
                  Intent segundaActivity = new Intent(MainActivity.this, Tela_de_Disciplina.class);
                  startActivity(segundaActivity);

              }
             else if(rgm.equals("1879")&&senha.equals("2071")){
                  alert("login com sucesso!!");
                  Intent segundaActivity = new Intent(MainActivity.this, Tela_de_Disciplina.class);
                  startActivity(segundaActivity);

              }
              else if(rgm.equals("")&&senha.equals("")){
                  alert("digite alguma coisa!!");


              }

              else{
                  alert("!!senha errada");
              }

          }
      });


    }
    private void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();

    }


}