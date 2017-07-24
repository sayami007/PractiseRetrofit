package com.example.bibesh.retrofitpractise;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import static android.app.SearchManager.QUERY;

/**
 * Created by Bibesh on 6/4/17.
 */

public interface ApiInterface {
    @POST("reporting/api")
    @FormUrlEncoded
    Call<Model> getAllSupervisor(
            @Field("usr") String username,
            @Field("pwd") String password
    );
}
