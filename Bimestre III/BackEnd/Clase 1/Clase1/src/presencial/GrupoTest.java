package presencial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrupoTest {
    @Test
    public void grupoDe2personas(){
        //DADO
        // van todos los datos iniciales
        Persona juan= new Persona("Juan",20);
        Persona pedro= new Persona("Pedro",21);
        Persona ana= new Persona("Ana",22);
        Persona luz= new Persona("Luz",23);
        Persona julian= new Persona("Julian",24);
        Grupo grupo= new Grupo();
        //CUANDO
        // el proceso a probar
        grupo.agregarPersona(juan);
        grupo.agregarPersona(pedro);
        grupo.agregarPersona(ana);
        grupo.agregarPersona(luz);
        grupo.agregarPersona(julian);
        //ENTONCES
        // la prueba lógica de que sea correcto
        //System.out.println("Test de prueba");
        Assertions.assertTrue(grupo.getPersonas().size()==2);
    }

}
