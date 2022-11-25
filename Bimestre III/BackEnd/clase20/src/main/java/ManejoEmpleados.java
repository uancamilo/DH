import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

public class ManejoEmpleados {
    public static void guardarEmpleadorTxt(List<Empleado> empleados) {
        FileOutputStream fos = null;
        try {
            //Instacia
            fos = new FileOutputStream("empleado.txt");
            //Buffer
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            // Metodos de bos

            //Recorrer la lista
            for(Empleado empleado: empleados){
                //Linea para escribir

                String linea = empleado.getNombre()+";"+empleado.getApellido()+";"+empleado.getLegajo()+";"+empleado.getSueldo()+"\n";
                bos.write(linea.getBytes());
            }
            bos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class Empresa {

    }
}
