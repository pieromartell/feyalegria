package com.example.feyalegria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.feyalegria.adapter.asistenciaAdapter;
import com.example.feyalegria.databinding.ActivityAsistenBinding;
import com.example.feyalegria.model.asistencia;
import com.example.feyalegria.retroit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AsistenActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityAsistenBinding binding;

    //Parametro para pasar el nombre de los usuarios
    Bundle parametros;
    public int iddocente;

    //Elemento necesario para obtener la asistencia
    private static String TAG = "ASISTENCIA";
    asistenciaAdapter asistenciaAdapter;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<asistencia> listaasistencia = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =  ActivityAsistenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //Configuracion del BOTON
        binding.btnvolver.setOnClickListener(this);
        //Configuracion del ReclyclerView Asistencia
        recyclerView = binding.rvasistencia;
        layoutManager =  new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        asistenciaAdapter =  new asistenciaAdapter(listaasistencia);
        recyclerView.setAdapter(asistenciaAdapter);

        //Mandar el Nombre de Usuario a la vista
        String usuario;
        parametros = this.getIntent().getExtras();
        if(parametros != null) {
            usuario = parametros.getString("usuario");
            binding.txtdocenteh.setText(usuario.toUpperCase());}

        //Configuracion de Parametros
        parametros = this.getIntent().getExtras();
        if(parametros != null){
            iddocente = parametros.getInt("iddocente");
        }
        Log.e(TAG, String.valueOf(iddocente));

        AsistenciasN(iddocente);

    }

    private void AsistenciasN(int iddocente) {
        Call<List<asistencia>> call = RetrofitClient.getRetrofitCliente().obtnerListarAsistencia(iddocente);
        call.enqueue(new Callback<List<asistencia>>() {
            @Override
            public void onResponse(Call<List<asistencia>> call, Response<List<asistencia>> response) {
                try {
                    if (response.isSuccessful()){
                        listaasistencia.addAll(response.body());
                        asistenciaAdapter.notifyDataSetChanged();
                        Log.e(TAG," TODO BIEN: " + response.body());

                    }else{
                        Log.e(TAG," TODO MAL: " + response.body());
                    }

                }catch (Exception e){
                    Toast.makeText(AsistenActivity.this,"Mensaje de Asistencia:"+ e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<asistencia>> call, Throwable t) {
                Toast.makeText(AsistenActivity.this,"MALISIMO:", Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnvolver: iraMenuA();
                break;
        }
    }

    private void iraMenuA(){
        Intent intentMenu = new Intent(this,MenuActivity.class);
        intentMenu.putExtras(parametros);
        startActivity(intentMenu);
    }
}