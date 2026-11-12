package com.rodrigo.hiloyestiloapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class formulario_de_solicitud extends AppCompatActivity {

    private EditText etBuscar, etNombre, etCorreo, etMaterial, etCantidad;
    private Button btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulario_de_solicitud);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etBuscar = findViewById(R.id.etBuscar);
        etNombre = findViewById(R.id.etNombre);
        etCorreo = findViewById(R.id.etCorreo);
        etMaterial = findViewById(R.id.etMaterial);
        etCantidad = findViewById(R.id.etCantidad);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        // Recibir el material seleccionado desde el Intent (si se especificó)
        if (getIntent() != null && getIntent().hasExtra("MATERIAL_SELECCIONADO")) {
            String materialSeleccionado = getIntent().getStringExtra("MATERIAL_SELECCIONADO");
            if (materialSeleccionado != null && !materialSeleccionado.isEmpty()) {
                etMaterial.setText(materialSeleccionado);
            }
        }

        btnConfirmar.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString().trim();
            String correo = etCorreo.getText().toString().trim();
            String material = etMaterial.getText().toString().trim();
            String cantidad = etCantidad.getText().toString().trim();

            if (nombre.isEmpty() || correo.isEmpty() || material.isEmpty() || cantidad.isEmpty()) {
                Toast.makeText(formulario_de_solicitud.this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(formulario_de_solicitud.this,
                        "¡Pedido de " + material + " (" + cantidad + " unid.) confirmado para " + nombre + "!",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
