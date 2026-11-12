package com.rodrigo.hiloyestiloapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.rodrigo.hiloyestiloapp.databinding.ActivityTarjetasBinding;

public class tarjetas extends AppCompatActivity {

    public static final String EXTRA_CATEGORIA = "extra_categoria";
    public static final String EXTRA_MATERIAL_SELECCIONADO = "extra_material_seleccionado";

    private ActivityTarjetasBinding binding;

    // ActivityResultLauncher para recibir el accesorio seleccionado de DisponiblesActivity
    private final ActivityResultLauncher<Intent> launcherMaterial = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    String materialSeleccionado = result.getData().getStringExtra(EXTRA_MATERIAL_SELECCIONADO);
                    if (materialSeleccionado != null && binding != null) {
                        binding.etMaterialSeleccionado.setText(materialSeleccionado);
                        Toast.makeText(this, "Material asignado: " + materialSeleccionado, Toast.LENGTH_SHORT).show();
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflado exclusivo usando View Binding
        binding = ActivityTarjetasBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configuración de listeners en tarjetas de categorías
        binding.cardBotones.setOnClickListener(v -> abrirOpcionesDisponibles("Botones"));
        binding.cardCremalleras.setOnClickListener(v -> abrirOpcionesDisponibles("Cremalleras"));
        binding.cardElasticos.setOnClickListener(v -> abrirOpcionesDisponibles("Elásticos"));
        binding.cardHilos.setOnClickListener(v -> abrirOpcionesDisponibles("Hilos"));

        // Al hacer clic en el campo Material Seleccionado, también se pueden explorar opciones
        binding.etMaterialSeleccionado.setOnClickListener(v -> abrirOpcionesDisponibles("Accesorios General"));

        // Botón Confirmar Pedido
        binding.btnConfirmarPedido.setOnClickListener(v -> procesarPedido());
    }

    private void abrirOpcionesDisponibles(String categoria) {
        Intent intent = new Intent(this, DisponiblesActivity.class);
        intent.putExtra(EXTRA_CATEGORIA, categoria);
        launcherMaterial.launch(intent);
    }

    private void procesarPedido() {
        String nombre = binding.etNombre.getText() != null ? binding.etNombre.getText().toString().trim() : "";
        String correo = binding.etCorreo.getText() != null ? binding.etCorreo.getText().toString().trim() : "";
        String material = binding.etMaterialSeleccionado.getText() != null ? binding.etMaterialSeleccionado.getText().toString().trim() : "";
        String cantidad = binding.etCantidad.getText() != null ? binding.etCantidad.getText().toString().trim() : "";

        if (TextUtils.isEmpty(nombre)) {
            binding.tilNombre.setError("Ingresa tu nombre");
            return;
        } else {
            binding.tilNombre.setError(null);
        }

        if (TextUtils.isEmpty(correo)) {
            binding.tilCorreo.setError("Ingresa tu correo");
            return;
        } else {
            binding.tilCorreo.setError(null);
        }

        if (TextUtils.isEmpty(material)) {
            binding.tilMaterialSeleccionado.setError("Selecciona un material");
            Toast.makeText(this, "Por favor selecciona un accesorio de las tarjetas superiores", Toast.LENGTH_LONG).show();
            return;
        } else {
            binding.tilMaterialSeleccionado.setError(null);
        }

        if (TextUtils.isEmpty(cantidad)) {
            binding.tilCantidad.setError("Ingresa la cantidad");
            return;
        } else {
            binding.tilCantidad.setError(null);
        }

        String mensaje = "¡Pedido Confirmado!\n" +
                "Cliente: " + nombre + "\n" +
                "Material: " + material + "\n" +
                "Cantidad: " + cantidad + " unidades";

        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();

        // Limpiar formulario después de confirmar
        binding.etNombre.setText("");
        binding.etCorreo.setText("");
        binding.etMaterialSeleccionado.setText("");
        binding.etCantidad.setText("");
    }
}