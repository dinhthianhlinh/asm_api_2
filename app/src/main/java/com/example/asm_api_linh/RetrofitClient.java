package com.example.asm_api_linh;

import okhttp3.OkHttpClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    // Base URL of your API
    static String BASE_URL = "http://192.168.1.12:3000/";

    private static Retrofit retrofit = null;

    public static Retrofit getRetrofitInstance() {
        // Create an OkHttpClient to log HTTP requests and responses
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        // Build the Retrofit instance
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }
}
