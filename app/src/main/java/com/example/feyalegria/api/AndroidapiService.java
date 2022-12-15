package com.example.feyalegria.api;

import com.example.feyalegria.model.Horarios;
import com.example.feyalegria.model.Inasistencia;
import com.example.feyalegria.model.RequestLogin;
import com.example.feyalegria.model.ResponseLogin;
import com.example.feyalegria.model.Tardanza;
import com.example.feyalegria.model.asistencia;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AndroidapiService {

    //Interface Get para el Horario_Card
    @GET("horariodocente/{iddocente}")
    Call<List<Horarios>> obtenerListaHorarios(@Path("iddocente") int iddocente);

    //Interface GET para el tardanza_card
    @GET("tardanza/{iddocente}")
    Call<List<Tardanza>> obtenerListaTardanza(@Path("iddocente") int iddocente);

    //Interface GET para el inasistencia_card
    @GET("inasistencia/{iddocente}")
    Call<List<Inasistencia>> obtenerListaInasistencia(@Path("iddocente") int iddocente);

    //Interface GET para el Item_Lista
    //Interface GET para el Item_Lista
    @GET("asistencia/{iddocente}")
    Call<List<asistencia>> obtnerListarAsistencia(@Path("iddocente") int iddocente);

    @POST("login")
    public Call<ResponseLogin> login(@Body RequestLogin requestLogin);
}
