package com.cca.sportt.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cca.sportt.Models.Comunidad;
import com.cca.sportt.R;

import java.util.List;

public class ComunidadAdapter extends RecyclerView.Adapter<ComunidadAdapter.MyViewHolder> {
    private List<Comunidad> comunidadList;
    private Context context;

    public ComunidadAdapter(List<Comunidad>comunidadList,Context context){
        this.comunidadList = comunidadList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview_comunidad, viewGroup, false);
        return new ComunidadAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.txtTema.setText(comunidadList.get(i).getTema());

        myViewHolder.txtTema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getContext(),"En proceso de desarrollo", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return comunidadList.size();
    }

    public Context getContext() {
        return context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtTema;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTema= itemView.findViewById(R.id.txtTema);
        }
    }
}
