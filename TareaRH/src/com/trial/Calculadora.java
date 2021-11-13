package com.trial;

public class Calculadora {
    Calculadora(){}

    int Sumar(int primerSumando, int segundoSumando){
        return primerSumando + segundoSumando;
    }

    int Restar(int primerRestando, int segundoRestando){
        return primerRestando - segundoRestando;
    }

    int Multiplicar(int primerMultiplicando, int segundoMultiplicando){
        return primerMultiplicando * segundoMultiplicando;
    }

    int Dividir(int dividendo, int divisor){
        return dividendo / divisor ;
    }

    public static void main(String[] args) {
        Calculadora miCalculadora = new Calculadora();
        System.out.println(miCalculadora.Sumar(2, 2));
        System.out.println(miCalculadora.Restar(1, 2));
        System.out.println(miCalculadora.Dividir(5, 10));
        System.out.println(miCalculadora.Multiplicar(4, 4));

    }
}
