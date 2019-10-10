package com.rightside.fisioclin.ws;

import com.rightside.fisioclin.model.Consulta;
import com.rightside.fisioclin.model.Horario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiREST {

    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @GET("horarios")
    Call<List<Horario>> listHorarios();

    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @POST("consultas")
    Call<Consulta> consulta(@Body Consulta consulta);
}
