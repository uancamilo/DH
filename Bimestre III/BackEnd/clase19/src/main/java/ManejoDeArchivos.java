import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ManejoDeArchivos {

    public static void guardarArchivos(List<Contacto> personas){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("personas.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(personas);
            oos.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static  List<Contacto> recuperacionArchivo(){
        FileInputStream fis = null;
        List<Contacto> respuesta = null ;
        try {
            fis = new FileInputStream("personas.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            respuesta = (ArrayList)ois.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return respuesta;
    }
}
