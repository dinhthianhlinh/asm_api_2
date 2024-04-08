package com.example.asm_api_linh;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddDataActivity extends AppCompatActivity {

    private EditText nameEditText, categoryEditText, productionYearEditText, descriptionEditText, priceEditText, imageURLEditText;
    private APIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_data);

        nameEditText = findViewById(R.id.name);
        categoryEditText = findViewById(R.id.hang);
        productionYearEditText = findViewById(R.id.namsx);
        descriptionEditText = findViewById(R.id.description);
        priceEditText = findViewById(R.id.gia);

        apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);

        // Call addProduct method to add a new product
        addProduct();
    }

    private void addProduct() {
        // Get data from EditText fields
        String name = nameEditText.getText().toString();
        String category = categoryEditText.getText().toString();
        int productionYear;
        try {
            productionYear = Integer.parseInt(productionYearEditText.getText().toString());
        } catch (NumberFormatException e) {
            // Handle case when productionYear is not an integer
            productionYear = 0; // or any default value that fits your logic
        }
        String description = descriptionEditText.getText().toString();
        double price;
        String priceString = priceEditText.getText().toString();
        if (!priceString.isEmpty()) {
            try {
                price = Double.parseDouble(priceString);
            } catch (NumberFormatException e) {
                // Handle case when price is not a double
                price = 0.0; // or any default value that fits your logic
            }
        } else {
            // Handle case when priceString is empty
            price = 0.0; // or any default value that fits your logic
        }
        String imageURL = imageURLEditText.getText().toString();

        // Create a new product object
        PldtModel newProduct = new PldtModel(name, category, productionYear, description, price, imageURL);

        // Send POST request to API to add the product
        Call<Void> call = apiService.addData(newProduct);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // Product added successfully
                    Toast.makeText(AddDataActivity.this, "Product added successfully", Toast.LENGTH_SHORT).show();
                } else {
                    // Error occurred while adding the product
                    String errorMessage = "Error adding product";
                    if (response.errorBody() != null) {
                        try {
                            errorMessage = response.errorBody().string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    Toast.makeText(AddDataActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Handle connection error or server error
                Toast.makeText(AddDataActivity.this, "Connection error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
