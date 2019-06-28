package com.cca.sportt.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cca.sportt.Models.Usuario;
import com.cca.sportt.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {
    EditText usuario,password, nombre,correo;
    Button btnRegistrar;

    private DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usuario = findViewById(R.id.etUserRegister);
        password = findViewById(R.id.etPasswordRegister);
        correo = findViewById(R.id.etEmailRegister);
        nombre = findViewById(R.id.etNameRegister);
        btnRegistrar = findViewById(R.id.btnRegistrarRegister);

        db = FirebaseDatabase.getInstance().getReference("Usuarios"); // conexion a la base de datos en tiempo real firebase referencia a la tabla usuarios

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!nombre.getText().toString().trim().equals("") && !usuario.getText().toString().trim().equals("") && !correo.getText().toString().trim().equals("") && !password.getText().toString().trim().equals("")) {
                    registrarUsuario();
                }else{
                    Toast toast = Toast.makeText(RegisterActivity.this,"Llene los campos correctamente", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });


    }

    private void registrarUsuario() {
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int encontrado=0;
                Usuario user = new Usuario(nombre.getText().toString(), usuario.getText().toString(), correo.getText().toString(), password.getText().toString());

                for(DataSnapshot i : dataSnapshot.getChildren()){
                    if(i.getValue(Usuario.class).getUsername().equals(user.getUsername())){
                        encontrado++;
                        break;
                    }
                }
                if(encontrado==0){
                    db.push().setValue(user);
                    Toast toast = Toast.makeText(RegisterActivity.this,"Se ha registrado con exito", Toast.LENGTH_SHORT);
                    toast.show();
                    finish();
                }else{
                    usuario.setError("el usuario ya existe");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // ...
            }
        });

    }


}
