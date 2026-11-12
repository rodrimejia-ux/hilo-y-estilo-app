
package com.rodrigo.hiloyestiloapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CatalogoTelas extends AppCompatActivity {

    // Declarar los botones
    Button btnAlgodon, btnPoliester, btnNylon, btnSeda, btnLana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo_telas);

        // Conectar los botones del XML
        btnAlgodon = findViewById(R.id.btnAlgodon);
        btnPoliester = findViewById(R.id.btnPoliester);
        btnNylon = findViewById(R.id.btnlana);
        btnSeda = findViewById(R.id.btnSeda);
        btnLana = findViewById(R.id.btncuero);

        // Boton Algodon
        btnAlgodon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprarTela("Algodón");
            }
        });

        // Boton Poliester
        btnPoliester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprarTela("Poliéster");
            }
        });

        // Boton Nylon
        btnNylon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprarTela("Lana");
            }
        });

        // Boton Seda
        btnSeda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprarTela("Seda");
            }
        });

        // Boton Lana
        btnLana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprarTela("Cuero");
            }
        });
    }

    // Metodo para mostrar la tela seleccionada
    private void comprarTela(String nombreTela) {

        Toast.makeText(
                CatalogoTelas.this,
                "Has seleccionado: " + nombreTela,
                Toast.LENGTH_SHORT
        ).show();
    }
}
