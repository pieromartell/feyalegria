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
        Bundle bundle = getIntent().getExtras();
        String dato = bundle.getString("info");
        binding.tvTipoFalta.setText(dato);
        String dato2 = bundle.getString("info2");
        binding.tvtipofalta2.setText(dato2);



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