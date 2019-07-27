package com.mahmoud.mostafa.marvel.ui.main.views.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.mahmoud.mostafa.marvel.R;
import com.mahmoud.mostafa.marvel.databinding.ActivityMainBinding;
import com.mahmoud.mostafa.marvel.ui.main.views.fragments.CharactersFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        showCharactersFragment();
    }

    private void showCharactersFragment() {
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_host,
                CharactersFragment.newInstance()).disallowAddToBackStack().commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
