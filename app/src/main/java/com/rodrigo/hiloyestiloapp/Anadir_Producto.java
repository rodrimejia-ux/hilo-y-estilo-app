package com.rodrigo.hiloyestiloapp;

import android.content.Intent;
import android.os.Bundle;

<<<<<<< HEAD:app/src/main/java/com/rodrigo/hiloyestiloapp/Anadir_Producto.java
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
=======
import androidx.appcompat.app.AppCompatActivity;

import com.rodrigo.hiloyestiloapp.databinding.ActivityMainBinding;
>>>>>>> feature/Rodrigo/desarrollador4:app/src/main/java/com/rodrigo/hiloyestiloapp/MainActivity.java

public class Anadir_Producto extends Barra {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD:app/src/main/java/com/rodrigo/hiloyestiloapp/Anadir_Producto.java
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_anadir_producto);

        setupNavSpinner();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
=======
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAbrirPerfilMenu.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PerfilMenuActivity.class);
            startActivity(intent);
>>>>>>> feature/Rodrigo/desarrollador4:app/src/main/java/com/rodrigo/hiloyestiloapp/MainActivity.java
        });
    }
}