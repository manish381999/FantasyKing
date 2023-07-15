package com.tie.fantasyking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tie.fantasyking.databinding.ActivityFantasyTipsBinding;

public class Fantasy_TipsActivity extends AppCompatActivity {
ActivityFantasyTipsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFantasyTipsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}