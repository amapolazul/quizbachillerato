package com.amapolazul.www.quizbachillerato.negocio.preguntas.grado9;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.amapolazul.www.quizbachillerato.R;
import com.amapolazul.www.quizbachillerato.negocio.contador.Contador;

public class ResultadosGrado9 extends Activity {

    private Contador contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_grado9);

        contador = Contador.getInstance();

        TextView textView = (TextView) findViewById(R.id.idResultadosLenguaje);
        TextView textView1 = (TextView) findViewById(R.id.idResultadosMatematicas);
        TextView textView2 = (TextView) findViewById(R.id.idResultadosCiencias);
        TextView textView3 = (TextView) findViewById(R.id.idResultadosSociales);

        textView.setText(String.valueOf(contador.getCorrectasLenguaje()));
        textView1.setText(String.valueOf(contador.getCorrectasMatematicas()));
        textView2.setText(String.valueOf(contador.getCorrectasCiencias()));
        textView3.setText(String.valueOf(contador.getCorrectasSociales()));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_resultados_grado9, menu);
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
