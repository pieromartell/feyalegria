package com.example.feyalegria;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.feyalegria.model.Horarios;

import java.util.ArrayList;

public class ListaHorarioAdapter extends  RecyclerView.Adapter<ListaHorarioAdapter.ViewHolder>{
    private ArrayList<Horarios> dataset;

    public  ListaHorarioAdapter(){
        dataset=new ArrayList<>();
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Horarios h=dataset.get(position);
        holder.nommbreTw.setText(h.getNombcurso());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaHorario(ArrayList<Horarios> listaHorarios) {
        dataset.addAll(listaHorarios);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nommbreTw;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nommbreTw =itemView.findViewById(R.id.nombreTw);
        }
    }

}
