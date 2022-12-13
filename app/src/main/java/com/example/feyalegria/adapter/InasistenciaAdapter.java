package com.example.feyalegria.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.feyalegria.databinding.InasisteciaCardBinding;

import com.example.feyalegria.model.Inasistencia;

import java.util.List;

public class InasistenciaAdapter extends RecyclerView.Adapter<InasistenciaAdapter.ViewHolder> {
    private List<Inasistencia> listainasis;
    public InasistenciaAdapter(List<Inasistencia> listainasis){this.listainasis = listainasis;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(InasisteciaCardBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull InasistenciaAdapter.ViewHolder holder, int position) {
            holder.binding.txtfechai.setText(listainasis.get(position).getFh_asistencia().substring(0,10));
    }

    @Override
    public int getItemCount() {
        return listainasis.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        InasisteciaCardBinding binding;

        public ViewHolder(InasisteciaCardBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
