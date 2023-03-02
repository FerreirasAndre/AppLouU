package com.app.louu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Testes de log para debugar
        //Fase1 fase1 = new Fase1();
        //fase1.jogo();
    }

    public void StartGame (View v){
        //Cria uma nova intent (Intenção!!!) para iniciar a activity (Tela) Fase1_Activity
        Intent Start = new Intent(this, Fase1_Activity.class);
        startActivity(Start);
        Log.d("nova fase", "nova fase");
    }

//    public void InicioFase1 (View v){
//        //Cria uma nova intent (Intenção!!!) para iniciar a activity (Tela) Fase1_Activity
//        Intent InitFase1 = new Intent(this, jogo_1.class);
//        startActivity(InitFase1);
//        Log.d("nova fase", "nova fase");
//    }
}