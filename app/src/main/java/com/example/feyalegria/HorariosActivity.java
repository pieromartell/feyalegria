package com.example.feyalegria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.feyalegria.api.AndroidapiService;
import com.example.feyalegria.databinding.ActivityHorariosBinding;
import com.example.feyalegria.databinding.ActivityMainBinding;
import com.example.feyalegria.databinding.HorariosCardBinding;
import com.example.feyalegria.model.HorarioRespuesta;
import com.example.feyalegria.model.Horarios;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HorariosActivity extends AppCompatActivity implements View.OnClickListener {
    private Retrofit retrofit;
private static  final String TAG="HORARIO";
    private ActivityHorariosBinding binding;

    private RecyclerView recyclerView;
    private ListaHorarioAdapter listaHorarioAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHorariosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnvolver.setOnClickListener(this);

        setContentView(R.layout.activity_horarios);
    recyclerView=(RecyclerView) findViewById(R.id.rvhorario);
    listaHorarioAdapter=new ListaHorarioAdapter();
    recyclerView.setAdapter(listaHorarioAdapter);
    recyclerView.setHasFixedSize(true);


    retrofit=new Retrofit.Builder()
            .baseUrl("http://192.168.86.1:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    obtenerDatos();
    }

    private void obtenerDatos(){
        AndroidapiService service=retrofit.create(AndroidapiService.class);
        Call <HorarioRespuesta> horarioRespuestaCall =service.obtenerListaHorarios();
        horarioRespuestaCall.enqueue(new Callback<HorarioRespuesta>() {
            @Override
            public void onResponse(Call<HorarioRespuesta> call, Response<HorarioRespuesta> response) {
                if(response.isSuccessful()){
                    HorarioRespuesta horarioRespuesta=response.body();
                    ArrayList<Horarios> listaHorarios=horarioRespuesta.getResults();
                        listaHorarioAdapter.adicionarListaHorario(listaHorarios);

                }else{
                    Log.e(TAG,"onResponse"+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<HorarioRespuesta> call, Throwable t) {
                Log.e(TAG,"onFailure"+t.getMessage());

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnvolver: iraMenu();
                break;
        }
    }
    private void iraMenu(){
        Intent intentMenu = new Intent(this,MenuActivity.class);
        startActivity(intentMenu);
    }
}