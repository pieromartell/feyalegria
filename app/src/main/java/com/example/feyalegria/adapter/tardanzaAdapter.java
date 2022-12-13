package com.example.feyalegria.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.feyalegria.JustificacionActivity;
import com.example.feyalegria.databinding.TardanzaCardBinding;
import com.example.feyalegria.model.Tardanza;

import java.util.List;

public class tardanzaAdapter extends RecyclerView.Adapter<tardanzaAdapter.ViewHolder> {
    private List<Tardanza> listaTardanza;

    public tardanzaAdapter(List<Tardanza> listaTardanza) {
        this.listaTardanza = listaTardanza;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(TardanzaCardBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,false
        ));

    }

    @Override
    public void onBindViewHolder(@NonNull tardanzaAdapter.ViewHolder holder, int position) {
        holder.binding.txtfecha.setText(listaTardanza.get(position).getFh_asistencia().substring(0,10));
        holder.binding.txtfecha2.setText(listaTardanza.get(position).getFh_asistencia().substring(11,19));
        /*
       Intent intent = new Intent(holder.itemView.getContext(), JustificacionActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT,listaTardanza.get(position).getHora_inicio() +" - "+ listaTardanza.get(position).getHora_fin());
        holder.itemView.getContext().startActivity(intent);
         */
    }

    @Override
    public int getItemCount() {
        return listaTardanza.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TardanzaCardBinding binding;

        public ViewHolder(TardanzaCardBinding  itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
