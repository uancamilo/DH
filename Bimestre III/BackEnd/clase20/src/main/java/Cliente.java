import java.util.ArrayList;
import java.util.List;

public class Cliente {

    public static void main(String[] args){
        List<Empleado> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(new Empleado("Juan", "Serna", 122410, 560.80));

        ManejoEmpleados.guardarEmpleadorTxt(listaEmpleados);

        Empresa empresa=new Empresa(90544815,"Industrias Pepito S.A.");
        empresa.agregarEmpleados(new Empleado("Juan","Rodriguez",115456,560.0));
        ManejoEmpresa.guardarEmpresa(empresa);

        Empresa recuperarEmpresa = ManejoEmpresa.recuperarEmpresa();
        System.out.println(recuperarEmpresa);
    }
}
