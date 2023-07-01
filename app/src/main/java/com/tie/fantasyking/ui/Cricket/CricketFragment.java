package com.tie.fantasyking.ui.Cricket;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.tie.fantasyking.ApiClient.ApiClient;
import com.tie.fantasyking.ApiClient.ApiInterface;
import com.tie.fantasyking.R;
import com.tie.fantasyking.databinding.FragmentCricketBinding;
import com.tie.fantasyking.promotion.PromotionAdapter;
import com.tie.fantasyking.promotion.Promotion_Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class CricketFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

  FragmentCricketBinding  binding;

  Cricket_Preview_Adapter preview_adapter;
  PromotionAdapter promotionAdapter;

  ApiInterface apiInterface;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentCricketBinding.inflate(inflater, container, false);

        Retrofit retrofit= ApiClient.getclient();
        apiInterface=retrofit.create(ApiInterface.class);

        getMatchDetail();



        return binding.getRoot();
    }

    private void setData(List<Promotion_Model.LightDetails> list) {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        promotionAdapter=new PromotionAdapter(getContext(),list);
        binding.rvImageSlider.setAdapter(promotionAdapter);
        binding.rvImageSlider.setLayoutManager(linearLayoutManager);


    }
    private void getPromotionDetail() {
        apiInterface.getPromotionList().enqueue(new Callback<Promotion_Model>() {
            @Override
            public void onResponse(Call<Promotion_Model> call, Response<Promotion_Model> response) {
                if (response!=null){
                  Promotion_Model  promotion_model= response.body();

                    if (promotion_model.getStatus().equals("1")){

                        setData(promotion_model.getData());

                        Toast.makeText(getContext(), promotion_model.getMessage(), Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getContext(), promotion_model.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            }

            @Override
            public void onFailure(Call<Promotion_Model> call, Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.e("fail",t.getLocalizedMessage());
            }
        });
    }



    @SuppressLint("NotifyDataSetChanged")
    private void setRecyclerView(List<MatchList_Model.HeavyDetails> list){
        binding.rvPreview.setHasFixedSize(true);
       preview_adapter =new Cricket_Preview_Adapter(getContext(),list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        binding.rvPreview.setLayoutManager(layoutManager);
        binding.rvPreview.setAdapter(preview_adapter);
        preview_adapter.notifyDataSetChanged();
    }
    private void getMatchDetail() {
        apiInterface.getMatchList().enqueue(new Callback<MatchList_Model>() {
            @Override
            public void onResponse(Call<MatchList_Model> call, Response<MatchList_Model> response) {
                if (response!=null){
                    MatchList_Model matchList_model= response.body();
                    if (matchList_model.getStatus().equals("1")){
                        //call recyclerView
                        setRecyclerView(matchList_model.getData());
                    }else {
                        Toast.makeText(getContext(), matchList_model.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                getPromotionDetail();
            }

            @Override
            public void onFailure(Call<MatchList_Model> call, Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.e("fail",t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController= Navigation.findNavController(view);

        AppBarConfiguration configuration=new AppBarConfiguration.Builder(navController.getGraph())
                .setDrawerLayout(binding.drawerLayout).build();

        NavigationUI.setupWithNavController(binding.navigationDrawer, navController);
        NavigationUI.setupWithNavController(binding.toolbar,navController,configuration);

        binding.navigationDrawer.setNavigationItemSelectedListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigation_profile:
                Toast.makeText(getContext(), "Coming Soon", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navigation_template:
                Toast.makeText(getContext(), "Coming Soon", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navigation_edit_portfolio:
                Toast.makeText(getContext(), "Coming Soon", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navigation_email_signature:
                Toast.makeText(getContext(), "Coming Soon", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }


    }
