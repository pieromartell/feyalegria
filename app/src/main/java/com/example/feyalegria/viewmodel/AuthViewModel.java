package com.example.feyalegria.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.feyalegria.model.RequestLogin;
import com.example.feyalegria.model.ResponseLogin;
import com.example.feyalegria.retroit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthViewModel extends AndroidViewModel {

    public MutableLiveData<ResponseLogin> loginMutableLiveData
            = new MutableLiveData<>();

    public AuthViewModel(@NonNull Application application) {
        super(application);
    }

    public void autenticarUsuario(
            RequestLogin requestLogin){
                RetrofitClient.getRetrofitCliente().login(requestLogin)
                .enqueue(new Callback<ResponseLogin>() {
                    @Override
                    public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                        loginMutableLiveData.setValue(response.body());
                    }
                    @Override
                    public void onFailure(Call<ResponseLogin> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }

}
