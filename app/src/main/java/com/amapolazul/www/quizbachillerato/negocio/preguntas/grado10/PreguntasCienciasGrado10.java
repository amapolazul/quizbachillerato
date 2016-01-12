package com.amapolazul.www.quizbachillerato.negocio.preguntas.grado10;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amapolazul.www.quizbachillerato.R;
import com.amapolazul.www.quizbachillerato.enums.CategoriasEnum;
import com.amapolazul.www.quizbachillerato.intro.IntroGrados;
import com.amapolazul.www.quizbachillerato.negocio.contador.Contador;
import com.amapolazul.www.quizbachillerato.persistencia.Pregunta;
import com.amapolazul.www.quizbachillerato.persistencia.QuizDAO;

import java.sql.SQLException;
import java.util.List;

public class PreguntasCienciasGrado10 extends Activity {

    private QuizDAO quizDao;
    private int indicePrguntaActual;
    private Pregunta preguntaActual;
    private List<Pregunta> preguntasCienciasGrado10;
    private Contador contador;

    private TextView contadorCorrectas;
    private TextView contadorIncorrectas;

    private MediaPlayer sonidoCorrecto;
    private MediaPlayer sonidoIncorrecta;

    private Dialog busyDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas_ciencias_grado10);
        indicePrguntaActual = 0;
        contador = Contador.getInstance();
        contadorCorrectas = (TextView) findViewById(R.id.contadorCorrectasCienciasGrado10);
        contadorIncorrectas = (TextView) findViewById(R.id.contadorIncorrectasCienciasGrado10);

        contadorCorrectas.setText(String.valueOf(contador.getCorrectasCiencias()));
        contadorIncorrectas.setText(String.valueOf(contador.getIncorrectasCiencias()));

        sonidoCorrecto = MediaPlayer.create(this, R.raw.correcta);
        sonidoIncorrecta = MediaPlayer.create(this, R.raw.incorrecta);

        TextView enunciado = (TextView) findViewById(R.id.enunciadoCienciasG10);
        enunciado.setMovementMethod(new ScrollingMovementMethod());
        try {
            quizDao = new QuizDAO(this);
            quizDao.open();
            preguntasCienciasGrado10 = quizDao.darPreguntas(CategoriasEnum.CIENCIAS.getValor(), "10");
//            preguntaActual = new Pregunta();
//            preguntaActual.setCategoria("Ciencias");
//            preguntaActual.setRespuestaCorrecta("A");
//            preguntaActual.setRespuestaC("sdfsdf");
//            preguntaActual.setEnunciado("Enunciado asdad");
//            preguntaActual.setGrado("6");
//            preguntaActual.setImagen("");
//            preguntaActual.setRespuestaA("edfr");
//            preguntaActual.setRespuestaB("edfr");
//            preguntaActual.setRespuestaD("edfr");
//            preguntaActual.setLectura("gdfgd");
//            preguntaActual.setId(2340L);
            inicializarQuiz();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void regresar(View view){
        Intent intent = new Intent(this, IntroGrados.class);
        startActivity(intent);
    }

    private void inicializarQuiz(){
        preguntaActual = preguntasCienciasGrado10.get(indicePrguntaActual);
        TextView enunciado = (TextView) findViewById(R.id.enunciadoCienciasG10);
        TextView respuestaA = (TextView) findViewById(R.id.respuestaACienciasG10);
        TextView respuestaB = (TextView) findViewById(R.id.respuestaBCienciasG10);
        TextView respuestaC = (TextView) findViewById(R.id.respuestaCCienciasG10);
        TextView respuestaD = (TextView) findViewById(R.id.respuestaDCienciasG10);

        enunciado.setText(Html.fromHtml(preguntaActual.getEnunciado()));
        respuestaA.setText(Html.fromHtml(preguntaActual.getRespuestaA()));
        respuestaB.setText(Html.fromHtml(preguntaActual.getRespuestaB()));
        respuestaC.setText(Html.fromHtml(preguntaActual.getRespuestaC()));
        respuestaD.setText(Html.fromHtml(preguntaActual.getRespuestaD()));
        mostrarImagenAyuda();
    }

    public void responderConA(View view) throws InterruptedException {
        ImageView blancoA = (ImageView) view;
        if(preguntaActual.getRespuestaCorrecta().equals("A")){
            contador.aumentarCienciasCorrecta();
            contadorCorrectas.setText(String.valueOf(contador.getCorrectasCiencias()));
            blancoA.setImageResource(R.drawable.correctaa);
            sonidoCorrecto.start();
        } else {
            contador.aumentarCienciasInCorrecta();
            contadorIncorrectas.setText(String.valueOf(contador.getIncorrectasCiencias()));
            blancoA.setImageResource(R.drawable.incorrectaa);
            sonidoIncorrecta.start();
        }

        reiniciarRespuestasYAvanzar();
    }

    public void responderConB(View view) throws InterruptedException {
        ImageView blancoB = (ImageView) view;
        if(preguntaActual.getRespuestaCorrecta().equals("B")){
            contador.aumentarCienciasCorrecta();
            contadorCorrectas.setText(String.valueOf(contador.getCorrectasCiencias()));
            blancoB.setImageResource(R.drawable.correctab);
            sonidoCorrecto.start();
        } else {
            contador.aumentarCienciasInCorrecta();
            contadorIncorrectas.setText(String.valueOf(contador.getIncorrectasCiencias()));
            blancoB.setImageResource(R.drawable.incorrectab);
            sonidoIncorrecta.start();
        }

        reiniciarRespuestasYAvanzar();
    }

    public void responderConC(View view) throws InterruptedException {
        ImageView blancoC = (ImageView) view;
        if(preguntaActual.getRespuestaCorrecta().equals("C")){
            contador.aumentarCienciasCorrecta();
            contadorCorrectas.setText(String.valueOf(contador.getCorrectasCiencias()));
            blancoC.setImageResource(R.drawable.correctac);
            sonidoCorrecto.start();
        } else {
            contador.aumentarCienciasInCorrecta();
            contadorIncorrectas.setText(String.valueOf(contador.getIncorrectasCiencias()));
            blancoC.setImageResource(R.drawable.incorrectac);
            sonidoIncorrecta.start();
        }

        reiniciarRespuestasYAvanzar();
    }

    public void responderConD(View view) throws InterruptedException {
        ImageView blancoD = (ImageView) view;
        if(preguntaActual.getRespuestaCorrecta().equals("D")){
            contador.aumentarCienciasCorrecta();
            contadorCorrectas.setText(String.valueOf(contador.getCorrectasCiencias()));
            blancoD.setImageResource(R.drawable.correctad);
            sonidoCorrecto.start();
        } else {
            contador.aumentarCienciasInCorrecta();
            contadorIncorrectas.setText(String.valueOf(contador.getIncorrectasCiencias()));
            blancoD.setImageResource(R.drawable.incorrectad);
            sonidoIncorrecta.start();
        }

        reiniciarRespuestasYAvanzar();
    }

    private synchronized void reiniciarRespuestasYAvanzar() throws InterruptedException {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ImageView blancoA = (ImageView) findViewById(R.id.respuestaa);
                ImageView blancoB = (ImageView) findViewById(R.id.respuestab);
                ImageView blancoC = (ImageView) findViewById(R.id.respuestac);
                ImageView blancoD = (ImageView) findViewById(R.id.respuestad);

                blancoA.setImageResource(R.drawable.respuestaa);
                blancoB.setImageResource(R.drawable.respuestab);
                blancoC.setImageResource(R.drawable.respuestac);
                blancoD.setImageResource(R.drawable.respuestad);
            }
        }, 500);

        indicePrguntaActual++;

        if(indicePrguntaActual < preguntasCienciasGrado10.size()){
            inicializarQuiz();
        } else {
            Intent intent = new Intent(this, PreguntasSocialesGrado10.class);
            startActivity(intent);
        }
    }

    public void mostrarImagenAyuda(){
        ImageView imageView = (ImageView) findViewById(R.id.imagenAyudas);
        System.out.println(preguntaActual.tieneImagen());
        System.out.println(preguntaActual.tieneLectura());
        if(preguntaActual.tieneImagen()){
            imageView.setImageResource(R.drawable.verimagen);
        } else if (preguntaActual.tieneLectura()){
            imageView.setImageResource(R.drawable.verlectura);
        } else {
            imageView.setImageResource(R.drawable.quizuno);
        }
    }

    private Drawable getDrawableByName(String name){
        System.out.println("name imagen" + name);
        Resources res = getResources();
        String mDrawableName = name;
        int resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
        Drawable drawable = res.getDrawable(resID );
        return drawable;
    }

    public void abrirAyuda(View view){
        if(preguntaActual.tieneImagen()){
            busyDialog = new Dialog(this, R.style.lightbox_dialog);
            busyDialog.setContentView(R.layout.lightbox_image);

            ImageView imagen = (ImageView) busyDialog.findViewById(R.id.imagenAyudaLightBox);
            Drawable drawableImagen = getDrawableByName(preguntaActual.getImagen());
            imagen.setImageDrawable(drawableImagen);

            ImageView dismissDialogImageView = (ImageView)busyDialog.findViewById(R.id.cerrarImagen);
            dismissDialogImageView.setOnClickListener(new ImageView.OnClickListener() {

                @Override
                public void onClick(View v) {
                    busyDialog.dismiss();
                }
            });

            busyDialog.show();
        } else if (preguntaActual.tieneLectura()){
            busyDialog = new Dialog(this, R.style.lightbox_dialog);
            busyDialog.setContentView(R.layout.lightbox_dialog);

            TextView lecturaGradoUno = (TextView) busyDialog.findViewById(R.id.contenidoLectua);
            lecturaGradoUno.setText(Html.fromHtml(preguntaActual.getLectura()));

            ImageView dismissDialogImageView = (ImageView)busyDialog.findViewById(R.id.cerrarLectura);
            dismissDialogImageView.setOnClickListener(new ImageView.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    busyDialog.dismiss();
                }
            });
            busyDialog.show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_preguntas_ciencias_grado10, menu);
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
