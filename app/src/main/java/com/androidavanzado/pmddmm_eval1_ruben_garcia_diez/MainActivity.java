package com.androidavanzado.pmddmm_eval1_ruben_garcia_diez;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre, apellido1, apellido2, telefono, email;
    private Button btnReservar;
    private Spinner spinnerOpciones;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(R.string.statusbarTittle1);

        spinnerOpciones = findViewById(R.id.spinnerOpciones);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.spinnerOpciones,android.R.layout.simple_spinner_item);
        spinnerOpciones.setAdapter(arrayAdapter);

        nombre = findViewById(R.id.editTextName);
        apellido1 = findViewById(R.id.editTextSurname1);
        apellido2 = findViewById(R.id.editTextSurname2);
        telefono = findViewById(R.id.editTextPhone);
        email = findViewById(R.id.editTextEmailAddress);
        btnReservar = findViewById(R.id.btnReservar);

        nombre.addTextChangedListener(compruebaTexto);
        apellido1.addTextChangedListener(compruebaTexto);
        apellido2.addTextChangedListener(compruebaTexto);
        telefono.addTextChangedListener(compruebaTexto);
        email.addTextChangedListener(compruebaTexto);

        btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    cuadroDialogo();
            }
        });

   }

   private TextWatcher compruebaTexto = new TextWatcher() {
       @Override
       public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

       }

       @Override
       public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
           String nom = nombre.getText().toString().trim();
           String ape1 = apellido1.getText().toString().trim();
           String ape2 = apellido2.getText().toString().trim();
           String tlf = telefono.getText().toString().trim();
           String eml = email.getText().toString().trim();

           btnReservar.setEnabled(!nom.isEmpty() && !ape1.isEmpty() && !ape2.isEmpty() && !tlf.isEmpty() && !eml.isEmpty());
       }

       @Override
       public void afterTextChanged(Editable editable) {

       }
   };

   private void cuadroDialogo(){
       AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
       builder.setTitle(R.string.aviso);
       builder.setMessage(R.string.mensaje)
           .setPositiveButton(R.string.btnAceptar, new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {
                   Toast.makeText(getApplicationContext(), R.string.msnToast, Toast.LENGTH_LONG).show();
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