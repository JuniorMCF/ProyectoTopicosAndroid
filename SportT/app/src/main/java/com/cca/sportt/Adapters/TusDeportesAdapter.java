package com.cca.sportt.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cca.sportt.Activitys.TuPlanActivity;
import com.cca.sportt.Activitys.TusLogrosActivity;
import com.cca.sportt.Models.TusDeportesUser;
import com.cca.sportt.R;

import org.w3c.dom.Text;

import java.util.List;

public class TusDeportesAdapter extends RecyclerView.Adapter<TusDeportesAdapter.MyViewHolder> {
    private List<TusDeportesUser> tusdeportesList;
    private Context context;
    private Glide glide;
    private TusDeportesUser item;

    public TusDeportesAdapter(List<TusDeportesUser> tusdeportesList, Context context) {
        this.tusdeportesList = tusdeportesList;
        this.context = context;
    }
    public Context getContext(){
        return this.context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview_tus_deportes, viewGroup, false);
        return new TusDeportesAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        this.item = tusdeportesList.get(i);
        myViewHolder.NombreDeporte.setText(tusdeportesList.get(i).getNameDeporte());
        glide.with(context).load(tusdeportesList.get(i).getUrlFotoDeporte()).into(myViewHolder.FotoDeporte);

        myViewHolder.FotoDeporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(), TuPlanActivity.class);
                intent.putExtra("deporte_string",tusdeportesList.get(i).getNameDeporte());
                getContext().startActivity(intent);
            }
        });
        myViewHolder.Logro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(), TusLogrosActivity.class);
                intent.putExtra("deporte_string",tusdeportesList.get(i).getNameDeporte());
                getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.tusdeportesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView NombreDeporte;
        ImageView FotoDeporte;
        Button Logro;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            NombreDeporte = itemView.findViewById(R.id.txtNameTusDeportes);
            FotoDeporte = itemView.findViewById(R.id.imgTusDeportes);
            Logro = itemView.findViewById(R.id.btnLogros);
        }
    }
}
