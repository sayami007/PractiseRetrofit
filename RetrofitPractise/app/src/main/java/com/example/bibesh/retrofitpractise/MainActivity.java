package com.example.bibesh.retrofitpractise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private String BASE_URL = "http://10.6.1.48/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retroFit();
    }

    public void retroFit() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface api = retrofit.create(ApiInterface.class);
        Call<Model> call = api.getAllSupervisor("b_base", "bi");
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                Log.v("Values", "" + response.body());
                Log.v("Values", "" + response.code());
                Log.v("Values", "" + response.errorBody());
                Log.v("Values", "" + response.message());
                if (response.code() == 200) {
                    Model value = response.body();
                    Log.v("ANSER", "" + value.getSupervisorId());
//                    List<Vdc> vdc = value.getVdc();
//                    for (int i = 0; i < vdc.size(); i++) {
//                        Vdc vdcs = vdc.get(i);
//                        Log.v("VDC",vdcs.getVdcName());
//                    }
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.v("SDF", t.getMessage());
            }
        });

    }
}