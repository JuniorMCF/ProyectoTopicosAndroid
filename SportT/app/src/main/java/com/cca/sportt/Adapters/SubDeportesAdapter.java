package com.cca.sportt.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cca.sportt.Activitys.RegistroTusDeportesActivity;
import com.cca.sportt.Models.SubDeportes;
import com.cca.sportt.R;

import java.util.List;

public class SubDeportesAdapter extends RecyclerView.Adapter <SubDeportesAdapter.MyViewHolder>{
    private List<SubDeportes> subdeportesList;
    private Context context;
    private Glide glide;
    private SubDeportes item;

    public SubDeportesAdapter(List<SubDeportes> subdeportesList, Context context) {
        this.subdeportesList = subdeportesList;
        this.context = context;
    }
    public Context getContext(){
        return this.context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview_subdeportes, viewGroup, false);

        return new SubDeportesAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        this.item = subdeportesList.get(i);
        myViewHolder.nombreTipoDeporte.setText(subdeportesList.get(i).getTipoDeporte());
        glide.with(context).load(subdeportesList.get(i).getUrlTipoDeporte()).into(myViewHolder.fotoTipoDeporte);

        myViewHolder.fotoTipoDeporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(), RegistroTusDeportesActivity.class);
                intent.putExtra("deporte_string",subdeportesList.get(i).getTipoDeporte());
                intent.putExtra("foto_deporte_string",subdeportesList.get(i).getUrlTipoDeporte());
                getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return  subdeportesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nombreTipoDeporte;
        ImageView fotoTipoDeporte;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTipoDeporte = itemView.findViewById(R.id.txtNombreSubDeporte);
            fotoTipoDeporte = itemView.findViewById(R.id.fotoSubDeporte);
        }
    }

}
