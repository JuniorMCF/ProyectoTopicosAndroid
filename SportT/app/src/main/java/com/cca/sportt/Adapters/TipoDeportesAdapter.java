package com.cca.sportt.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cca.sportt.Models.TipoDeportes;
import com.cca.sportt.R;

import java.util.List;

public class TipoDeportesAdapter extends RecyclerView.Adapter<TipoDeportesAdapter.MyViewHolder> {

    private List<TipoDeportes> tipodeporteList;
    private Context context;
    private Glide glide;

    public TipoDeportesAdapter(List<TipoDeportes> tipodeporteList, Context applicationContext) {
        this.tipodeporteList=tipodeporteList;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview_tipo_deportes, viewGroup, false);
        return new TipoDeportesAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.nombreTipoDeporte.setText(tipodeporteList.get(i).getTipoDeporte());
        glide.with(context).load(tipodeporteList.get(i).getUrlTipoDeporte()).into(myViewHolder.fotoTipoDeporte);
    }

    @Override
    public int getItemCount() {
        return tipodeporteList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nombreTipoDeporte;
        ImageView fotoTipoDeporte;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nombreTipoDeporte = itemView.findViewById(R.id.txtNombreTipoDeporte);
            fotoTipoDeporte = itemView.findViewById(R.id.fotoTipoDeporte);
        }
    }
}
