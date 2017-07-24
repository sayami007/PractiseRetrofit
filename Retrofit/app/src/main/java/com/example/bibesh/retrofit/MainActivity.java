package com.example.bibesh.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.bibesh.retrofit.model.Student;
import com.example.bibesh.retrofit.service.ApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String BASE_URL = "https://10.6.1.48/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLoginDetail();
    }

    private void getLoginDetail() {
        Retrofit builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        ApiService service = builder.create(ApiService.class);
        Call<String> call = service.callUrl("bibesh");
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.v("SDF",response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.v("Fail",t.getMessage());
            }
        });
    }

}