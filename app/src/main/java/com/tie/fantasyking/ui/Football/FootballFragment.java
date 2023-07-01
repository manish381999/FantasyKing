package com.tie.fantasyking.ui.Football;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;
import com.tie.fantasyking.R;
import com.tie.fantasyking.databinding.FragmentFootballBinding;

import java.util.ArrayList;

public class FootballFragment extends Fragment  implements NavigationView.OnNavigationItemSelectedListener{
FragmentFootballBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentFootballBinding.inflate(inflater, container, false);

        requireActivity().setTitle("FantasyKing");



        ArrayList<SlideModel> imageList = new ArrayList<>(); // Create image list

        imageList.add(new SlideModel("https://bit.ly/2YoJ77H", "The animal population decreased by 58 percent in 42 years.", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://bit.ly/2BteuF2", "Elephants and tigers may become extinct.",ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://bit.ly/3fLJf72", "And people do that.",ScaleTypes.CENTER_CROP));

        binding.imageSlider.setImageList(imageList);
        return binding.getRoot();
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