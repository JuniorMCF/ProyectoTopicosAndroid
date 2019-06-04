package com.cca.sportt;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cca.sportt.Adapters.PrincipalAdapter;
import com.cca.sportt.Models.Principal;
import com.cca.sportt.Models.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PrincipalActivity extends AppCompatActivity {
    private PrincipalAdapter adapterPrincipal;
    private RecyclerView rv_main;
    private DatabaseReference dbRef;
    private List<Principal> principalList;

    private TextView txtNombrePrincipal;
    private ImageView imgSport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Intent intent = getIntent();

        dbRef = FirebaseDatabase.getInstance().getReference("Deportes");

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
    }
}
