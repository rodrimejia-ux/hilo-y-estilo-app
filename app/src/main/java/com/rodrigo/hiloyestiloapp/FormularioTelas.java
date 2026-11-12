
package com.rodrigo.hiloyestiloapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;

public class FormularioTelas extends AppCompatActivity {

    EditText etNombre, etCorreo, etTelefono, etEmpresa;
    EditText etTipoTela, etColor, etCantidad, etUnidad;
    EditText etObservaciones;

    Button btnEnviarSolicitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_telas);

        // Conectar los elementos XML
        etNombre = findViewById(R.id.etNombre);
        etCorreo = findViewById(R.id.etCorreo);
        etTelefono = findViewById(R.id.etTelefono);
        etEmpresa = findViewById(R.id.etEmpresa);

        etTipoTela = findViewById(R.id.etTipoTela);
        etColor = findViewById(R.id.etColor);
        etCantidad = findViewById(R.id.etCantidad);
        etUnidad = findViewById(R.id.etUnidad);

        etObservaciones = findViewById(R.id.etObservaciones);

        btnEnviarSolicitud = findViewById(R.id.btnEnviarSolicitud);

        // Evento del botón
        btnEnviarSolicitud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarFormulario();
            }
        });
    }

    private void validarFormulario() {

        String nombre = etNombre.getText().toString().trim();
        String correo = etCorreo.getText().toString().trim();
        String telefono = etTelefono.getText().toString().trim();
        String empresa = etEmpresa.getText().toString().trim();

        String tipoTela = etTipoTela.getText().toString().trim();
        String color = etColor.getText().toString().trim();
        String cantidad = etCantidad.getText().toString().trim();
        String unidad = etUnidad.getText().toString().trim();

        String observaciones = etObservaciones.getText().toString().trim();

        if (nombre.isEmpty()) {
            etNombre.setError("Ingresa tu nombre");
            etNombre.requestFocus();
            return;
        }

        if (correo.isEmpty()) {
            etCorreo.setError("Ingresa tu correo");
            etCorreo.requestFocus();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            etCorreo.setError("Ingresa un correo válido");
            etCorreo.requestFocus();
            return;
        }

        if (telefono.isEmpty()) {
            etTelefono.setError("Ingresa tu teléfono");
            etTelefono.requestFocus();
            return;
        }

        if (tipoTela.isEmpty()) {
            etTipoTela.setError("Ingresa el tipo de tela");
            etTipoTela.requestFocus();
            return;
        }

        if (color.isEmpty()) {
            etColor.setError("Ingresa el color de la tela");
            etColor.requestFocus();
            return;
        }

        if (cantidad.isEmpty()) {
            etCantidad.setError("Ingresa la cantidad");
            etCantidad.requestFocus();
            return;
        }

        try {
            double cantidadTela = Double.parseDouble(cantidad);

            if (cantidadTela <= 0) {
                etCantidad.setError("La cantidad debe ser mayor que cero");
                etCantidad.requestFocus();
                return;
            }

        } catch (NumberFormatException e) {
            etCantidad.setError("Ingresa una cantidad válida");
            etCantidad.requestFocus();
            return;
        }

        if (unidad.isEmpty()) {
            etUnidad.setError("Ingresa la unidad de medida");
            etUnidad.requestFocus();
            return;
        }

        mostrarResumen(nombre, correo, telefono, empresa,
                tipoTela, color, cantidad, unidad, observaciones);
    }

    private void mostrarResumen(String nombre, String correo,
                                String telefono, String empresa,
                                String tipoTela, String color,
                                String cantidad, String unidad,
                                String observaciones) {

        String resumen =
                "DATOS DEL CLIENTE\n\n" +
                        "Nombre: " + nombre + "\n" +
                        "Correo: " + correo + "\n" +
                        "Teléfono: " + telefono + "\n" +
                        "Empresa: " + (empresa.isEmpty() ? "No especificada" : empresa) +
                        "\n\n" +
                        "DETALLES DE LA SOLICITUD\n\n" +
                        "Tipo de tela: " + tipoTela + "\n" +
                        "Color: " + color + "\n" +
                        "Cantidad: " + cantidad + " " + unidad + "\n" +
                        "Observaciones: " +
                        (observaciones.isEmpty() ? "Ninguna" : observaciones);

        new AlertDialog.Builder(FormularioTelas.this)
                .setTitle("Confirmar solicitud")
                .setMessage(resumen)
                .setPositiveButton("Aceptar", (dialog, which) -> {

                    Toast.makeText(
                            FormularioTelas.this,
                            "Solicitud revisada correctamente",
                            Toast.LENGTH_LONG
                    ).show();

                    limpiarFormulario();
                })
                .setNegativeButton("Cancelar", null)
                .show();
    }

    private void limpiarFormulario() {

        etNombre.setText("");
        etCorreo.setText("");
        etTelefono.setText("");
        etEmpresa.setText("");

        etTipoTela.setText("");
        etColor.setText("");
        etCantidad.setText("");
        etUnidad.setText("");

        etObservaciones.setText("");
    }
}
