package com.example.maytheforcebewith_diogosequeira.rest;

import com.example.maytheforcebewith_diogosequeira.Retrofit.CharacterResults;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIPlug {

    @GET("people")
    Call<CharacterResults> searchPeople(@Query("search") String search);

    @GET("people/{id}")
    Call<List<CharacterResults>> getComments(@Path("id") String name);







}
