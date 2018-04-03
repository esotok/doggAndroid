package com.example.capacitacion7.doggbreedandroid;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by capacitacion7 on 16-03-18.
 */

public interface BreedService {

    @GET("markets/btc-clp/ticker.json")
    Call<BreedResponse> findBreeds();

    @GET("api/breed/{name}/images")
    Call<BreedResponse> findPhotos(@Path("name") String term);
}
