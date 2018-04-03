package com.example.capacitacion7.doggbreedandroid;

import java.util.List;
import com.google.gson.annotations.SerializedName;

/**
 * Created by capacitacion7 on 16-03-18.
 */

public class BreedResponse {

    @SerializedName("ticker") private Breed breedList;

    public Breed getBreedList() {
        return breedList;
    }

    public void setBreedList(Breed breedList) {
        this.breedList = breedList;
    }
}
