package com.example.feyalegria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.feyalegria.databinding.ActivityJustificacionBinding;

public class JustificacionActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityJustificacionBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJustificacionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnMenu2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnMenu2: iraMenus();
                break;
        }

    }
    private void iraMenus(){
        Intent intentMenus = new Intent(this,MenuActivity.class);
        startActivity(intentMenus);
    }
}