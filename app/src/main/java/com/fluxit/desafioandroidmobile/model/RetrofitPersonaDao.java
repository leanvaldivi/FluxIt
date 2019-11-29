package com.fluxit.desafioandroidmobile.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitPersonaDao {

    private Retrofit retrofit;
    protected Service servicePersona;

    public RetrofitPersonaDao(String baseURL) {

        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        servicePersona = retrofit.create(Service.class);

    }
}
