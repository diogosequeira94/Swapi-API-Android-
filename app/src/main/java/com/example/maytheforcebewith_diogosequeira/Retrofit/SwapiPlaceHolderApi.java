package com.example.maytheforcebewith_diogosequeira.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SwapiPlaceHolderApi {

    @GET("people")
    Call<List<Character>> getPeople();
}
