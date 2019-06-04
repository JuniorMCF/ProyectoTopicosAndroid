package com.cca.sportt;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cca.sportt.Models.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private EditText username,password;
    private Button btnLogin,btnRegister;

    private DatabaseReference db = FirebaseDatabase.getInstance().getReference(); // conexion a la base de datos en tiempo real firebase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        username = findViewById(R.id.etUserLogin);
        password = findViewById(R.id.etPasswordLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().trim().equals("")){
                    username.setError("vacio");
                    if(password.getText().toString().trim().equals("")){
                        password.setError("vacio");
                    }else{
                        username.isCursorVisible();
                    }
                }else{
                    if(password.getText().toString().trim().equals("")){
                        password.setError("vacio");
                    }
                }

                if(!username.getText().toString().trim().equals("") && !password.getText().toString().trim().equals("")) {
                       verificarLogin();
                }else{
                    Toast toast = Toast.makeText(LoginActivity.this,"llene todos los campos", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });



        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }



    private void verificarLogin(){

        DatabaseReference users = FirebaseDatabase.getInstance().getReference("Usuarios");

        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int count=0;
                for(DataSnapshot i : dataSnapshot.getChildren()){
                    Usuario usuarioTemp = i.getValue(Usuario.class);
                    if(usuarioTemp.getUsername().toString().equals(username.getText().toString())){
                        count++;
                        if(usuarioTemp.getPassword().toString().equals(password.getText().toString())) {
                            Intent intent = new Intent(LoginActivity.this, PrincipalActivity.class);
                            startActivity(intent);

                            break;
                        }else{
                            password.setError("contraseña incorrecta");
                            password.moveCursorToVisibleOffset();
                        }
                    }
                }
                if(count ==0){
                    username.setError("usuario incorrecto");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
