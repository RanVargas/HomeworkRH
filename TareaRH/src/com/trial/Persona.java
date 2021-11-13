package com.trial;
public class Persona {
    String nombre;
    String apellido;
    int edad;
    String sexo;

    Persona(String nombre, String apellido, int edad, String sexo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String Dormir(){
        return nombre + " " + apellido + " que tiene " + Integer.toString(edad) + " Y es de sexo " + sexo + " esta durmiendo";
    }

    public String Caminar(){
        return nombre + " " + apellido + " que tiene " + Integer.toString(edad) + " Y es de sexo " + sexo + " esta caminando";
    }

    public String Comer(){
        return nombre + " " + apellido + " que tiene " + Integer.toString(edad) + " Y es de sexo " + sexo + " esta comiendo";
    }

    public String Correr(){
        return nombre + " " + apellido + " que tiene " + Integer.toString(edad) + " Y es de sexo " + sexo + " esta corriendo";
    }


    String Comer(String nombre){
        return "Hola " + nombre;
    }
}
