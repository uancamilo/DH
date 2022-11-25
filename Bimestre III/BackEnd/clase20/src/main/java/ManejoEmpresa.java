import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ManejoEmpresa {
    public static void guardarEmpresa(Empresa empresa) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("empresa.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(empresa);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Empresa recuperarEmpresa() {
        FileInputStream fis = null;
        Empresa respuesta = null;

        try {
            fis = new FileInputStream("empresa.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            respuesta = (Empresa)  ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }
}
