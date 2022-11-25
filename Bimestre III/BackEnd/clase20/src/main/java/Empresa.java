import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Empresa implements Serializable {
    private Integer nit;
    private String razonSocial;
    private List<Empleado> empleados;

    public Empresa(Integer nit, String razonSocial) {
        this.nit = nit;
        this.razonSocial = razonSocial;
        empleados = new ArrayList<>();
    }

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nit=" + nit +
                ", razonSocial='" + razonSocial + '\'' +
                ", empleados=" + empleados +
                '}';
    }

    public void agregarEmpleados(Empleado empleado) {
        empleados.add(empleado);
    }
}
