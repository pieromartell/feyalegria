package com.example.feyalegria.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.feyalegria.databinding.AsistenciaCardBinding;
import com.example.feyalegria.model.asistencia;

import java.util.List;

public class asistenciaAdapter extends RecyclerView.Adapter<asistenciaAdapter.ViewHolder> {

    private List<asistencia> listaasistencia;

    public asistenciaAdapter(List<asistencia> listaasistencia) {
        this.listaasistencia = listaasistencia;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(AsistenciaCardBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull asistenciaAdapter.ViewHolder holder, int position) {
        holder.binding.txtfechaa.setText(listaasistencia.get(position).getFh_asistencia().substring(0,10));
        holder.binding.txthoraa.setText(listaasistencia.get(position).getFh_asistencia().substring(11,19));
    }

    @Override
    public int getItemCount() {
        return listaasistencia.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AsistenciaCardBinding binding;
        public ViewHolder(AsistenciaCardBinding  itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
