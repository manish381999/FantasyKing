package com.tie.fantasyking.ui.SportNews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.tie.fantasyking.ApiClient.ApiInterface;
import com.tie.fantasyking.ApiClient.NewsApiClient;
import com.tie.fantasyking.databinding.ActivityCricketSeriesInfoBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CricketSeries_infoActivity extends AppCompatActivity {
ActivityCricketSeriesInfoBinding binding;
    ApiInterface apiInterface;
    CricketSeriesInfoAdapter cricketSeriesInfoAdapter;


    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCricketSeriesInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        id=getIntent().getStringExtra("id");



        Retrofit retrofit= NewsApiClient.getclient();
        apiInterface=retrofit.create(ApiInterface.class);

        getCricketSeriesInfo(id);


    }
    @SuppressLint("NotifyDataSetChanged")
    private void setRecyclerView(List<CricketSeriesInfoModel.MatchList> list) {
        binding.rvCricketSeriesInfo.setHasFixedSize(true);
        cricketSeriesInfoAdapter =new CricketSeriesInfoAdapter(this,list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.rvCricketSeriesInfo.setLayoutManager(layoutManager);
        binding.rvCricketSeriesInfo.setAdapter(cricketSeriesInfoAdapter);
        cricketSeriesInfoAdapter.notifyDataSetChanged();
    }
    private void getCricketSeriesInfo(String id) {
        apiInterface.getCricketSeriesInfo(id).enqueue(new Callback<CricketSeriesInfoModel>() {
            @Override
            public void onResponse(Call<CricketSeriesInfoModel> call, Response<CricketSeriesInfoModel> response) {
                if (response!=null){
                    CricketSeriesInfoModel cricketSeriesInfoModel= response.body();

                    Gson gson = new Gson();
                    CricketSeriesInfoModel cricketSeriesInfoModel1 = gson.fromJson(String.valueOf(response), CricketSeriesInfoModel.class);

                    if (cricketSeriesInfoModel.getApikey().equals("32969b4d-c1a2-4edf-834f-715eabf450b7")){

//                        Toast.makeText(getApplicationContext(), "Data is Coming", Toast.LENGTH_SHORT).show();


//                        Toast.makeText(getApplicationContext(), cricketSeriesInfoModel.getApikey(), Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), cricketSeriesInfoModel1.getData().getInfo().getCache(), Toast.LENGTH_LONG).show();

                        setRecyclerView(cricketSeriesInfoModel.getData().getMatchList());
//                        if (cricketSeriesInfoModel != null && cricketSeriesInfoModel.getData() != null) {
//                            List<CricketSeriesInfoModel.MatchList> matchList = cricketSeriesInfoModel.getData().getMatchList();
//                            // Perform further operations with matchList
//                            setRecyclerView(matchList);
//                        } else {
//                            // Handle the case when the Data object or CricketSeriesInfoModel is null
//                        }

                    }else {
                        Toast.makeText(getApplicationContext(), cricketSeriesInfoModel.getApikey(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CricketSeriesInfoModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.e("fail",t.getLocalizedMessage());
            }
        });
    }


}