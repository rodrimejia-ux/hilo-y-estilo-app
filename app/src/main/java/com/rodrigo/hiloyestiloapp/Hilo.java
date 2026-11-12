package com.rodrigo.hiloyestiloapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Hilo extends AppCompatActivity {

    // Declaración de los elementos de UI
    private ImageView imgAlgodon, imgPoliester, imgNylon, imgSeda, imgLana;
    private Button btnAlgodon, btnPoliester, btnNylon, btnSeda, btnLana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hilo);

        // CORREGIDO: Ahora busca "mainLayout" que es el ID correcto de tu LinearLayout raíz en el XML
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Vinculando los ImageView con sus respectivos IDs del XML
        imgAlgodon = findViewById(R.id.algodon);
        imgPoliester = findViewById(R.id.Poliester);
        imgNylon = findViewById(R.id.Nylon);
        imgSeda = findViewById(R.id.Seda);
        imgLana = findViewById(R.id.Lana);

        // Vinculando los Botones de COMPRAR
        btnAlgodon = findViewById(R.id.btnAlgodon);
        btnPoliester = findViewById(R.id.btnPoliester);
        btnNylon = findViewById(R.id.btnNylon);
        btnSeda = findViewById(R.id.btnSeda);
        btnLana = findViewById(R.id.btnLana);

        // Configurando los eventos de clic para abrir el Formulario de Solicitud
        imgAlgodon.setOnClickListener(v -> navegarAFormulario("Algodón"));
        btnAlgodon.setOnClickListener(v -> navegarAFormulario("Algodón"));

        imgPoliester.setOnClickListener(v -> navegarAFormulario("Poliéster"));
        btnPoliester.setOnClickListener(v -> navegarAFormulario("Poliéster"));

        imgNylon.setOnClickListener(v -> navegarAFormulario("Nylon"));
        btnNylon.setOnClickListener(v -> navegarAFormulario("Nylon"));

        imgSeda.setOnClickListener(v -> navegarAFormulario("Seda"));
        btnSeda.setOnClickListener(v -> navegarAFormulario("Seda"));

        imgLana.setOnClickListener(v -> navegarAFormulario("Lana"));
        btnLana.setOnClickListener(v -> navegarAFormulario("Lana"));
    }

    /**
     * Método para navegar al formulario de solicitud pasando el material seleccionado.
     */
    private void navegarAFormulario(String nombreMaterial) {
        Toast.makeText(this, "Seleccionaste: " + nombreMaterial, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Hilo.this, Formulario_de_solicitud.class);
        intent.putExtra("MATERIAL_SELECCIONADO", nombreMaterial);
        startActivity(intent);
    }
}