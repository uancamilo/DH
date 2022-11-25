package presencial;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private List<Persona> personas;

    public Grupo(){
        personas= new ArrayList<>();
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void agregarPersona(Persona persona){
        boolean checkMayoria=persona.esMayorDeEdad();
        boolean cantLetras= persona.checkNombre4Letras();
        boolean soloLetras= persona.checkLetrasAZ();
        boolean checkEdad= persona.checkEdad();

        if (checkMayoria&&cantLetras&&soloLetras&&checkEdad){
            personas.add(persona);
        }
        else{
            System.err.println("No se pudo agregar a la persona "+persona.getNombre());
        }
    }
}
