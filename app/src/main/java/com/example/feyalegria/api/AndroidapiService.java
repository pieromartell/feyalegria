package com.example.feyalegria.api;

import com.example.feyalegria.model.Horarios;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AndroidapiService {

    @GET("vhorariodocente")
    Call<List<Horarios>> obtenerListaHorarios();
}
