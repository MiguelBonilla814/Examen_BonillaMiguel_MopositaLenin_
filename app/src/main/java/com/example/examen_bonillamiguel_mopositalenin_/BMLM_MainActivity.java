package com.example.examen_bonillamiguel_mopositalenin_;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class BMLM_MainActivity extends AppCompatActivity {

    private ArrayAdapter<Integer> adapter;
    private ArrayAdapter<Integer> adapterIndices;
    private ArrayAdapter<Integer> adapterOrdenar;
    private int[] listaOriginal;
    private int[] vectorIndices;
    private int[] indicesOrdenados;
    private ListView list_view_mostrar;
    private ListView list_view_indices;
    private ListView list_view_ordenar;
    private int REQUEST_LAUNCHER_ACTIVITY2 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_view_mostrar = findViewById(R.id.listView_original);
        list_view_indices = findViewById(R.id.listView_indices);
        list_view_ordenar = findViewById(R.id.listView_ordenar);
    }

    public void Siguiente(View view){
        Intent intent = new Intent(this, BMLM_SegundaActivity.class);
        startActivityForResult(intent, REQUEST_LAUNCHER_ACTIVITY2);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_LAUNCHER_ACTIVITY2){
            if(resultCode == Activity.RESULT_OK){
                listaOriginal = data.getIntArrayExtra("vectorOriginal");
            }
        }
    }

    public void Mostrar(View view){
        vectorIndices = new int[listaOriginal.length];
        int i = 0;
        ArrayList<Integer> listaAux = new ArrayList<Integer>();
        ArrayList<Integer> listaIndicesAux = new ArrayList<Integer>();

        do {
            listaAux.add(listaOriginal[i]);
            i++;
        }while(i < listaOriginal.length);

        i = 0;
        do {
            vectorIndices[i] = i;
            i++;
        }while(i < listaOriginal.length);

        i = 0;
        do {
            listaIndicesAux.add(vectorIndices[i]);
            i++;
        }while(i < vectorIndices.length);

        adapter = new ArrayAdapter<Integer>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaAux);
        list_view_mostrar.setAdapter(adapter);

        adapterIndices = new ArrayAdapter<Integer>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaIndicesAux);
        list_view_indices.setAdapter(adapterIndices);

    }


    public void Ordenar(View view) {

        ArrayList<Integer> lista = new ArrayList<>();
        indicesOrdenados = new int[listaOriginal.length];
        int k = 0;
        do {
            for (int f = 0; f < listaOriginal.length - k - 1; f++) {
                if (listaOriginal[f + 1] > listaOriginal[f]) {
                    int aux;
                    aux = listaOriginal[f + 1];
                    listaOriginal[f + 1] = listaOriginal[f];
                    listaOriginal[f] = aux;
                }
                //Código sin acabar falto tiempo :(
            }
            k++;
        }while(k < listaOriginal.length);



            for (int i = 0; i < listaOriginal.length; i++){
                lista.add(listaOriginal[i]);
            }

            adapterOrdenar = new ArrayAdapter<Integer>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, lista);
            list_view_ordenar.setAdapter(adapterOrdenar);
    }

}