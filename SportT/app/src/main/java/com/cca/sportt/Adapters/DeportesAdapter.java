package com.cca.sportt.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cca.sportt.Activitys.SubDeportesActivity;
import com.cca.sportt.Models.Deporte;
import com.cca.sportt.R;


import java.util.List;

public class DeportesAdapter extends RecyclerView.Adapter<DeportesAdapter.MyViewHolder> {
    private List<Deporte> deportesList;
    private Context context;
    private Glide glide;
    private Deporte item;

    public DeportesAdapter(List<Deporte> deportesList, Context context) {
        this.deportesList = deportesList;
        this.context = context;
    }
    public Context getContext(){
        return this.context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview_deporte, viewGroup, false);
        return new DeportesAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder,  final int i) {
        this.item = deportesList.get(i);
        myViewHolder.nombreDeporte.setText(deportesList.get(i).getNombre());
        glide.with(context).load(deportesList.get(i).getUrlfoto()).into(myViewHolder.fotoDeporte);

        myViewHolder.fotoDeporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(), SubDeportesActivity.class);
                intent.putExtra("deporte_string",deportesList.get(i).getNombre());
                getContext().startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {

        return deportesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nombreDeporte;
        ImageView fotoDeporte;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nombreDeporte = itemView.findViewById(R.id.txtNombreDeporteRegistro);
            fotoDeporte = itemView.findViewById(R.id.fotoDeporte);

        }
    }
}

