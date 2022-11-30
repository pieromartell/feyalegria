package com.example.feyalegria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.feyalegria.databinding.ActivityMainBinding;
import com.example.feyalegria.databinding.ActivityTareinaBinding;

public class tareinaActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityTareinaBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTareinaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btninasistencia.setOnClickListener(this);
        binding.btntardanzas.setOnClickListener(this);
        binding.btnmenu.setOnClickListener(this);
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
        Intent intentjustificaciontar = new Intent(this,JustificacionActivity.class);
        startActivity(intentjustificaciontar);
    }

    public void irjustificaconIna(){
        Intent intentjustificacionina = new Intent(this,JustificacionActivity.class);
        startActivity(intentjustificacionina);
    }
    private void iraMenu(){
        Intent intentMenu = new Intent(this,MenuActivity.class);
        startActivity(intentMenu);
    }
}