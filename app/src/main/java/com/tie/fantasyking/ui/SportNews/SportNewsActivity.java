package com.tie.fantasyking.ui.SportNews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.tie.fantasyking.ApiClient.ApiInterface;
import com.tie.fantasyking.ApiClient.NewsApiClient;
import com.tie.fantasyking.databinding.ActivitySportNewsBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SportNewsActivity extends AppCompatActivity {
ActivitySportNewsBinding binding;

    ApiInterface apiInterface;

    CricketSeriesAdapter cricketSeriesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySportNewsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        Retrofit retrofit= NewsApiClient.getclient();
        apiInterface=retrofit.create(ApiInterface.class);

        getCricketSeries();

    }

    @SuppressLint("NotifyDataSetChanged")
    private void setRecyclerView(List<CricketSeriesModel.LightDetails> list) {
        binding.rvCricketSeries.setHasFixedSize(true);
        cricketSeriesAdapter =new CricketSeriesAdapter(this,list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.rvCricketSeries.setLayoutManager(layoutManager);
        binding.rvCricketSeries.setAdapter(cricketSeriesAdapter);
        cricketSeriesAdapter.notifyDataSetChanged();
    }

    private void getCricketSeries() {
        apiInterface.getCricketSeries().enqueue(new Callback<CricketSeriesModel>() {
            @Override
            public void onResponse(Call<CricketSeriesModel> call, Response<CricketSeriesModel> response) {
                if (response!=null){
                    CricketSeriesModel cricketSeriesModel=response.body();
                    if (cricketSeriesModel.getApikey().equals("32969b4d-c1a2-4edf-834f-715eabf450b7")){

                        setRecyclerView(cricketSeriesModel.getData());
                    }else {
                        Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CricketSeriesModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.e("fail",t.getLocalizedMessage());
            }
        });
    }




}