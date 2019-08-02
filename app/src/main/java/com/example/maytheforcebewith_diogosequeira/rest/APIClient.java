package com.example.maytheforcebewith_diogosequeira.rest;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static APIPlug REST_CLIENT;
    private static final String API_URL = "http://swapi.co/api/";

    static {
        setupRestClient();
    }

    private APIClient() {}

    public static APIPlug get()
    {
        return REST_CLIENT;
    }



    private static void setupRestClient()
    {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        //Uncomment these lines below to start logging each request.

        /*
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);
        */

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();


        REST_CLIENT = retrofit.create(APIPlug.class);
    }

}
