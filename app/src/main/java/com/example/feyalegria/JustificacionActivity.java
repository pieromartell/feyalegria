package com.example.feyalegria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.feyalegria.api.AndroidapiService;
import com.example.feyalegria.databinding.ActivityJustificacionBinding;
import com.example.feyalegria.model.Inasistencia;
import com.example.feyalegria.retroit.RetrofitparaSpinners;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JustificacionActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityJustificacionBinding binding;
    private Spinner spinner;
    private String TAG = "Justificar Inasistencia";
    ArrayAdapter<String> adapter;
    ArrayList<String> listtardan =  new ArrayList<>();
    AndroidapiService androidapiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJustificacionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnMenu2.setOnClickListener(this);
        binding.btnEnviar.setOnClickListener(this);
        Bundle bundle = getIntent().getExtras();
        String dato2 = bundle.getString("info2");
        binding.tvtipofalta2.setText(dato2);
        //Configuracion del Spinner
        spinner = binding.spFechaFalta;
        adapter =  new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,listtardan);
        androidapiService = RetrofitparaSpinners.getConnection().create(AndroidapiService.class);
        //cargardatosINA();



    }

    /*
    private void cargardatosINA() {
        Call<List<Inasistencia>> call =  androidapiService.obtenerListaInasistencia();
        call.enqueue(new Callback<List<Inasistencia>>() {
            @Override
            public void onResponse(Call<List<Inasistencia>> call, Response<List<Inasistencia>> response) {
                if(response.isSuccessful() && response.body()!=null){
                    for(Inasistencia ina : response.body()){
                        listtardan.add(ina.fh_asistencia.substring(0,10)+" - "+ina.fh_asistencia.substring(11,19));
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(adapter);
                    }
                    adapter.notifyDataSetChanged();
                    Log.e(TAG,"  TODO BIEN "+ response.body());
                }else{
                    Log.e(TAG, " OnResponse "+response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Inasistencia>> call, Throwable t) {
                Toast.makeText(JustificacionActivity.this, "Error: ",Toast.LENGTH_LONG).show();
            }
        });
    }

     */

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnMenu2: iraMenus();
                break;
            case R.id.btnEnviar: Enviar();
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
    private void Enviar(){
        borrardatos();
        Toast.makeText(JustificacionActivity.this,"Justificacion Enviada", Toast.LENGTH_SHORT).show();
    }
}