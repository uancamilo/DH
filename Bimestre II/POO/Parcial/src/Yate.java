public class Yate extends Embarcacion implements Comparable {

    private Integer cantidadCamarotes;

    public Yate(Capitan capitan, Double precioBase, Double valorAdicional, Integer anioFabricacion, Double eslora, Integer cantidadCamarotes) {
        super(capitan, precioBase, valorAdicional, anioFabricacion, eslora);
        this.cantidadCamarotes = cantidadCamarotes;
    }

    //comparable --->

    //casteo --->

    @Override
    public int compareTo(Object o) {

        Yate otroYate = (Yate) o;
        if (cantidadCamarotes > otroYate.cantidadCamarotes){
            return 1;
        }

        if (cantidadCamarotes > otroYate.cantidadCamarotes) {
            return -1;
        }
            return 0;
    }
}
