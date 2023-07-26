package com.tie.fantasyking.Setting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tie.fantasyking.R;
import com.tie.fantasyking.databinding.ActivitySettingBinding;

public class SettingActivity extends AppCompatActivity {
ActivitySettingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySettingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.helpCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Help_Center_Activity.class));

            }
        });

        binding.privacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url_privacy = "https://doc-hosting.flycricket.io/fantasyking-privacy-policy/0b19eb2a-667e-4e84-abdc-f0061f667bd4/privacy";
                Intent privacy = new Intent(Intent.ACTION_VIEW);
                privacy.setData(Uri.parse(url_privacy));
                startActivity(privacy);
            }
        });

        binding.terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url_terms= "https://doc-hosting.flycricket.io/fantasyking-terms-condition/40ddc3a5-8e3e-4f30-86ae-115b7ce661ec/terms";
                Intent terms = new Intent(Intent.ACTION_VIEW);
                terms.setData(Uri.parse(url_terms));
                startActivity(terms);

            }
        });

        binding.rateUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url_terms= "https://play.google.com/store/apps/details?id=com.tie.fantasyking";
                Intent terms = new Intent(Intent.ACTION_VIEW);
                terms.setData(Uri.parse(url_terms));
                startActivity(terms);

            }
        });
    }
}