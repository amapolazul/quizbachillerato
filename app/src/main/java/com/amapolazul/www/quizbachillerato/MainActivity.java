package com.amapolazul.www.quizbachillerato;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.amapolazul.www.quizbachillerato.intro.IntroGrados;
import com.amapolazul.www.quizbachillerato.negocio.contador.Contador;
import com.amapolazul.www.quizbachillerato.persistencia.Pregunta;
import com.amapolazul.www.quizbachillerato.persistencia.QuizDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;


public class MainActivity extends Activity {

    private ProgressDialog pd;
    private Contador contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pd = new ProgressDialog(this);
        pd.setMessage("Cargando preguntas");
        pd.setTitle("Quiz");
        pd.show();

        contador = Contador.getInstance();
        contador.reiniciarContador();

        new CargarPreguntasThread(this).execute();

    }

    private class CargarPreguntasThread extends AsyncTask<Void, Void, Void> {

        private QuizDAO quizDao;
        private AssetManager assetManager;

        public CargarPreguntasThread(Context context){
            System.out.println(context);
            quizDao = new QuizDAO(context);
            assetManager = context.getAssets();
        }

        protected Void doInBackground(Void... args) {
            try {
                quizDao.open();
                try {
                    InputStream csvStream = assetManager.open("sexto.csv");
                    InputStreamReader csvStreamReader = new InputStreamReader(csvStream);
                    BufferedReader reader = new BufferedReader(csvStreamReader);
                    quizDao.open();
                    quizDao.removeAll();
                    String line;
                    if(quizDao.darPreguntas("ciencias", "6") == null) {
                        while ((line = reader.readLine()) != null) {
                            String[] array = line.split("&");
                            System.out.println("agregando linea " + line);
                            Pregunta pregunta = new Pregunta();
                            pregunta.setEnunciado(array[0]);
                            pregunta.setRespuestaA(array[1]);
                            pregunta.setRespuestaB(array[2]);
                            pregunta.setRespuestaC(array[3]);
                            pregunta.setRespuestaD(array[4]);
                            pregunta.setRespuestaCorrecta(array[5]);
                            pregunta.setCategoria(array[6]);
                            pregunta.setLectura(array[7]);
                            pregunta.setGrado(array[8]);
                            pregunta.setImagen(array[9]);
                            quizDao.crearPregunta(pregunta);
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                pd.dismiss();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(Void result) {

        }
    }

    public void goToMenu(View vista){
        Intent intent = new Intent(this, IntroGrados.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
