package com.cca.sportt.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.cca.sportt.Adapters.SubDeportesAdapter;
import com.cca.sportt.Models.SubDeportes;
import com.cca.sportt.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SubDeportesActivity extends AppCompatActivity {
    private RecyclerView rv_subdeportes;
    private List<SubDeportes> subdeportesList;
    private SubDeportesAdapter adapterSubDeportes;
    private DatabaseReference tbl_subdeportes ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_deportes);

        rv_subdeportes = findViewById(R.id.rv_subdeportes);
        subdeportesList = new ArrayList<>();
        adapterSubDeportes = new SubDeportesAdapter(subdeportesList,this);

        Bundle datos = this.getIntent().getExtras();

        final String nombreDeporte = datos.getString("deporte_string");

        //Log.d("aca",nombreDeporte);




        tbl_subdeportes = FirebaseDatabase.getInstance().getReference("TipoDeportes").child(nombreDeporte);
        tbl_subdeportes.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot i : dataSnapshot.getChildren()) {

                    SubDeportes deporteTemp = i.getValue(SubDeportes.class);
                    //Log.d("aca",deporteTemp.getUrlTipoDeporte());
                    subdeportesList.add(deporteTemp);


                }

                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(SubDeportesActivity.this, 1);
                rv_subdeportes.setLayoutManager(mLayoutManager);
                rv_subdeportes.setItemAnimator(new DefaultItemAnimator());
                rv_subdeportes.addItemDecoration(new DividerItemDecoration(rv_subdeportes.getContext(), DividerItemDecoration.VERTICAL));
                rv_subdeportes.setAdapter(adapterSubDeportes);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // ...
            }
        });


    }
}
