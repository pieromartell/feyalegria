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
import com.example.feyalegria.model.RequestLogin;
import com.example.feyalegria.model.ResponseLogin;
import com.example.feyalegria.viewmodel.AuthViewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Retrofit retrofit;
    private AuthViewModel authViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        if(responseLogin != null){
            iraMenu(responseLogin);
            Toast.makeText(this, "Bienvenido: "+responseLogin.getUsuario().toString().toUpperCase(),
                    Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Usuario no encontrado.",
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View view) {
        autenticarUsuario();
    }

    public void autenticarUsuario(){
        RequestLogin requestLogin = new RequestLogin();
        requestLogin.setUsuario(binding.txtcodigo.getText().toString());
        requestLogin.setContrasena(binding.txtcontrasena.getText().toString());
        authViewModel.autenticarUsuario(requestLogin);
    }

    private void iraMenu(ResponseLogin responseLogin){
        Intent intentMenu = new Intent(this,MenuActivity.class);
        intentMenu.putExtra("idusua", responseLogin.getIdusua());
        intentMenu.putExtra("iddocente", responseLogin.getIddocente());
        intentMenu.putExtra("usuario", responseLogin.getUsuario());
        intentMenu.putExtra("contrasena", responseLogin.getContrasena());
        intentMenu.putExtra("estado", responseLogin.getEstado());
        startActivity(intentMenu);
    }


}