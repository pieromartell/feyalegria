package com.example.feyalegria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.feyalegria.adapter.InasistenciaAdapter;
import com.example.feyalegria.adapter.tardanzaAdapter;
import com.example.feyalegria.databinding.ActivityMainBinding;
import com.example.feyalegria.databinding.ActivityTareinaBinding;
import com.example.feyalegria.model.Inasistencia;
import com.example.feyalegria.model.Tardanza;
import com.example.feyalegria.retroit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class tareinaActivity extends AppCompatActivity implements View.OnClickListener{

    private static String TAGI ="INASISTENCIA";
    private static String TAGT ="TARDANZA";
    private ActivityTareinaBinding binding;
    InasistenciaAdapter Inasistenciaadapter;
    tardanzaAdapter tardanzaAdapter;

    LinearLayoutManager layoutManager;
    //Elementos Necesairos para la Tardanza
    RecyclerView recyclerView2;
    List<Tardanza> listaTardanza = new ArrayList<>();

    //Elementos Necesarios para la Inasistencia
    RecyclerView recyclerView;
    List<Inasistencia> listainasis = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTareinaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //Botonos
        binding.btninasistencia.setOnClickListener(this);
        binding.btntardanzas.setOnClickListener(this);
        binding.btnmenu.setOnClickListener(this);

        //Configuracion del ReclyclerView TArdanza
        recyclerView2 = binding.rvtardanzas;
        layoutManager = new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(layoutManager);
        tardanzaAdapter = new tardanzaAdapter(listaTardanza);
        recyclerView2.setAdapter(tardanzaAdapter);
        fechtTardanza();

        //Configuracion del RecyclerView INASISTENCIA
        recyclerView = binding.rvinasistencia;
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Inasistenciaadapter = new InasistenciaAdapter(listainasis);
        recyclerView.setAdapter(Inasistenciaadapter);
        FetchInasisten();
    }

    //Metodo para Enviar las Tardanzas
    private void fechtTardanza() {
        RetrofitClient.getRetrofitCliente().obtenerListaTardanza().enqueue(new Callback<List<Tardanza>>() {
            @Override
            public void onResponse(Call<List<Tardanza>> call, Response<List<Tardanza>> response) {
                if(response.isSuccessful() && response.body() !=null){
                    listaTardanza.addAll(response.body());
                    tardanzaAdapter.notifyDataSetChanged();
                    Log.e(TAGT," TDOD BIEN EN TARDANZA: "+response.body());
                }else{
                    Log.e(TAGT," OnResponse: "+response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Tardanza>> call, Throwable t) {
                Toast.makeText(tareinaActivity.this, "Error: " +t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    //Metodo Para Enviar Las Inasistencias
    private void FetchInasisten(){
        RetrofitClient.getRetrofitCliente().obtenerListaInasistencia().enqueue(new Callback<List<Inasistencia>>() {
            @Override
            public void onResponse(Call<List<Inasistencia>> call, Response<List<Inasistencia>> response) {
                if(response.isSuccessful() && response.body() !=null){
                    listainasis.addAll(response.body());
                    Inasistenciaadapter.notifyDataSetChanged();
                    Log.e(TAGI," TDOD BIEN EN INASISTENCIA: "+response.body());
                }else{
                    Log.e(TAGI,"OnResponse: "+response.body());
                }

            }

            @Override
            public void onFailure(Call<List<Inasistencia>> call, Throwable t) {
                Toast.makeText(tareinaActivity.this, "Error: " +t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btntardanzas: irjustificacontar();
                break;
            case R.id.btninasistencia: irjustificaconIna();
                break;
            case R.id.btnmenu: iraMenu();
        }
    }

    public void irjustificacontar(){
        Intent intentjustificaciontar = new Intent(this,JustifiTarActivity.class);
        intentjustificaciontar.putExtra("info","Tardanza");
        startActivity(intentjustificaciontar);

    }

    public void irjustificaconIna(){
        Intent intentjustificacionina = new Intent(this,JustificacionActivity.class);
        intentjustificacionina.putExtra("info2","Inasistencia");
        startActivity(intentjustificacionina);
    }
    private void iraMenu(){
        Intent intentMenu = new Intent(this,MenuActivity.class);
        startActivity(intentMenu);
    }
}