package com.example.aplicativo_presenca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;
import java.text.SimpleDateFormat;

public class Tela_de_Disciplina extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de__disciplina);



        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            try {
                LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

                LocationListener locationListener = new LocationListener() {
                    public void onLocationChanged(Location location) {
                        Button btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

                        TextView lat = findViewById(R.id.txtLatitude);
                        TextView lon = findViewById(R.id.txtLongitude);


                        //Seta a localização real pelo gps caso  queira consultar com a localização da unicid
                        //comente as 4 linhas  e descomente da linha 58 á 61
                         /*lat.setText(""+location.getLatitude());
                        lat.getText();
                        lon.setText(""+location.getLongitude());
                        lon.getText(); */


                        String c = "-23.536622";
                        String d = "-46.561975";

                        lat.setText(""+location.getLatitude());
                        lat.setText(c);
                        lon.setText(""+location.getLongitude());
                        lon.setText(d);

                   //verifica se é a mesma localização da UNICID e libera o botão para registrar presença
                        if(c.equals( lat.getText()) && d.equals(lon.getText())){

                            btnRegistrar.setEnabled(true);
                            alert("Unicid");

                        }else {
                            btnRegistrar.setEnabled(false);
                            alert("Está fora da Unicid");

                        }





                    }

                    public void onStatusChanged(String provider, int status, Bundle extras) {
                    }

                    public void onProviderEnabled(String provider) {
                    }

                    public void onProviderDisabled(String provider) {
                    }
                };
                // Determina a atualização do GPS:
                // minTimeMs: intervalo de tempo mínimo entre atualizações de localização em milissegundos
                // minDistanceM: distância mínima entre atualizações de localização em metros
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, locationListener);
            } catch (SecurityException ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
            }

          //definindo os valores que as text views irão receber
            String data_n = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(new Date());
            String hora_a = new SimpleDateFormat("HH", Locale.getDefault()).format(new Date());
            String minuto = new SimpleDateFormat("mm", Locale.getDefault()).format(new Date());
            String dia_semana = new SimpleDateFormat("EEEE", Locale.getDefault()).format(new Date());
            TextView date = (TextView) findViewById(R.id.txtData);
            TextView dia = (TextView) findViewById(R.id.idDiaS);
            TextView min = (TextView) findViewById(R.id.txtMin);
            TextView hora = (TextView) findViewById(R.id.txtHora);

            date.setText(data_n);
            dia.setText(dia_semana);
            hora.setText(hora_a + " :");
            min.setText(minuto);

            TextView materia = (TextView) findViewById(R.id.idMateria);

              //comparando os dias para definir a disciplina do dia
            if (dia.getText().equals("segunda-feira")) {
                materia.setText("LINGUAGENS FORMAIS E AUTÔMATOS");
            } else if (dia.getText().equals("terça-feira")) {
                materia.setText("TRABALHO DE GRADUAÇÃO INTERDISCIPLINAR 1 ");
            } else if (dia.getText().equals("quarta-feira")) {
                materia.setText("PROGRAMAÇÃO PARA DISPOSITIVOS MÓVEIS");
            } else {
                materia.setText("FUNDAMENTOS DE INTELIGÊNCIA ARTIFICIAL(ead)");
            }


            Button btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
            btnRegistrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    int hora_c = Integer.parseInt(hora_a);
                    int min_c = Integer.parseInt(minuto);

                   //verifica se está no horario de aula
                    if (hora_c >= 19 && hora_c <= 21) {
                        alert("horario de aula!!!");
                        Intent terceiraActivity = new Intent(Tela_de_Disciplina.this, Tela_Confirma.class);
                        startActivity(terceiraActivity);

                    } else {
                        alert("não esta na hora da aula ou não está na Unicid");
                    }


                }
            });


            Button btnDesistir =  (Button) findViewById(R.id.btnDesistir);
            btnDesistir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.exit(1);
                }
            });



        }


    }
    private void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();

    }
}