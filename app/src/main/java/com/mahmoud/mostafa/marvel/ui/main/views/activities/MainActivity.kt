package com.mahmoud.mostafa.marvel.ui.main.views.activities

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

import com.mahmoud.mostafa.marvel.R
import com.mahmoud.mostafa.marvel.databinding.ActivityMainBinding
import com.mahmoud.mostafa.marvel.ui.main.views.fragments.CharactersFragment

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        showCharactersFragment()
    }

    private fun showCharactersFragment() {
        supportFragmentManager.beginTransaction().add(R.id.fragment_host,
                CharactersFragment.newInstance()).disallowAddToBackStack().commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
