package com.androidavanzado.pmddmm_eval1_ruben_garcia_diez;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre, apellido1, apellido2, telefono, email;
    private Spinner spinnerOpciones;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerOpciones = findViewById(R.id.spinnerOpciones);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.spinnerOpciones,android.R.layout.simple_spinner_item);
        spinnerOpciones.setAdapter(arrayAdapter);

        nombre = (EditText) findViewById(R.id.editTextName);
        apellido1 = (EditText) findViewById(R.id.editTextSurname1);
        apellido2 = (EditText) findViewById(R.id.editTextSurname2);
        telefono = (EditText) findViewById(R.id.editTextPhone);
        email = (EditText) findViewById(R.id.editTextEmailAddress);

        findViewById(R.id.btnReservar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validar()){
                    cuadroDialogo();
                }
            }
        });

   }

   private boolean validar(){

        boolean retorno = true;

        String nom = nombre.getText().toString();
        String ape1 = apellido1.getText().toString();
        String ape2 = apellido2.getText().toString();
        String tlf = telefono.getText().toString();
        String eml = email.getText().toString();

        if (nom.isEmpty()){
            nombre.setError("El nombre no puede quedar vacio");
            retorno = false;
        } if (ape1.isEmpty()) {
           apellido1.setError("El primer apellido no puede quedar vacio");
            retorno = false;
        } if (ape2.isEmpty()) {
           apellido2.setError("El segundo apellido no puede quedar vacio");
           retorno = false;
        } if (tlf.isEmpty()) {
           telefono.setError("El telefono no puede quedar vacio");
           retorno = false;
        } if (eml.isEmpty()) {
           email.setError("El Email no puede quedar vacio");
           retorno = false;
        }

       return retorno;
   }

   private void cuadroDialogo(){
       AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
       builder.setTitle("Aviso");
       builder.setMessage("Se va a proceder a realizar la reserva")
           .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {
                   Toast.makeText(getApplicationContext(), "Se ha realizado la reserva de la plaza", Toast.LENGTH_LONG).show();
                   Intent intent = new Intent(MainActivity.this, EverisWebActivity.class);
                   startActivity(intent);
               }
           })
           .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {
                   dialogInterface.dismiss();
               }
           })
               .setCancelable(false)
               .show();
   }
}