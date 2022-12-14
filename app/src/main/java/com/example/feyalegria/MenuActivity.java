package com.example.feyalegria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.feyalegria.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMenuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =  ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Configuracion de Botnos
        binding.btnTardInasis.setOnClickListener(this);
        binding.btnHorarios.setOnClickListener(this);
        binding.btnAsistencias.setOnClickListener(this);
        binding.btnMarcarAsis.setOnClickListener(this);
        binding.btnCerrarSesion.setOnClickListener(this);


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
        }
    }
    //Metodos para llamar a las Actividades

    private void idatardanzas(){
        Intent intenttardan =  new Intent(this,tareinaActivity.class);
        startActivity(intenttardan);
    }

    private void irHorarios(){
        Intent intenthorario =  new Intent(this,HorariosActivity.class);
        startActivity(intenthorario);
    }

    private void irAsistencias(){
        Intent intentasis =  new Intent(this, AsistenActivity.class);
        startActivity(intentasis);
    }

    private void iraCerrarsion(){
        Intent intentmain =  new Intent(this, MainActivity.class);
        startActivity(intentmain);
    }




}