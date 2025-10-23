package PrincipalFunctions.Pedidos;

public class itemPedido {
    private String nombre;
    private double precioUnitario;
    private int cantidad;

    public itemPedido(String nombre, double precioUnitario, int cantidad) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }


    public String getNombre() {
        return nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void agregarCantidad(int cantidadExtra) {
        this.cantidad += cantidadExtra;
    }

    public double getSubtotal() {
        return precioUnitario * cantidad;
    }

    @Override
    public String toString() {
        return nombre + " | $" + precioUnitario + " x " + cantidad + " = $" + getSubtotal();
    }
}