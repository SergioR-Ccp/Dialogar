package com.example.dialogar;

// Classe Letra.java
public class Letra {

    private String valor;
// Construtor que recebe o valor da letra
    public Letra(String valor) {
        this.valor = valor;
    }


    // Getter para obter o valor da letra
    public String getValor() {
        return valor;
    }
    // Setter para definir o valor da letra
    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor;
    }
}
