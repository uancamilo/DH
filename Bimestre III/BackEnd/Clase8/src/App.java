import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class App {

    private static final Logger logger = Logger.getLogger((App.class));

    private List<Integer> listaEnteros;

    public  App() {
        listaEnteros = new ArrayList<>();
    }

    public void  agregarEntero(Integer numero){
        listaEnteros.add(numero);
        if(listaEnteros.size()>5) {
            logger.info("La lista de enteros tiene mas de 5 elementos. " + listaEnteros.size());
        }
    }

    public void agregarOtroEntero (Integer numero) {
        listaEnteros.add(numero);
        if (listaEnteros.size()>10) {
            logger.info("lista con enteros mayores a 10. " + listaEnteros.size());
        }
    }
}
