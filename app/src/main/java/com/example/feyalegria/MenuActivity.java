package com.example.feyalegria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.feyalegria.databinding.ActivityMenuBinding;
import com.example.feyalegria.model.RequestAsistencia;
import com.example.feyalegria.retroit.RetrofitClient;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMenuBinding binding;
    Bundle parametros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =  ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Configuracion de Botones
        binding.btnTardInasis.setOnClickListener(this);
        binding.btnHorarios.setOnClickListener(this);
        binding.btnAsistencias.setOnClickListener(this);
        binding.btnMarcarAsis.setOnClickListener(this);
        binding.btnCerrarSesion.setOnClickListener(this);
        String usuario;
        parametros = this.getIntent().getExtras();
        if(parametros != null) {
            usuario = parametros.getString("usuario");
            binding.tvDocente.setText(usuario.toUpperCase());}

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnHorarios:irHorarios();
            break;
            case R.id.btnCerrarSesion: iraCerrarsion();
                break;
            case R.id.btnTardInasis: idatardanzas();
                break;
            case R.id.btnAsistencias: irAsistencias();
                break;
            case R.id.btnMarcarAsis: validarMarcarAsistencia(marcarAsistencia());
                break;
        }
    }

    //
    private RequestAsistencia marcarAsistencia(){
        Calendar calendario = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sdf.format(calendario.getTime());
        RequestAsistencia asistencia = new RequestAsistencia();
        asistencia.setIdasistencia(0);
        asistencia.setIddocente(parametros.getInt("iddocente"));
        asistencia.setObservacion("asistencia");
        asistencia.setFh_asistencia(strDate);
        asistencia.setEstado(1);
        asistencia.setQr("");
        asistencia.setPorcod("");

        return asistencia;
    }

    private void validarMarcarAsistencia(RequestAsistencia requestAsistencia){
            RetrofitClient.getRetrofitCliente().MarcarAsistencia(requestAsistencia).enqueue(new Callback<RequestAsistencia>() {
                @Override
                public void onResponse(Call<RequestAsistencia> call, Response<RequestAsistencia> response) {
                    if(response.isSuccessful()){
                        Toast.makeText(MenuActivity.this, "Asistencia marcada.", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(MenuActivity.this, "La solicitud al API ha fallado.", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<RequestAsistencia> call, Throwable t) {
                    Toast.makeText(MenuActivity.this, "La solicitud al API ha fallado:" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            });
    }


    //Metodos para llamar a las Actividades

    private void idatardanzas(){
        Intent intenttardan =  new Intent(this,tareinaActivity.class);
        intenttardan.putExtras(parametros);
        startActivity(intenttardan);
    }

    private void irHorarios(){
        Intent intenthorario =  new Intent(this,HorariosActivity.class);
        intenthorario.putExtras(parametros);
        startActivity(intenthorario);
    }

    private void irAsistencias(){
        Intent intentasis =  new Intent(this, AsistenActivity.class);
        intentasis.putExtras(parametros);
        startActivity(intentasis);
    }

    private void iraCerrarsion(){
        Intent intentmain =  new Intent(this, MainActivity.class);
        intentmain.putExtras(parametros);
        startActivity(intentmain);
    }



}