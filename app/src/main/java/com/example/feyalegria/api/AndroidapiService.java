package com.example.feyalegria.api;

import com.example.feyalegria.model.Horarios;
import com.example.feyalegria.model.Inasistencia;
import com.example.feyalegria.model.Tardanza;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AndroidapiService {

    //Interface Get para el Horario_Card
    @GET("vhorariodocente")
    Call<List<Horarios>> obtenerListaHorarios();

    //Interface GET para el tardanza_card
    @GET("vtardanza")
    Call<List<Tardanza>> obtenerListaTardanza();

    //Interface GET para el inasistencia_card
    @GET("vinasistencia")
    Call<List<Inasistencia>> obtenerListaInasistencia();

    //Interface GET para el Item_Lista


}
