package com.example.maytheforcebewith_diogosequeira.Rest;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SwapiAPIClient {

    private static APIPlaceHolder REST_CLIENT;
    private static final String API_URL = "http://swapi.co/api/";
    private static final String BASE_URL = "https://swapi.co/api/people/";

    static {
        setupRestClient();
    }

    private SwapiAPIClient() {}

    public static APIPlaceHolder get()

    {
        return REST_CLIENT;
    }



    public static String getBaseUrl() {

        return BASE_URL;
    }

    private static void setupRestClient()
    {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();


        REST_CLIENT = retrofit.create(APIPlaceHolder.class);
    }

}
