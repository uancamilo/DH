import java.util.ArrayList;
import java.util.List;

public class Lista {
    public static void main(String[] args){

        List<Contacto> listaContactos = new ArrayList<>();

        listaContactos.add(new Contacto("Juan", "Serna", "uancamilo@gmail.com","3013111071"));

        ManejoDeArchivos.guardarArchivos(listaContactos);

        List<Contacto> contactosRecuperados = ManejoDeArchivos.recuperacionArchivo();

        for (Contacto contacto: contactosRecuperados){
            System.out.println(contacto);
        }

    }
}
