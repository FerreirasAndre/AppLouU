package com.app.louu;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private void loadJason() {
        List<String> listPalavras = null;
        List<String> listFase1= null;
        List<String> listFase2= null;
        List<String> listFase3= null;
        List<String> listFase4= null;
        String[] strArray;

        //lendo arquivo Json
        try {
            InputStream inputStream = getAssets().open("palavras.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            String json;
            int max;


            json = new String(buffer, StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(json);
            max = jsonArray.length();

            //Parse no Json a manipulação das listas com as palavras
            for (int i = 0; i < max; i++) {
                org.json.JSONObject jsonObject = jsonArray.getJSONObject(i);
                String fullString = jsonObject.getString("Fase");
                strArray = fullString.split(",");
                listPalavras = Arrays.asList(strArray);
                //System.out.println(listPalavras);

                switch (strArray[0]) {
                    case "amou":
                        listFase1 = Arrays.asList(strArray);
                        break;
                    case "anel":
                        listFase2 = Arrays.asList(strArray);
                        break;
                    case "autoria":
                        listFase3 = Arrays.asList(strArray);
                        break;
                    case "falou":
                        listFase4 = Arrays.asList(strArray);
                        break;
                    default:
                        break;
                }

            }
//            System.out.println(listFase1);
//            System.out.println(listFase2);
//            System.out.println(listFase3);
//            System.out.println(listFase4);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (Exception e) {
            Log.e("TAG", "loadJason: error " + e);
        }

    }

       @Override
    protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_main);

           loadJason();
       }

    public void StartGame (View v){
        //Cria uma nova intent (Intenção!!!) para iniciar a activity (Tela) Fase1_Activity
        Intent Start = new Intent(this, Fase1_Activity.class);
        startActivity(Start);
        Log.d("nova fase", "nova fase");

//        Fase1 primeiraFase = new Fase1();
//        primeiraFase.fase1();

       //System.out.println(teste);
    }
    
    public void teste(){

        //Testes de log para debugar
        Fase1 primeiraFase = new Fase1();
        primeiraFase.fase1();
        Log.d("1ª fase", "fase1");
    }
}