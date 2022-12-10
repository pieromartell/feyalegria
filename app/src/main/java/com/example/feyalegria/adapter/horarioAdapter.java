package com.example.feyalegria.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.feyalegria.databinding.HorariosCardBinding;
import com.example.feyalegria.model.Horarios;

import java.util.List;

public class horarioAdapter extends RecyclerView.Adapter<horarioAdapter.ViewHolder> {

    private List<Horarios> listahorarios;

    public horarioAdapter(List<Horarios> listahorarios) {
        this.listahorarios = listahorarios;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(HorariosCardBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.binding.txtaula.setText(listahorarios.get(position).getNomaula());
        holder.binding.txtcurso.setText(listahorarios.get(position).getNombcurso());
        holder.binding.txthoarios.setText(listahorarios.get(position).getHora_inicio() + " - " + listahorarios.get(position).getHora_fin());
    }

    @Override
    public int getItemCount() {

        return listahorarios.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        HorariosCardBinding binding;

        public ViewHolder(HorariosCardBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
