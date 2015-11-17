package com.amapolazul.www.quizbachillerato.negocio.contador;

/**
 * Created by jsmartinez on 22/08/2015.
 */
public class Contador {

    private static Contador contador;

    private int correctasMatematicas;
    private int incorrectasMatematicas;
    private int correctasCiencias;
    private int incorrectasCiencias;
    private int correctasLenguaje;
    private int incorrectasLenguaje;
    private int correctasSociales;
    private int incorrectaSociales;

    protected Contador(){
        this.correctasCiencias = 0;
        this.incorrectasCiencias = 0;
        this.correctasSociales = 0;
        this.incorrectaSociales = 0;
        this.correctasMatematicas = 0;
        this.incorrectasMatematicas = 0;
        this.correctasLenguaje = 0;
        this.incorrectasLenguaje = 0;
    }

    public void setCorrectasMatematicas(int correctasMatematicas) {
        this.correctasMatematicas = correctasMatematicas;
    }

    public void setIncorrectasMatematicas(int incorrectasMatematicas) {
        this.incorrectasMatematicas = incorrectasMatematicas;
    }

    public void setCorrectasCiencias(int correctasCiencias) {
        this.correctasCiencias = correctasCiencias;
    }

    public void setIncorrectasCiencias(int incorrectasCiencias) {
        this.incorrectasCiencias = incorrectasCiencias;
    }

    public void setCorrectasLenguaje(int correctasLenguaje) {
        this.correctasLenguaje = correctasLenguaje;
    }

    public void setIncorrectasLenguaje(int incorrectasLenguaje) {
        this.incorrectasLenguaje = incorrectasLenguaje;
    }

    public void setCorrectasSociales(int correctasSociales) {
        this.correctasSociales = correctasSociales;
    }

    public void setIncorrectaSociales(int incorrectaSociales) {
        this.incorrectaSociales = incorrectaSociales;
    }

    public void aumentarMatematicasCorrecta(){
        this.correctasMatematicas++;
    }

    public void aumentarMatematicasInCorrecta(){
        this.incorrectasMatematicas++;
    }

    public void aumentarCienciasCorrecta(){
        this.correctasCiencias++;
    }

    public void aumentarCienciasInCorrecta(){
        this.incorrectasCiencias++;
    }

    public void aumentarLenguajeCorrecta(){
        this.correctasLenguaje++;
    }

    public void aumentarLenguajeInCorrecta(){
        this.incorrectasLenguaje++;
    }

    public void aumentarSocialesCorrecta(){
        this.correctasSociales++;
    }

    public void aumentarSocialesInCorrecta(){
        this.incorrectaSociales++;
    }

    public int getCorrectasMatematicas() {
        return correctasMatematicas;
    }

    public int getIncorrectasMatematicas() {
        return incorrectasMatematicas;
    }

    public int getCorrectasCiencias() {
        return correctasCiencias;
    }

    public int getIncorrectasCiencias() {
        return incorrectasCiencias;
    }

    public int getCorrectasLenguaje() {
        return correctasLenguaje;
    }

    public int getIncorrectasLenguaje() {
        return incorrectasLenguaje;
    }

    public int getCorrectasSociales() {
        return correctasSociales;
    }

    public int getIncorrectasSociales() {
        return incorrectaSociales;
    }

    public void reiniciarContador(){
        setCorrectasCiencias(0);
        setCorrectasSociales(0);
        setCorrectasLenguaje(0);
        setCorrectasMatematicas(0);
        setIncorrectaSociales(0);
        setIncorrectasCiencias(0);
        setIncorrectasMatematicas(0);
        setIncorrectasLenguaje(0);
    }

    public static Contador getInstance(){
        if(contador == null){
            contador = new Contador();
        }
        return contador;
    }
}
