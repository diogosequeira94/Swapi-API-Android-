package com.example.maytheforcebewith_diogosequeira.Rest;

import com.example.maytheforcebewith_diogosequeira.Retrofit.CharacterResults;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIPlaceHolder {

    //Gets people by SearchBox input

    @GET("people")
    Call<CharacterResults> searchPeople(@Query("search") String search);



}
