package com.rodrigo.hiloyestiloapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rodrigo.hiloyestiloapp.databinding.ActivityContactoBinding;

public class ContactoActivity extends AppCompatActivity {

    private ActivityContactoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        configurarListeners();
    }

    private void configurarListeners() {
        binding.btnAbrirMaps.setOnClickListener(v -> abrirUbicacionEnMaps());
        binding.btnEnviarComentario.setOnClickListener(v -> enviarComentario());
    }

    private void abrirUbicacionEnMaps() {
        String ubicacion = "Barrio Pueblillo, Popayán, Cauca";
        Uri uriGeo = Uri.parse("geo:0,0?q=" + Uri.encode(ubicacion));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uriGeo);
        mapIntent.setPackage("com.google.android.apps.maps");

        try {
            startActivity(mapIntent);
        } catch (ActivityNotFoundException e) {
            // Respaldar abriendo la ubicación en el navegador web si no está instalada la App de Google Maps
            Uri uriWeb = Uri.parse("https://www.google.com/maps/search/?api=1&query=" + Uri.encode(ubicacion));
            Intent webIntent = new Intent(Intent.ACTION_VIEW, uriWeb);
            try {
                startActivity(webIntent);
            } catch (ActivityNotFoundException ex) {
                Toast.makeText(this, "No se encontró una aplicación para abrir el mapa", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void enviarComentario() {
        String nombre = binding.etNombreCompleto.getText().toString().trim();
        String correo = binding.etCorreo.getText().toString().trim();
        String mensaje = binding.etMensaje.getText().toString().trim();

        if (nombre.isEmpty()) {
            binding.etNombreCompleto.setError("Por favor, ingresa tu nombre completo");
            binding.etNombreCompleto.requestFocus();
            return;
        }

        if (correo.isEmpty()) {
            binding.etCorreo.setError("Por favor, ingresa tu correo electrónico");
            binding.etCorreo.requestFocus();
            return;
        }

        if (mensaje.isEmpty()) {
            binding.etMensaje.setError("Por favor, escribe tu mensaje");
            binding.etMensaje.requestFocus();
            return;
        }

        // Mostrar Toast de confirmación con el nombre del usuario
        String confirmacion = "¡Gracias " + nombre + "! Tu comentario ha sido enviado exitosamente.";
        Toast.makeText(this, confirmacion, Toast.LENGTH_LONG).show();

        // Limpiar campos
        binding.etNombreCompleto.setText("");
        binding.etCorreo.setText("");
        binding.etMensaje.setText("");
        binding.etNombreCompleto.clearFocus();
        binding.etCorreo.clearFocus();
        binding.etMensaje.clearFocus();
    }
}