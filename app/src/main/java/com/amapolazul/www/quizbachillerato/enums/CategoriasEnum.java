package com.amapolazul.www.quizbachillerato.enums;

/**
 * Created by jsmartinez on 22/08/2015.
 */
public enum CategoriasEnum {
    CIENCIAS("ciencias"),
    MATEMATICAS("matematicas"),
    SOCIALES("sociales"),
    LENGUAJE("lenguaje");

    private String valor;

    CategoriasEnum(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
