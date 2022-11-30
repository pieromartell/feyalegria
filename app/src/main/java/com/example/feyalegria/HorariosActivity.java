package com.example.feyalegria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.feyalegria.databinding.ActivityHorariosBinding;
import com.example.feyalegria.databinding.ActivityMainBinding;
import com.example.feyalegria.databinding.HorariosCardBinding;

public class HorariosActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityHorariosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHorariosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnvolver.setOnClickListener(this);
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