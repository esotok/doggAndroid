package com.example.capacitacion7.doggbreedandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private BreedService service;
    private Breed[] breedsArray;
    private BreedResponse breed;
    private RecyclerView recyclerViewBreeds;
    private RecyclerView.Adapter adapterBreeds;
    private RecyclerView.LayoutManager layoutManagerBreeds;
    private TextView precioBC;

    private String[] precio;

    private Button btnActualiza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRetrofit();
        searchBreeds();

        precioBC = findViewById(R.id.precioBC);
        btnActualiza = findViewById(R.id.btnActualiza);


        btnActualiza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchBreeds();
            }
        });

        setTitle("BitCoin");
    }

    public void initRetrofit(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.buda.com/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(BreedService.class);
    }

    public void searchBreeds() {

        service.findBreeds().enqueue(new Callback<BreedResponse>() {

            @Override
            public void onResponse(Call<BreedResponse> call, Response<BreedResponse> response) {

                    BreedResponse breedResponse = response.body();
                    breed = breedResponse;

                    precio = breed.getBreedList().getLast_price();
                    precioBC.setText(precio[0]);
                    System.out.println(precio[0]);

                }

            @Override
            public void onFailure(Call<BreedResponse> call, Throwable t) {

            }
        });
    }
}
