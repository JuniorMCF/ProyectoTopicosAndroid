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

import com.bumptech.glide.Glide;
import com.cca.sportt.Activitys.EntrenamientoActivity;
import com.cca.sportt.Activitys.SubDeportesActivity;
import com.cca.sportt.Models.Niveles;
import com.cca.sportt.R;

import java.util.List;

public class NivelesAdapter extends RecyclerView.Adapter<NivelesAdapter.MyViewHolder> {
    private List<Niveles> nivelesList;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    private Context context;
    private Glide glide;
    private Niveles item;

    public NivelesAdapter(List<Niveles> nivelesList, Context context) {
        this.nivelesList = nivelesList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview_tuplan, viewGroup, false);
        return new NivelesAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        this.item = nivelesList.get(i);
        myViewHolder.btnNivel.setText("Nivel: "+item.getNivel());
        glide.with(context).load(nivelesList.get(i).getNombre()).into(myViewHolder.imgNivel);

        myViewHolder.btnNivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(), EntrenamientoActivity.class);
                intent.putExtra("descripcion_entrenamiento",nivelesList.get(i).getDescripcion());
                getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nivelesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        Button btnNivel;
        ImageView imgNivel;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            btnNivel = itemView.findViewById(R.id.btnNivel);
            imgNivel = itemView.findViewById(R.id.imgNivel);
        }
    }
}
