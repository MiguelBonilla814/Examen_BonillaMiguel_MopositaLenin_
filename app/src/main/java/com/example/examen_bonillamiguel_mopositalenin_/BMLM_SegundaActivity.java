package com.example.examen_bonillamiguel_mopositalenin_;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class BMLM_SegundaActivity extends AppCompatActivity {

    private ArrayList<Integer> listaNumeros = new ArrayList<>();
    private ListView list;
    private EditText edit_agregar_numero;
    private ArrayAdapter<Integer> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmlm_segunda);

        edit_agregar_numero = findViewById(R.id.editText_agregar);
        list = findViewById(R.id.list_view);

    }

    //

    public void Agregar(View view){
        listaNumeros.add(Integer.parseInt(edit_agregar_numero.getText().toString()));
        edit_agregar_numero.setText("");
        Toast.makeText(this, String.valueOf(listaNumeros.size()), Toast.LENGTH_LONG).show();
        adapter = new ArrayAdapter<Integer>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaNumeros);
        list.setAdapter(adapter);
    }

    public void Cerrar(View view){
        int[] lista = new int[listaNumeros.size()];

        for (int i = 0; i < lista.length; i++){
            lista[i] = listaNumeros.get(i);
        }

        Intent intent = new Intent();
        intent.putExtra("vectorOriginal", lista);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

}