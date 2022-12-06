package com.example.feyalegria.api;

import com.example.feyalegria.model.HorarioRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AndroidapiService {

    @GET("vhorariodocente")
    Call<HorarioRespuesta> obtenerListaHorarios();
}
