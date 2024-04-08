package com.example.asm_api_linh;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {
    String DOMAIN = "http://192.168.1.12:3000/";
    @GET("/api/list")
    Call<List<PldtModel>> getCars();

    @POST("/api/add_dt")
    Call<Void> addData(@Body PldtModel newData);
}
