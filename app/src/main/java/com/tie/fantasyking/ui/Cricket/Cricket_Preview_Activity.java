package com.tie.fantasyking.ui.Cricket;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.tie.fantasyking.R;
import com.tie.fantasyking.databinding.ActivityCricketPreviewBinding;

public class Cricket_Preview_Activity extends AppCompatActivity {
ActivityCricketPreviewBinding binding;
    private AdView mAdView;


    String id,match,tournamentName,match_date,match_time,matchQuality,match_preview,match_statistics,teamA,teamB,aPlaying11,
            bPlaying11,match_captain,vCaptain,teamStatus;

    public String img_team_a,img_team_b,team_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCricketPreviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                super.onAdClicked();


            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
                super.onAdFailedToLoad(adError);
                mAdView.loadAd(adRequest);
            }

            @Override
            public void onAdImpression() {
                // Code to be executed when an impression is recorded
                // for an ad.
            }

            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                super.onAdLoaded();
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                super.onAdOpened();
            }
        });


        id=getIntent().getStringExtra("id");
        img_team_a=getIntent().getStringExtra("im_team_a");
        img_team_b=getIntent().getStringExtra("im_team_b");
        match=getIntent().getStringExtra("match_name");
        tournamentName=getIntent().getStringExtra("tournament");
        match_date=getIntent().getStringExtra("date");
        match_time=getIntent().getStringExtra("time");
        matchQuality=getIntent().getStringExtra("match_quality");
        match_preview=getIntent().getStringExtra("preview");
        match_statistics=getIntent().getStringExtra("statistics");
        teamA=getIntent().getStringExtra("team_a");
        teamB=getIntent().getStringExtra("team_b");
        aPlaying11=getIntent().getStringExtra("A_playing11");
        bPlaying11=getIntent().getStringExtra("B_playing11");
        match_captain=getIntent().getStringExtra("captain");
        vCaptain=getIntent().getStringExtra("Vc");
        teamStatus=getIntent().getStringExtra("team_status");
        team_img=getIntent().getStringExtra("im_team");

        Glide.with(getApplicationContext()).load("https://tiemysql.000webhostapp.com/Images/"+img_team_a).into(binding.imTeamA);
        Glide.with(getApplicationContext()).load("https://tiemysql.000webhostapp.com/Images/"+img_team_b).into(binding.imTeamB);
        Glide.with(getApplicationContext()).load("https://tiemysql.000webhostapp.com/Images/"+team_img).into(binding.imTeam);

        binding.etMatch.setText(match);
        binding.etTournamentName.setText(tournamentName);
        binding.etDate.setText(match_date);
        binding.etTime.setText(match_time);
        binding.etMatchQuality.setText(matchQuality);
        binding.etPreview.setText(match_preview);
        binding.etStatistics.setText(match_statistics);
        binding.etTeamA.setText(teamA);
        binding.etTeamB.setText(teamB);
        binding.etAPlaying11.setText(aPlaying11);
        binding.etBPlaying11.setText(bPlaying11);
        binding.etCaptain.setText(match_captain);
        binding.etVc.setText(vCaptain);
        binding.etTeamStatus.setText(teamStatus);

    }
}