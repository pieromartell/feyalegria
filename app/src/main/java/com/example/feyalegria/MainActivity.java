package com.example.feyalegria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.feyalegria.databinding.ActivityMainBinding;
import com.example.feyalegria.model.Horarios;
import com.example.feyalegria.model.ResponseLogin;
import com.example.feyalegria.viewmodel.AuthViewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Callback<ArrayList<Horarios>> {

    private Retrofit retrofit;
    private AuthViewModel authViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btningresar.setOnClickListener(this);
        */
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btningresar.setOnClickListener(this);
        authViewModel = new ViewModelProvider(this)
                .get(AuthViewModel.class);
        authViewModel.loginMutableLiveData.observe(this,
                new Observer<ResponseLogin>() {
                    @Override
                    public void onChanged(ResponseLogin responseLogin) {
                        validarAutenticacion(responseLogin);
                    }
                });
    }

    private void validarAutenticacion(ResponseLogin responseLogin) {
        if(responseLogin.getIdusua() > 0){
            startActivity(new Intent(MainActivity.this,
                    MenuActivity.class));
        }else{
            Toast.makeText(this, "Usuario no encontrado.",
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onResponse(Call<ArrayList<Horarios>> call, Response<ArrayList<Horarios>> response) {
        if(response.isSuccessful()){
            ArrayList<Horarios> horarios= response.body();
            Log.d("onResponse horarios","size  of horarios=)>"+horarios.size());
        }
    }

    @Override
    public void onFailure(Call<ArrayList<Horarios>> call, Throwable t) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btningresar: iraMenu();
                break;
        }
    }

    private void iraMenu(){
        Intent intentMenu = new Intent(this,MenuActivity.class);
        startActivity(intentMenu);
    }


}