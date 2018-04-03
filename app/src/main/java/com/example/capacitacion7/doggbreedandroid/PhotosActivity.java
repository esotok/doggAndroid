package com.example.capacitacion7.doggbreedandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Picasso;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhotosActivity extends AppCompatActivity {

    private BreedService service;
    private String[] photoArray;

    private Button buttonSearch;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        buttonSearch = findViewById(R.id.buttonSearch);
        progressBar = findViewById(R.id.progressBar);

        initRetrofit();
        searchPhoto(getIntent().getStringExtra("name"));

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressBar.setVisibility(View.VISIBLE);
                searchPhoto(getIntent().getStringExtra("name"));

            }
        });

        setTitle(getIntent().getStringExtra("name"));
    }

    public void initRetrofit(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dog.ceo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(BreedService.class);
    }

    public void searchPhoto(String term) {


        service.findPhotos(term).enqueue(new Callback<BreedResponse>() {

            @Override
            public void onResponse(Call<BreedResponse> call, Response<BreedResponse> response) {

                BreedResponse breedResponse = response.body();

                //photoArray = breedResponse.getBreedList();

                int indexRandom = getRandomIndex(0, photoArray.length - 1);

                ImageView imageViewDogg = findViewById(R.id.imageViewDogg);
                Picasso.get().load(photoArray[indexRandom]).into(imageViewDogg, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
            }

            @Override
            public void onFailure(Call<BreedResponse> call, Throwable t) {

            }
        });
    }

    public int getRandomIndex(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
