package com.androidavanzado.pmddmm_eval1_ruben_garcia_diez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerOpciones=findViewById(R.id.spinnerOpciones);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.spinnerOpciones,android.R.layout.simple_spinner_item);
        spinnerOpciones.setAdapter(arrayAdapter);

   }
}