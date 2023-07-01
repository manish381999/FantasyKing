package com.tie.fantasyking.ApiClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    private static final String baseURL = "https://tiemysql.000webhostapp.com/";

    private static Retrofit retrofit=null;

    public static Retrofit getclient(){

        if (retrofit==null){
            OkHttpClient client=new OkHttpClient.Builder().build();

            Gson gson=new GsonBuilder().setLenient().create();

            retrofit=new Retrofit.Builder().baseUrl(baseURL).client(client).addConverterFactory(GsonConverterFactory.create(gson)).build();

        }

        return retrofit;

    }
}
