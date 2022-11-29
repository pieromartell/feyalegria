package com.example.feyalegria;

//Este es la pantalla de carga
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class CargaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Aqui se infica que primero carge la Mainactivity
        Intent intent = new Intent(this,tareinaActivity.class);
        startActivity(intent);
        finish();
    }
}