package com.rodrigo.hiloyestiloapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.rodrigo.hiloyestiloapp.databinding.ActivityDisponiblesBinding;

public class DisponiblesActivity extends AppCompatActivity {

    private ActivityDisponiblesBinding binding;
    private String categoriaActual = "Accesorios";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflado exclusivo mediante View Binding
        binding = ActivityDisponiblesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtener la categoría pasada desde la pantalla principal de forma segura
        if (getIntent() != null && getIntent().hasExtra(tarjetas.EXTRA_CATEGORIA)) {
            String catExtra = getIntent().getStringExtra(tarjetas.EXTRA_CATEGORIA);
            if (catExtra != null && !catExtra.trim().isEmpty()) {
                categoriaActual = catExtra.trim();
            }
        }

        configurarVistaPorCategoria(categoriaActual);
    }

    private void configurarVistaPorCategoria(String categoria) {
        binding.tvTituloCategoria.setText("Opciones: " + categoria);
        binding.tvSubtituloCategoria.setText("Catálogo exclusivo disponible para " + categoria);

        // Personalización dinámica según la categoría seleccionada
        if ("Botones".equalsIgnoreCase(categoria)) {
            binding.tvNombreOpcion1.setText("Botón de Madera Tallada (25mm)");
            binding.tvDescOpcion1.setText("Diseño artesanal ideal para abrigos y sacos.");

            binding.tvNombreOpcion2.setText("Botón Metálico Dorado (18mm)");
            binding.tvDescOpcion2.setText("Acabado elegante para chaquetas y uniformes.");

            binding.tvNombreOpcion3.setText("Botón Transparente Camisero (12mm)");
            binding.tvDescOpcion3.setText("Resistente al lavado industrial para camisas.");
        } else if ("Cremalleras".equalsIgnoreCase(categoria)) {
            binding.tvNombreOpcion1.setText("Cremallera Invisible Nylon (50cm)");
            binding.tvDescOpcion1.setText("Cierre discreto para vestidos y faldas de alta costura.");

            binding.tvNombreOpcion2.setText("Cremallera Metálica Reforzada (70cm)");
            binding.tvDescOpcion2.setText("Alta durabilidad para chaquetas y jeans.");

            binding.tvNombreOpcion3.setText("Cremallera Reversible Deportiva");
            binding.tvDescOpcion3.setText("Ideal para prendas deportivas y abrigos dobles.");
        } else if ("Elásticos".equalsIgnoreCase(categoria)) {
            binding.tvNombreOpcion1.setText("Elástico Plano Reforzado (30mm)");
            binding.tvDescOpcion1.setText("Alta tensión para pretinas y confección pesada.");

            binding.tvNombreOpcion2.setText("Elástico Redondo Trenzado (3mm)");
            binding.tvDescOpcion2.setText("Suave al contacto con la piel, ideal para mascarillas o ajustes.");

            binding.tvNombreOpcion3.setText("Elástico Estampado Decorativo (25mm)");
            binding.tvDescOpcion3.setText("Diseño de moda para ropa deportiva e íntima.");
        } else if ("Hilos".equalsIgnoreCase(categoria)) {
            binding.tvNombreOpcion1.setText("Hilo Poliéster Alta Tenacidad (40/2)");
            binding.tvDescOpcion1.setText("Cono de 5000 metros apto para máquinas industriales.");

            binding.tvNombreOpcion2.setText("Hilo de Algodón Mercerizado");
            binding.tvDescOpcion2.setText("Brillo natural ideal para bordados y costuras visibles.");

            binding.tvNombreOpcion3.setText("Hilo Elástico Transparente");
            binding.tvDescOpcion3.setText("Para fruncidos finos y costuras elásticas invisibles.");
        }

        // Listeners para botones "Más información" (AlertDialog)
        binding.btnInfoOpcion1.setOnClickListener(v -> mostrarDialogoInformacion(
                binding.tvNombreOpcion1.getText().toString(),
                binding.tvDescOpcion1.getText().toString(),
                "Tamaños: Varios disponibles | Stock: 150 unidades | Proveedor: Telas & Mercería S.A. | Contacto: contacto@merceria.com"
        ));

        binding.btnInfoOpcion2.setOnClickListener(v -> mostrarDialogoInformacion(
                binding.tvNombreOpcion2.getText().toString(),
                binding.tvDescOpcion2.getText().toString(),
                "Tamaños: Estándar | Stock: 80 unidades | Proveedor: Hilos & Accesorios Ltda. | Contacto: ventas@hilos.com"
        ));

        binding.btnInfoOpcion3.setOnClickListener(v -> mostrarDialogoInformacion(
                binding.tvNombreOpcion3.getText().toString(),
                binding.tvDescOpcion3.getText().toString(),
                "Tamaños: Personalizado | Stock: 200 unidades | Proveedor: EcoTextiles | Contacto: soporte@ecotextiles.org"
        ));

        // Listeners para botones "+ Agregar" (Retornan resultado a tarjetas.java)
        binding.btnAgregarOpcion1.setOnClickListener(v -> retornarMaterialSeleccionado(binding.tvNombreOpcion1.getText().toString()));
        binding.btnAgregarOpcion2.setOnClickListener(v -> retornarMaterialSeleccionado(binding.tvNombreOpcion2.getText().toString()));
        binding.btnAgregarOpcion3.setOnClickListener(v -> retornarMaterialSeleccionado(binding.tvNombreOpcion3.getText().toString()));
    }

    private void mostrarDialogoInformacion(String titulo, String descripcion, String detalles) {
        new MaterialAlertDialogBuilder(this)
                .setTitle(titulo)
                .setMessage(descripcion + "\n\n📌 Detalles Adicionales:\n" + detalles)
                .setPositiveButton("Entendido", (dialog, which) -> dialog.dismiss())
                .show();
    }

    private void retornarMaterialSeleccionado(String nombreMaterial) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(tarjetas.EXTRA_MATERIAL_SELECCIONADO, nombreMaterial);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}