package com.cca.sportt.Activitys;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.cca.sportt.Models.GlobalUser;
import com.cca.sportt.Models.Usuario;
import com.cca.sportt.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class PrincipalActivity extends AppCompatActivity {
    private ImageView Deportes,Comunidad,TusDeportes;

    DrawerLayout drawerLayout_menu_toolbar;
    NavigationView menu_navigation;

    private DatabaseReference tbl_usuarios;

    ImageView btn_menu;
    TextView usuario;
    int clickMenu=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Deportes = findViewById(R.id.imgDeportesPrincipal);
        Comunidad = findViewById(R.id.imgComunidadPrincipal);
        TusDeportes = findViewById(R.id.imgTusdeportesPrincipal);
        menu_navigation = findViewById(R.id.menu_items);
        btn_menu = findViewById(R.id.btnInfo);
        drawerLayout_menu_toolbar = findViewById(R.id.menu_opciones);

        Bundle datos = this.getIntent().getExtras();

        final String id_usuario = datos.getString("id_usuario");

        usuario = findViewById(R.id.txtUsuarioPerfilprincipal);

        tbl_usuarios = FirebaseDatabase.getInstance().getReference("Usuarios");
        tbl_usuarios.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot i : dataSnapshot.getChildren()){
                    Usuario temp =  i.getValue(Usuario.class);
                    Log.d("nada1",i.getValue().toString());
                    //Log.d("nada2",GlobalUser.getId_usuario());
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

        Deportes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PrincipalActivity.this, DeportesActivity.class);
                intent.putExtra("id_usuario", id_usuario);
                startActivity(intent);
            }
        });

        Comunidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalActivity.this, ComunidadActivity.class);
                intent.putExtra("id_usuario", id_usuario);
                startActivity(intent);
            }
        });

        TusDeportes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalActivity.this, TusDeportesActivity.class);
                intent.putExtra("id_usuario", id_usuario);
                startActivity(intent);
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
                                                drawerLayout_menu_toolbar.setVisibility(v.INVISIBLE);
                                                usuario.setVisibility(v.GONE);
                                                break;
                                            case R.id.tus_deportes:
                                                Intent intent = new Intent(PrincipalActivity.this, TusDeportesActivity.class);
                                                intent.putExtra("id_usuario", id_usuario);
                                                startActivity(intent);
                                                drawerLayout_menu_toolbar.setVisibility(v.INVISIBLE);
                                                usuario.setVisibility(v.GONE);
                                                break;
                                            case R.id.comunidad:
                                                Intent intent2 = new Intent(PrincipalActivity.this, ComunidadActivity.class);
                                                intent2.putExtra("id_usuario", id_usuario);
                                                startActivity(intent2);
                                                drawerLayout_menu_toolbar.setVisibility(v.INVISIBLE);
                                                usuario.setVisibility(v.GONE);
                                                break;
                                            case R.id.deportes:
                                                Intent intent3 = new Intent(PrincipalActivity.this, DeportesActivity.class);
                                                intent3.putExtra("id_usuario", id_usuario);
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






    /*
        rv_main = findViewById(R.id.rv_main);
        principalList = new ArrayList<>();
        adapterPrincipal = new PrincipalAdapter(principalList,this);
        //txtNombrePrincipal = findViewById(R.id.txtNameSport);


        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(PrincipalActivity.this, 1);
        rv_main.setLayoutManager(mLayoutManager);
        rv_main.setItemAnimator(new DefaultItemAnimator());
        rv_main.addItemDecoration(new DividerItemDecoration(rv_main.getContext(), DividerItemDecoration.VERTICAL));
        rv_main.setAdapter(adapterPrincipal);

        Principal deportes = new Principal(R.drawable.deportes,"DEPORTES");
        Principal comunidad = new Principal(R.drawable.foro,"COMUNIDAD");
        Principal tusDeportes = new Principal(R.drawable.tus_deportes,"TUS DEPORTES");

        principalList.add(deportes);
        principalList.add(comunidad);
        principalList.add(tusDeportes);
    */

}
