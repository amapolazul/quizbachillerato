package com.amapolazul.www.quizbachillerato.intro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.amapolazul.www.quizbachillerato.R;
import com.amapolazul.www.quizbachillerato.negocio.preguntas.grado10.PreguntasMatematicasGrado10;
import com.amapolazul.www.quizbachillerato.negocio.preguntas.grado11.PreguntasMatematicasGrado11;
import com.amapolazul.www.quizbachillerato.negocio.preguntas.grado6.PreguntasMatematicasGrado6;
import com.amapolazul.www.quizbachillerato.negocio.preguntas.grado7.PreguntasMatematicasGrado7;
import com.amapolazul.www.quizbachillerato.negocio.preguntas.grado8.PreguntasMatematicasGrado8;
import com.amapolazul.www.quizbachillerato.negocio.preguntas.grado9.PreguntasMatematicasGrado9;

public class IntroGrados extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_grados);
    }

    public void irAGrado6(View view){
        Intent intent = new Intent(this, PreguntasMatematicasGrado6.class);
        startActivity(intent);
    }

    public void irAGrado7(View view){
        Intent intent = new Intent(this, PreguntasMatematicasGrado7.class);
        startActivity(intent);
    }

    public void irAGrado8(View view){
        Intent intent = new Intent(this, PreguntasMatematicasGrado8.class);
        startActivity(intent);
    }

    public void irAGrado9(View view){
        Intent intent = new Intent(this, PreguntasMatematicasGrado9.class);
        startActivity(intent);
    }

    public void irAGrado10(View view){
        Intent intent = new Intent(this, PreguntasMatematicasGrado10.class);
        startActivity(intent);
    }

    public void irAGrado11(View view){
        Intent intent = new Intent(this, PreguntasMatematicasGrado11.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_intro_grados, menu);
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
