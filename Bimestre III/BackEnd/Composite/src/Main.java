public class Main {
    public static void main(String[] args) {

        Producto hamburguesa = new Producto("Hamburguesa", 8.5);
        Producto papasFritas = new Producto("Papas Fritas", 2.5);
        Producto gaseosa = new Producto("Coca Cola", 3.0);

        Combo combo1 = new Combo(0.1);
        combo1.agregarComprable(hamburguesa);
        combo1.agregarComprable(papasFritas);
        combo1.agregarComprable(gaseosa);

        Carrito carrito = new Carrito();
        carrito.agregarComprable(combo1);
        System.out.println(carrito.calcularPrecioTotal());
    }
}