package com.rodrigo.hiloyestiloapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.rodrigo.hiloyestiloapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAbrirPerfilMenu.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PerfilMenuActivity.class);
            startActivity(intent);
        });
    }
}