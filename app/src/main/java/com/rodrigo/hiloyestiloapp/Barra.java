package com.rodrigo.hiloyestiloapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Barra extends AppCompatActivity {

    protected Spinner spinnerMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void setupNavSpinner() {
        spinnerMenu = findViewById(R.id.spinnerMenu);
        if (spinnerMenu != null) {
            String[] opciones = {
                    "Navegación general...",
                    "Inicio",
                    "Gestión Textil",
                    "Envíos Nacionales",
                    "Catálogo de Telas",
                    "Añadir Producto",
                    "Carrito",
                    "Ventas",
                    "Contacto",
                    "Tarjetas",
                    "Disponibles",
                    "Registro Empresa",
                    "Registro Usuario"
            };

            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_spinner_item,
                    opciones
            );
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerMenu.setAdapter(adapter);

            spinnerMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 0) return;
                    Intent intent = null;
                    switch (position) {
                        case 1:
                            intent = new Intent(Barra.this, inicio.class);
                            break;
                        case 2:
                            intent = new Intent(Barra.this, GestionTextilActivity.class);
                            break;
                        case 3:
                            intent = new Intent(Barra.this, Envios_nacionales.class);
                            break;
                        case 4:
                            intent = new Intent(Barra.this, CatalogoTelas.class);
                            break;
                        case 5:
                            intent = new Intent(Barra.this, Anadir_Producto.class);
                            break;
                        case 6:
                            intent = new Intent(Barra.this, Carrito.class);
                            break;
                        case 7:
                            intent = new Intent(Barra.this, Ventas.class);
                            break;
                        case 8:
                            intent = new Intent(Barra.this, ContactoActivity.class);
                            break;
                        case 9:
                            intent = new Intent(Barra.this, tarjetas.class);
                            break;
                        case 10:
                            intent = new Intent(Barra.this, DisponiblesActivity.class);
                            break;
                        case 11:
                            intent = new Intent(Barra.this, Registro_empresa.class);
                            break;
                        case 12:
                            intent = new Intent(Barra.this, registro_usuario.class);
                            break;
                    }
                    if (intent != null) {
                        startActivity(intent);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        }
    }
}