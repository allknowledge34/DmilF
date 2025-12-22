package com.sachin.dmilf.views.activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;


import com.sachin.dmilf.R;
import com.sachin.dmilf.databinding.ActivityMainBinding;
import com.sachin.dmilf.utils.Constants;
import com.sachin.dmilf.utils.LocaleHelper;
import com.sachin.dmilf.viewmodels.MainViewModel;
import com.sachin.dmilf.views.fragments.ChatbotFragment;
import com.sachin.dmilf.views.fragments.ProfileFragment;
import com.sachin.dmilf.views.fragments.StatsFragment;
import com.sachin.dmilf.views.fragments.TransactionsFragment;

import java.util.Calendar;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Calendar calendar;
    public MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        Constants.setCategories();
        calendar = Calendar.getInstance();
        loadFragment(new TransactionsFragment());
        binding.bottomBar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int lastIndex, AnimatedBottomBar.Tab lastTab, int newIndex, AnimatedBottomBar.Tab newTab) {
                Fragment selectedFragment = null;

                switch (newIndex) {
                    case 0:
                        selectedFragment = new TransactionsFragment();
                        break;
                    case 1:
                        selectedFragment = new StatsFragment();
                        break;
                    case 2:
                        selectedFragment = new ChatbotFragment();
                        break;
                    case 3:
                        selectedFragment = new ProfileFragment();
                        break;
                }

                if (selectedFragment != null) {
                    loadFragment(selectedFragment);
                }
            }

            @Override
            public void onTabReselected(int index, AnimatedBottomBar.Tab tab) {

            }
        });


    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, fragment);
        transaction.commit();
    }

    public void getTransactions() {
        viewModel.getTransactions(calendar);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase));
    }
}
