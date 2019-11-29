package com.fluxit.desafioandroidmobile.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    @GET("?results=20")
    Call<ContenedorPersona> PedidoListaDePersonas();
}

