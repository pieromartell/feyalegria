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

        binding.btnHorarios.setOnClickListener(this);
        binding.btnMarcarAsis.setOnClickListener(this);
        binding.btnCerrarSesion.setOnClickListener(this);
        binding.btnTardInasis.setOnClickListener(this);


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
        }
    }

    private void idatardanzas(){
        Intent intenttardan =  new Intent(this,tareinaActivity.class);
        startActivity(intenttardan);
    }

    private void irHorarios(){
        Intent intenthorario =  new Intent(this,HorariosActivity.class);
        startActivity(intenthorario);
    }

    private void iraCerrarsion(){
        Intent intentmain =  new Intent(this, MainActivity.class);
        startActivity(intentmain);
    }

}