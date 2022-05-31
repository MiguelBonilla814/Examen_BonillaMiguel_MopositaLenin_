package com.example.examen_bonillamiguel_mopositalenin_;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class BMLM_MainActivity extends AppCompatActivity {

    private int REQUEST_LAUNCHER_ACTIVITY2 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                int[] listaOriginal = data.getIntArrayExtra("vectorOriginal");

            }
        }
    }

}