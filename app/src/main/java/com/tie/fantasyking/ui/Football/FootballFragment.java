package com.tie.fantasyking.ui.Football;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.navigation.NavigationView;
import com.tie.fantasyking.ApiClient.ApiClient;
import com.tie.fantasyking.ApiClient.ApiInterface;
import com.tie.fantasyking.R;
import com.tie.fantasyking.ui.SportNews.SportNewsActivity;
import com.tie.fantasyking.databinding.FragmentFootballBinding;
import com.tie.fantasyking.ui.promotion.Promotion_Model;
import com.tie.fantasyking.ui.promotion.SliderAdapter;
import com.tie.fantasyking.ui.Cricket.MatchList_Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FootballFragment extends Fragment  implements NavigationView.OnNavigationItemSelectedListener{
FragmentFootballBinding binding;

    Football_Preview_Adapter football_preview_adapter;
    private InterstitialAd mInterstitialAd;

    private Handler sliderHandler =new Handler();

    ApiInterface apiInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentFootballBinding.inflate(inflater, container, false);



        Retrofit retrofit= ApiClient.getclient();
        apiInterface=retrofit.create(ApiInterface.class);

        getMatchDetail();

        loadInt();
        return binding.getRoot();
    }

    private void setData(List<Promotion_Model.LightDetails> list) {
        binding.viewPagerImageSlider.setAdapter(new SliderAdapter(getContext(),list,binding.viewPagerImageSlider));

        binding.viewPagerImageSlider.setClipToPadding(false);
        binding.viewPagerImageSlider.setClipChildren(false);
        binding.viewPagerImageSlider.setOffscreenPageLimit(3);
        binding.viewPagerImageSlider.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r= 1- Math.abs(position);
                page.setScaleY(0.85f + r*0.15f);
            }
        });
        binding.viewPagerImageSlider.setPageTransformer(compositePageTransformer);

        binding.viewPagerImageSlider.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable,3000); //slide duration 3 second
            }
        });




    }

    private Runnable sliderRunnable=new Runnable() {
        @Override
        public void run() {
            binding.viewPagerImageSlider.setCurrentItem(binding.viewPagerImageSlider.getCurrentItem()+1);
        }
    };

    @Override
    public void onPause() {
        super.onPause();
        binding.shimmerViewContainer.startShimmer();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.shimmerViewContainer.startShimmer();
        sliderHandler.postDelayed(sliderRunnable,3000);
    }




    @SuppressLint("NotifyDataSetChanged")
    private void setRecyclerView(List<MatchList_Model.HeavyDetails> list){
        binding.rvPreview.setHasFixedSize(true);
        football_preview_adapter =new Football_Preview_Adapter(getContext(),list,this);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        binding.rvPreview.setLayoutManager(layoutManager);
        binding.rvPreview.setAdapter(football_preview_adapter);
        football_preview_adapter.notifyDataSetChanged();
    }





    private void getMatchDetail() {
        apiInterface.getFootballMatchList().enqueue(new Callback<MatchList_Model>() {
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
                    binding.shimmerViewContainer.stopShimmer();
                    binding.shimmerLayout.setVisibility(View.GONE);
                }
                getPromotionDetail();
            }

            @Override
            public void onFailure(Call<MatchList_Model> call, Throwable t) {
                binding.shimmerViewContainer.stopShimmer();
                binding.shimmerLayout.setVisibility(View.GONE);
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getPromotionDetail() {
        apiInterface.getPromotionList().enqueue(new Callback<Promotion_Model>() {
            @Override
            public void onResponse(Call<Promotion_Model> call, Response<Promotion_Model> response) {
                if (response!=null){
                    Promotion_Model  promotion_model= response.body();

                    if (promotion_model.getStatus().equals("1")){

                        setData(promotion_model.getData());

//                        Toast.makeText(getContext(), promotion_model.getMessage(), Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getContext(), promotion_model.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            }

            @Override
            public void onFailure(Call<Promotion_Model> call, Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
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
            case R.id.navigation_sportNews:
                startActivity(new Intent(getActivity(),  SportNewsActivity.class));
                break;

            case R.id.navigation_liveScore:
                Toast.makeText(getContext(), "Coming Soon", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navigation_liveStreaming:
                Toast.makeText(getContext(), "Coming Soon", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }

    private void loadInt() {
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(requireActivity(),"ca-app-pub-3328184208021419/9085017755", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;


                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        super.onAdFailedToLoad(loadAdError);
                        mInterstitialAd = null;
                    }
                });


    }

    // Show the Interstitial Ad when needed
    void showInterstitialAd() {
        if (mInterstitialAd != null) {
            mInterstitialAd.show(requireActivity());
            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                @Override
                public void onAdClicked() {
                    // Called when a click is recorded for an ad.

                }

                @Override
                public void onAdDismissedFullScreenContent() {
                    // Called when ad is dismissed.
                    // Set the ad reference to null so you don't show the ad a second time.
                    mInterstitialAd.show(requireActivity());
                    loadInt();
                }

                @Override
                public void onAdFailedToShowFullScreenContent(AdError adError) {
                    // Called when ad fails to show.

                    mInterstitialAd = null;
                }

                @Override
                public void onAdImpression() {
                    // Called when an impression is recorded for an ad.

                }

                @Override
                public void onAdShowedFullScreenContent() {
                    // Called when ad is shown.

                }
            });
        } else {
            // The Interstitial Ad is not ready yet. You may choose to try again later or show other content.

        }
    }
}
