package com.company;

public class Main {
    //1- Crear un metodo que reciba como parametro un arreglo de numeros enteros y nos devuelva la cantidad de positivos y negativos del array
    //

    public  static String  countNumbers(int[] numberList) {
        int positiveNumbers=0;
        int negativeNumbers=0;
        // cuantos negativos y cuantos positivos hay en la lista numberList
        for (int i = 0; i < numberList.length; i++) {
            if (numberList[i]<0) {
                negativeNumbers++;

            }
            else{
                positiveNumbers++;
            }
        }
        return "La cantidad de numeros negativos es: "+negativeNumbers+", La cantidad de positivos es: "+positiveNumbers;

    }
    public static  int countNumber6(int number) {
        // dado un numero "number" retornar la cantidad de veces que 6 esta en este.
        // // por ej. 67776 contiene 2 veces 6
        // //         987 contiene 0 veces 6
        // //
        String numbers= String.valueOf(number);
        int cantidadDeVeces6=0;
        for (int i = 0; i < numbers.length(); i++) {
            if (numbers.charAt(i)=='6'){
                cantidadDeVeces6++;
            }
        }
        return cantidadDeVeces6;

    }
    public static String getConsecutiveChars(String letters) {
        // retornar los caracteres de la variable "letters" que esten ordenados alfabeticamente
        // // ej. 'abcundf'     : retorna 'abc'
        //abcrrixyz
        // //       'hjtaaaaaxyz' : retorna 'xyz'
        String caracteresOrdenados="";

        Character[] alfabeto= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
        Boolean oc=false;
        for (int i = 0; i < letters.length()-1; i++){

            for (int j = 0; j < alfabeto.length-1; j++) {
                if (letters.charAt(i)==alfabeto[j]){

                    if (letters.charAt(i+1)==alfabeto[j+1]){
                        if (oc==false){
                            caracteresOrdenados+=letters.charAt(i);
                        }
                        caracteresOrdenados+=letters.charAt(i+1);
                        oc=true;
                    }
                    else {
                        if (oc){
                            break;
                        }
                        else {
                            caracteresOrdenados="";
                        }
                    }
                }

            }

        }

        letters=caracteresOrdenados;

        return letters;
    }

    public static void main(String[] args) {
         int[] numbers={1,2,3,4,5,6,-2,-3,-4};

        //System.out.println(countNumbers(numbers));
        //System.out.println(countNumber6(4006));
        System.out.println(getConsecutiveChars(""));

    }
}
