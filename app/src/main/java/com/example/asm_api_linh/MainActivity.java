package com.example.asm_api_linh;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView lvMain;
    List<PldtModel> listpldtModel;
    PldtAdapter qldtAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fabAdd = findViewById(R.id.add);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddDataActivity.class);
                startActivity(intent);
            }

        });


        // Set system bar insets to adjust layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lvMain = findViewById(R.id.listviewMain);

        // Create Retrofit instance
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create API service instance
        APIService apiService = retrofit.create(APIService.class);

        Call<List<PldtModel>> call = apiService.getCars();

        call.enqueue(new Callback<List<PldtModel>>() {
            @Override
            public void onResponse(Call<List<PldtModel>> call, Response<List<PldtModel>> response) {
                if (response.isSuccessful()) {
                    listpldtModel = response.body();

                    qldtAdapter = new PldtAdapter(getApplicationContext(), listpldtModel, apiService);

                    lvMain.setAdapter(qldtAdapter);


                }
            }

            @Override
            public void onFailure(Call<List<PldtModel>> call, Throwable t) {
                Log.e("Main", t.getMessage());
            }
        });



    }
}