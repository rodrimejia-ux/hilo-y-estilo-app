package com.rodrigo.hiloyestiloapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.rodrigo.hiloyestiloapp.databinding.ActivityPerfilMenuBinding;
import com.rodrigo.hiloyestiloapp.databinding.DialogCambiarCuentaBinding;
import com.rodrigo.hiloyestiloapp.databinding.DialogCerrarSesionBinding;
import com.rodrigo.hiloyestiloapp.databinding.DialogEditarPerfilBinding;

public class PerfilMenuActivity extends AppCompatActivity {

    private ActivityPerfilMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPerfilMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        configurarListeners();
    }

    private void configurarListeners() {
        binding.tvEditarPerfil.setOnClickListener(v -> mostrarDialogEditarPerfil());
        binding.tvCambiarCuenta.setOnClickListener(v -> mostrarDialogCambiarCuenta());
        binding.tvVolver.setOnClickListener(v -> finish());
        binding.tvSalir.setOnClickListener(v -> mostrarDialogCerrarSesion());
    }

    private void mostrarDialogEditarPerfil() {
        DialogEditarPerfilBinding dialogBinding = DialogEditarPerfilBinding.inflate(getLayoutInflater());

        // Cargar valores actuales en los campos
        dialogBinding.etNombre.setText(binding.tvNombre.getText().toString());
        dialogBinding.etCorreo.setText(binding.tvCorreo.getText().toString());
        dialogBinding.etCargo.setText(binding.tvRol.getText().toString());

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(dialogBinding.getRoot())
                .create();

        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        dialogBinding.btnGuardarCambios.setOnClickListener(v -> {
            String nombre = dialogBinding.etNombre.getText().toString().trim();
            String correo = dialogBinding.etCorreo.getText().toString().trim();
            String cargo = dialogBinding.etCargo.getText().toString().trim();

            if (nombre.isEmpty()) {
                dialogBinding.etNombre.setError("El nombre no puede estar vacío");
                dialogBinding.etNombre.requestFocus();
                return;
            }

            if (correo.isEmpty()) {
                dialogBinding.etCorreo.setError("El correo no puede estar vacío");
                dialogBinding.etCorreo.requestFocus();
                return;
            }

            if (cargo.isEmpty()) {
                dialogBinding.etCargo.setError("El cargo no puede estar vacío");
                dialogBinding.etCargo.requestFocus();
                return;
            }

            // Actualizar textos en la pantalla principal
            binding.tvNombre.setText(nombre);
            binding.tvCorreo.setText(correo);
            binding.tvRol.setText(cargo);

            // Actualizar iniciales del avatar
            binding.tvAvatar.setText(obtenerIniciales(nombre));

            Toast.makeText(PerfilMenuActivity.this, "Perfil actualizado correctamente", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });

        dialog.show();
    }

    private void mostrarDialogCambiarCuenta() {
        DialogCambiarCuentaBinding dialogBinding = DialogCambiarCuentaBinding.inflate(getLayoutInflater());

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(dialogBinding.getRoot())
                .create();

        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        // Selección Cuenta 1
        dialogBinding.itemCuenta1.setOnClickListener(v -> {
            binding.tvAvatar.setText("HS");
            binding.tvNombre.setText("Hilo y Estilo");
            binding.tvRol.setText("Administrador");
            binding.tvCorreo.setText("hiloestilo@gmail.com");

            Toast.makeText(PerfilMenuActivity.this, "Cuenta cambiada a Hilo y Estilo", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });

        // Selección Cuenta 2
        dialogBinding.itemCuenta2.setOnClickListener(v -> {
            binding.tvAvatar.setText("AD");
            binding.tvNombre.setText("Administrador");
            binding.tvRol.setText("Administrador Principal");
            binding.tvCorreo.setText("admin@gmail.com");

            Toast.makeText(PerfilMenuActivity.this, "Cuenta cambiada a Administrador", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });

        // Agregar otra cuenta
        dialogBinding.btnAgregarCuenta.setOnClickListener(v -> {
            Toast.makeText(PerfilMenuActivity.this, "Agregar otra cuenta seleccionado", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });

        dialog.show();
    }

    private void mostrarDialogCerrarSesion() {
        DialogCerrarSesionBinding dialogBinding = DialogCerrarSesionBinding.inflate(getLayoutInflater());

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(dialogBinding.getRoot())
                .create();

        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        // Botón Cancelar -> cierra el diálogo
        dialogBinding.btnCancelar.setOnClickListener(v -> dialog.dismiss());

        // Botón Confirmar Cerrar Sesión
        dialogBinding.btnConfirmarCerrar.setOnClickListener(v -> {
            Toast.makeText(PerfilMenuActivity.this, "Sesión cerrada", Toast.LENGTH_SHORT).show();
            dialog.dismiss();

            Intent intent = new Intent(PerfilMenuActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        dialog.show();
    }

    private String obtenerIniciales(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return "HS";
        }
        String[] partes = nombre.trim().split("\\s+");
        if (partes.length >= 2) {
            return (partes[0].substring(0, 1) + partes[1].substring(0, 1)).toUpperCase();
        } else if (partes[0].length() >= 2) {
            return partes[0].substring(0, 2).toUpperCase();
        } else {
            return partes[0].toUpperCase();
        }
    }
}