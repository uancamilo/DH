package presencial;

public class Persona {
    private String nombre;
    private Integer edad;

    public Persona(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public boolean esMayorDeEdad(){
        return edad>=18;
    }
    public boolean checkEdad(){
        //respuesta por defecto
        boolean respuesta=false;
        //proceso que podria cambiar la respuesta
        if (edad>=0&&edad<=120){
            respuesta=true;
        }
        //salida de la respuesta
        return respuesta;
    }
    public boolean checkNombre4Letras(){
        return nombre.length()>4;
    }
    public boolean checkLetrasAZ(){
        boolean respuesta=false;
        //buscar la forma de pasar el string a un array de char
        char[] arrayDelNombre=nombre.toCharArray();
        for (char letra:arrayDelNombre) {
            if (!Character.isLetter(letra)){
                return respuesta;
            }
        }
        respuesta=true;
        return respuesta;
    }

}
