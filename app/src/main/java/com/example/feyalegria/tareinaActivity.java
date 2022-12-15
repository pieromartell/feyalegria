package com.example.feyalegria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.nfc.Tag;
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

    //Parametro para pasar el nombre de los usuarios
    Bundle parametros;
    public int IDDoncente;

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

        //Configuracion del RecyclerView INASISTENCIA
        recyclerView = binding.rvinasistencia;
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Inasistenciaadapter = new InasistenciaAdapter(listainasis);
        recyclerView.setAdapter(Inasistenciaadapter);

        //Mandar el Nombre de Usuario a la vista
        String usuario;
        parametros = this.getIntent().getExtras();
        if(parametros != null) {
            usuario = parametros.getString("usuario");
            binding.txtdocente.setText(usuario.toUpperCase());}

        //Configuracion de Parametros
        parametros = this.getIntent().getExtras();
        if(parametros != null){
            IDDoncente = parametros.getInt("iddocente");
        }
        Tardanza(IDDoncente);
        InasistenciaMETODO(IDDoncente);

    }

    private void InasistenciaMETODO(int iddocente) {
        Call<List<Inasistencia>> call = RetrofitClient.getRetrofitCliente().obtenerListaInasistencia(iddocente);
        call.enqueue(new Callback<List<Inasistencia>>() {
            @Override
            public void onResponse(Call<List<Inasistencia>> call, Response<List<Inasistencia>> response) {
                try{
                    if(response.isSuccessful()){
                        listainasis.addAll(response.body());
                        Inasistenciaadapter.notifyDataSetChanged();
                        Log.e(TAGI, " TODO BIEN: "+ response.body());
                    }else{
                        Log.e(TAGI, " TODO MAL: "+response.body());
                    }

                }catch (Exception e){
                    Log.e(TAGI, " TODO MAL: "+ response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Inasistencia>> call, Throwable t) {
                Toast.makeText(tareinaActivity.this, "MALISIMO EN INASISTENCIA", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void Tardanza(int iddocente){
        Call<List<Tardanza>> call =  RetrofitClient.getRetrofitCliente().obtenerListaTardanza(iddocente);
        call.enqueue(new Callback<List<Tardanza>>() {
            @Override
            public void onResponse(Call<List<Tardanza>> call, Response<List<Tardanza>> response) {
                try {
                    if(response.isSuccessful()){
                        listaTardanza.addAll(response.body());
                        tardanzaAdapter.notifyDataSetChanged();
                        Log.e(TAGT, " TODO BIEN: "+ response.body());
                    }else{
                        Log.e(TAGT, " TODO MAL: "+response.body());
                    }
                }catch (Exception e){
                    Log.e(TAGT, " TODO MAL: "+ response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Tardanza>> call, Throwable t) {
                Toast.makeText(tareinaActivity.this, "MALISMO DE TARDANZA", Toast.LENGTH_SHORT).show();
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
        intentjustificaciontar.putExtras(parametros);
        startActivity(intentjustificaciontar);

    }

    public void irjustificaconIna(){
        Intent intentjustificacionina = new Intent(this,JustificacionActivity.class);
        intentjustificacionina.putExtra("info2","Inasistencia");
        intentjustificacionina.putExtras(parametros);
        startActivity(intentjustificacionina);
    }
    private void iraMenu(){
        Intent intentMenu = new Intent(this,MenuActivity.class);
        intentMenu.putExtras(parametros);
        startActivity(intentMenu);
    }
}