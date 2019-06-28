package com.cca.sportt.Activitys;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cca.sportt.Models.Avances;
import com.cca.sportt.Models.Deportes;
import com.cca.sportt.Models.GlobalUser;
import com.cca.sportt.Models.TusDeportes;
import com.cca.sportt.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class RegistroTusDeportesActivity extends AppCompatActivity {
    TextView nombreDeporteRegistro;
    ImageView imgFotoDeporte;
    RadioGroup groupButtonPlanes;
    RadioButton rbtnAmateur,rbtnProfesional,rbtnParaolimpicos,rbtnOlimpicos;
    Button registrarDeporte;

    Avances avance;
    Deportes deporte;

    TusDeportes usuario;


    Glide glide;

    private DatabaseReference tbl_tusdeportes;

    String plan="",tipo="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_tus_deportes);


        Bundle datos = this.getIntent().getExtras();

        final String nombreDeporte = datos.getString("deporte_string");
        final String urlFotoDeporte = datos.getString("foto_deporte_string");

        nombreDeporteRegistro = findViewById(R.id.txtNombreDeporteRegistro);
        imgFotoDeporte = findViewById(R.id.imgRegistroDeporte);


        nombreDeporteRegistro.setText(nombreDeporte);
        glide.with(this).load(urlFotoDeporte).into(imgFotoDeporte);

        rbtnAmateur = findViewById(R.id.rbtnAmateur);
        rbtnProfesional = findViewById(R.id.rbtnOlimpiadas);
        rbtnOlimpicos = findViewById(R.id.rbtnOlimpiadas);
        rbtnParaolimpicos = findViewById(R.id.rbtnParaolimpicos);
        registrarDeporte = findViewById(R.id.btnInscribirDeporte);





        tbl_tusdeportes = FirebaseDatabase.getInstance().getReference("TusDeportes");


        registrarDeporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tbl_tusdeportes.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        int encontrado=0;

                        if(rbtnAmateur.isChecked()){
                            plan = "amateur";
                        }
                        if(rbtnProfesional.isChecked()){
                            plan = "profesional";
                        }
                        if(rbtnParaolimpicos.isChecked()){
                            tipo = "paraolimpicos";
                        }
                        if(rbtnOlimpicos.isChecked()){
                            tipo = "olimpicos";
                        }

                        avance = new Avances("1",nombreDeporte,"0","0","0");
                        deporte = new Deportes(plan," ",urlFotoDeporte,nombreDeporte,tipo);

                        usuario = new TusDeportes(avance,GlobalUser.getId_usuario(),deporte);

                        for(DataSnapshot i : dataSnapshot.getChildren()){
                            Log.d("aca",i.getValue().toString());
                            //TusDeportes temp = i.getValue(TusDeportes.class);
                            if(i.getValue(TusDeportes.class).getId_usario().toString().equals(usuario.getId_usario().toString()) && i.getValue(TusDeportes.class).getDeporte().getNombre().toString().equals(usuario.getDeporte().getNombre().toString()) ){
                                encontrado++;
                                break;
                            }
                        }
                        if(encontrado==0){
                            tbl_tusdeportes.push().setValue(usuario);
                            Toast toast = Toast.makeText(RegistroTusDeportesActivity.this,"Se ha registrado el deporte con exito", Toast.LENGTH_LONG);
                            toast.show();
                            finish();
                        }else{
                            Toast toast = Toast.makeText(RegistroTusDeportesActivity.this,"Ya tiene este deporte en su lista, elija otro", Toast.LENGTH_LONG);
                            toast.show();
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.d("error",databaseError.getMessage());
                    }
                });



            }
        });


    }
}
