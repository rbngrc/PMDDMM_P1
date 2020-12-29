package com.androidavanzado.pmddmm_eval1_ruben_garcia_diez;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerOpciones=findViewById(R.id.spinnerOpciones);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.spinnerOpciones,android.R.layout.simple_spinner_item);
        spinnerOpciones.setAdapter(arrayAdapter);

        findViewById(R.id.btnReservar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cuadroDialogo();
            }
        });

   }

   private void cuadroDialogo(){
       AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
       builder.setTitle("Titulo");
       builder.setMessage("Se va a proceder a realizar la reserva")
           .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {
                   Toast.makeText(getApplicationContext(), "Se ha realizado la reserva de la plaza", Toast.LENGTH_LONG).show();
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