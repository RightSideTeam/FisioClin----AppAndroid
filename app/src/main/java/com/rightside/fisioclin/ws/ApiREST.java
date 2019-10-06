package com.rightside.fisioclin.ws;

import com.rightside.fisioclin.model.Horario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiREST {

    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @GET("horarios")
    Call<List<Horario>> listHorarios();
}
