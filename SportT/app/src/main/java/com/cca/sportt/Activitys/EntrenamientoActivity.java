package com.cca.sportt.Activitys;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.cca.sportt.R;

public class EntrenamientoActivity extends AppCompatActivity {
    private TextView txtTiempo,txtCalorias,txtEsfuerzo,txtFrecuenciaCardiaca,txtRutina;
    private Button start,finish;

    private Chronometer cronometro;
    private Boolean correr=false;
    private long detenerse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenamiento);

        Bundle datos = this.getIntent().getExtras();

        final String entrenamiento = datos.getString("descripcion_entrenamiento");

        start = findViewById(R.id.btnStartTime);
        finish = findViewById(R.id.btnFinishTime);

        txtTiempo = findViewById(R.id.txtTiempo);
        txtCalorias = findViewById(R.id.txtCalorias);
        txtEsfuerzo = findViewById(R.id.txtEsfuerzo);
        txtFrecuenciaCardiaca = findViewById(R.id.txtFrecuenciaCardiaca);
        txtRutina = findViewById(R.id.txtPlanEntrenamiento);
        cronometro = findViewById(R.id.cronometroEntrenamiento);

        txtRutina.setText(entrenamiento);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCronometro();
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopCronometro();
            }
        });

    }

    private void stopCronometro() {
        if(correr){
           cronometro.stop();
           detenerse = SystemClock.elapsedRealtime()-cronometro.getBase();
           correr=false;
        }
    }

    private void startCronometro() {
        if(!correr){
            cronometro.setBase(SystemClock.elapsedRealtime()-detenerse);
            cronometro.start();
            correr=true;
        }
    }
}
