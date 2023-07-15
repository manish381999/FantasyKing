package com.tie.fantasyking.Setting;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import com.tie.fantasyking.MainActivity;
import com.tie.fantasyking.databinding.ActivityHelpCenterBinding;


public class Help_Center_Activity extends AppCompatActivity {

    ActivityHelpCenterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHelpCenterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());






        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Help_Center_Activity.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }

}