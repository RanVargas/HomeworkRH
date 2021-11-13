public class Animales {
    String nombre = " aguila ";
    String especie = " voladora ";
    int edad = 35;
    String habitad = " caluroso ";

    Animales(){
    }

    Animales (String nombre, String especie, int edad, String habitad){
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.habitad = habitad;
    }

    public String volando (){
        return "El animal se llama: " + nombre + " Y su especie es " + especie +" y su edad es " + Integer.toString(edad) + " y su habitad es " + habitad + "volando ";
    }

    public String caluroso (){
        return "El animal se llama" + nombre + " y su especie es " + especie + " y su edad es" + edad + " y su habitdad es " + habitad + "corriendo por la selva";
    }
    public String dumiendo (){
        return "Se llama" + nombre + " pertenece a la " + especie + " y su edad es de " + edad + " Y su habitad es de " + habitad  + "Y se arrastra por el suelo";
    }
    public String comiendo (){
        return " Se llama " + nombre + " pertenece " + especie + " y su edad es de  " + edad + " y su habitad es de " + habitad + "se baña en el lodo";
    }

    public static void main(String[] args) {
        Animales animalPorDefecto = new Animales();
        Animales aguila = new Animales("felipe", "voladora", 20,"frio");
    }
}
