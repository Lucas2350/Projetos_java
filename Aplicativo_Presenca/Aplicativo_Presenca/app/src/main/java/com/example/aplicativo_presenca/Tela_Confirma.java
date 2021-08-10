package com.example.aplicativo_presenca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Tela_Confirma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__confirma);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            try {
                LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

                LocationListener locationListener = new LocationListener() {
                    public void onLocationChanged(Location location) {

                        TextView lat2 = findViewById(R.id.txtLatitude2);
                        TextView lon3 = findViewById(R.id.txtLongitude3);

                        //confirma a localização correta
                        lat2.setText("-23.536622");
                        lat2.getText();
                        lon3.setText("-46.561975");
                        lon3.getText();

                        String c = "-23.536622";
                        String d = "-46.561975";


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
            String data_n2 = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(new Date());
            String data_n3 = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(new Date());
            String hora_a2 = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
            String dia_semana2 = new SimpleDateFormat("EEEE", Locale.getDefault()).format(new Date());
            TextView data2 = (TextView) findViewById(R.id.idDatac);
            TextView data4 = (TextView) findViewById(R.id.txtdata4);
            TextView dia = (TextView) findViewById(R.id.idDia2);
            TextView min = (TextView) findViewById(R.id.txtMin);
            TextView hora2 = (TextView) findViewById(R.id.txthora2);

            data2.setText("  "+data_n2);
            dia.setText(dia_semana2);
            hora2.setText(" ás "+hora_a2);

            data4.setText(""+data_n2);


            TextView disciplina = (TextView) findViewById(R.id.idDisciplina);

            //comparando os dias para definir a disciplina do dia
            if (dia.getText().equals("segunda-feira")) {
                disciplina.setText("LINGUAGENS FORMAIS E AUTÔMATOS");
            } else if (dia.getText().equals("terça-feira")) {
                disciplina.setText("TRABALHO DE GRADUAÇÃO INTERDISCIPLINAR 1 ");
            } else if (dia.getText().equals("quarta-feira")) {
                disciplina.setText("PROGRAMAÇÃO PARA DISPOSITIVOS MÓVEIS");
            } else {
                disciplina.setText("FUNDAMENTOS DE INTELIGÊNCIA ARTIFICIAL(ead)");
            }


            Button btnback =  (Button) findViewById(R.id.btnback);
            btnback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent terceiraActivity = new Intent(Tela_Confirma.this, MainActivity.class);
                    startActivity(terceiraActivity);
                }
            });






            };



    }
        private void alert(String s){
            Toast.makeText(this,s,Toast.LENGTH_LONG).show();
        }
}