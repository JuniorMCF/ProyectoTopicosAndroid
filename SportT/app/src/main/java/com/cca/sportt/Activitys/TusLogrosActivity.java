package com.cca.sportt.Activitys;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cca.sportt.Models.GlobalUser;
import com.cca.sportt.Models.Usuario;
import com.cca.sportt.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TusLogrosActivity extends AppCompatActivity {





    DrawerLayout drawerLayout_menu_toolbar;
    private DatabaseReference tbl_usuarios;


    NavigationView menu_navigation;
    ImageView btn_menu;
    TextView usuario;
    int clickMenu=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tus_logros);





        btn_menu = findViewById(R.id.btnInfo);
        drawerLayout_menu_toolbar = findViewById(R.id.menu_opciones);
        menu_navigation = findViewById(R.id.menu_items);

        usuario = findViewById(R.id.txtUsuarioPerfiltuslogros);

        tbl_usuarios = FirebaseDatabase.getInstance().getReference("Usuarios");
        tbl_usuarios.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot i : dataSnapshot.getChildren()){
                    Usuario temp =  i.getValue(Usuario.class);
                    Log.d("nada1",i.getKey().toString());
                    Log.d("nada2", GlobalUser.getId_usuario());
                    if(i.getKey().toString().equals(GlobalUser.getId_usuario())){
                        Log.d("nada",temp.getNombre());
                        usuario.setText(temp.getNombre().toString());
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // ...
            }
        });





        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                switch (clickMenu){

                    case 0  :
                        drawerLayout_menu_toolbar.setVisibility(v.VISIBLE);
                        usuario.setVisibility(v.VISIBLE);
                        menu_navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                            @Override
                            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                                switch (menuItem.getItemId()) {
                                    case R.id.contactos:

                                        break;
                                    case R.id.deportista:

                                        break;
                                    case R.id.publicaciones:

                                        break;
                                    case R.id.inicio:
                                        startActivity(new Intent(getBaseContext(), PrincipalActivity.class)
                                                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP));
                                        break;
                                    case R.id.tus_deportes:
                                        Intent intent = new Intent(TusLogrosActivity.this, TusDeportesActivity.class);
                                        intent.putExtra("id_usuario", GlobalUser.getId_usuario());
                                        startActivity(intent);
                                        drawerLayout_menu_toolbar.setVisibility(v.INVISIBLE);
                                        usuario.setVisibility(v.GONE);
                                        break;
                                    case R.id.comunidad:
                                        Intent intent2 = new Intent(TusLogrosActivity.this, ComunidadActivity.class);
                                        intent2.putExtra("id_usuario", GlobalUser.getId_usuario());
                                        startActivity(intent2);
                                        drawerLayout_menu_toolbar.setVisibility(v.INVISIBLE);
                                        usuario.setVisibility(v.GONE);
                                        break;
                                    case R.id.deportes:
                                        Intent intent3 = new Intent(TusLogrosActivity.this, DeportesActivity.class);
                                        intent3.putExtra("id_usuario", GlobalUser.getId_usuario());
                                        startActivity(intent3);
                                        drawerLayout_menu_toolbar.setVisibility(v.INVISIBLE);
                                        usuario.setVisibility(v.GONE);
                                        break;
                                    case R.id.cerrar_sesion:
                                        Intent intent4 = new Intent(getApplicationContext(), LoginActivity.class);
                                        intent4.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        intent4.putExtra("EXIT", true);
                                        startActivity(intent4);
                                        drawerLayout_menu_toolbar.setVisibility(v.INVISIBLE);
                                        usuario.setVisibility(v.GONE);
                                        break;
                                }
                                drawerLayout_menu_toolbar.closeDrawers();

                                return true;
                            }
                        });
                        clickMenu = 1;
                        break;
                    case 1  :
                        drawerLayout_menu_toolbar.setVisibility(v.INVISIBLE);
                        usuario.setVisibility(v.GONE);
                        clickMenu = 0 ;
                        break;
                }

            }
        });
    }
}
