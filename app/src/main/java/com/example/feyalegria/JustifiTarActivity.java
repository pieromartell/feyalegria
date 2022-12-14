package com.example.feyalegria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.feyalegria.adapter.tardanzaAdapter;
import com.example.feyalegria.api.AndroidapiService;
import com.example.feyalegria.databinding.ActivityJustifiTarBinding;
import com.example.feyalegria.model.Tardanza;
import com.example.feyalegria.retroit.RetrofitClient;
import com.example.feyalegria.retroit.RetrofitparaSpinners;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JustifiTarActivity extends AppCompatActivity implements View.OnClickListener  {

    ActivityJustifiTarBinding binding;
    Spinner spinner;
    private String TAG = "Justificar Tardanza";
    ArrayAdapter<String> adapter;
    ArrayList<String> listtardan = new ArrayList<String>();
    AndroidapiService androidapiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJustifiTarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //Configuracion de los Botones
        binding.btnMenu2.setOnClickListener(this);
        Bundle bundle = getIntent().getExtras();
        String dato = bundle.getString("info");
        binding.tvTipoFalta.setText(dato);

        //Configuracion del Spinner
        spinner = binding.spFechaFalta;
        adapter =  new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,listtardan);
        androidapiService = RetrofitparaSpinners.getConnection().create(AndroidapiService.class);
        cargaData();
    }
    //Metodo para Cargar los Datos con tardanza
    public void cargaData(){
        Call<List<Tardanza>> call = androidapiService.obtenerListaTardanza();
        call.enqueue(new Callback<List<Tardanza>>() {
            @Override
            public void onResponse(Call<List<Tardanza>> call, Response<List<Tardanza>> response) {
                if(response.isSuccessful() && response.body() !=null){
                    for (Tardanza tar: response.body()){

                        listtardan.add(tar.getFh_asistencia().substring(0,10)+" - "+tar.getFh_asistencia().substring(11,19));
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(adapter);
                    }
                    adapter.notifyDataSetChanged();
                    Log.e(TAG," TODO BIEN: " + response.body());
                }else{
                    Log.e(TAG," OnResponse: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Tardanza>> call, Throwable t) {
                Toast.makeText(JustifiTarActivity.this, "Error: ", Toast.LENGTH_SHORT).show();
            }
        });

    }




    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnMenu2: iraMenus();
                break;
        }

    }
    private void borrardatos(){
        binding.tvAsunto.setText("");
        binding.tvDescripcion.setText("");
    }

    private void iraMenus(){
        Intent intentMenus = new Intent(this,MenuActivity.class);
        startActivity(intentMenus);
    }
}