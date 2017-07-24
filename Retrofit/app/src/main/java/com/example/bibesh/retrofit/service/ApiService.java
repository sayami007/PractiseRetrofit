package com.example.bibesh.retrofit.service;

import com.example.bibesh.retrofit.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Bibesh on 6/2/17.
 */

public interface ApiService {

    @GET("s/")
    Call<String> callUrl(@Query("username") String username);

}
