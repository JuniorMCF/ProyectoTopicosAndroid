package com.cca.sportt.Adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cca.sportt.Models.Principal;
import com.cca.sportt.R;

import java.util.List;

public class PrincipalAdapter extends RecyclerView.Adapter<PrincipalAdapter.MyViewHolder> {
    private List<Principal> deportesList;
    private Context context;

    public PrincipalAdapter(List<Principal> deportesList, Context context) {
        this.deportesList = deportesList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview_main, viewGroup, false);
        return new PrincipalAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.txtNameSport.setText(deportesList.get(i).getNamedeporte());
        myViewHolder.fotoSport.setImageResource(deportesList.get(i).getUrlfoto());
    }

    @Override
    public int getItemCount() {
        return deportesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtNameSport;
        ImageView fotoSport;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNameSport = itemView.findViewById(R.id.txtNameSport);
            fotoSport = itemView.findViewById(R.id.imgSport);
        }
    }
}
