package PrincipalFunctions.Productos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import PrincipalFunctions.TextStyle;


public class Productos {

    private String nombre;
    private Double precio;
    private Integer stock;

    public Productos(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    private static Scanner input = new Scanner(System.in);
    public static List<Productos> producto = new ArrayList<>();

    public static void alta() {
        try {

            System.out.println("Ingrese el producto que quiere agregar.");
            System.out.print("Nombre:");
            String Name = input.nextLine().trim().toLowerCase();

            if (validarNombre(Name)) {

                System.out.print("Precio:");
                double Precio = input.nextDouble();
                System.out.print("Stock:");
                int Stock = input.nextInt();

                //Le doy formato al nombre
                String Nombre = TextStyle.formatearNombreProducto(Name);
                //Limpio el buffer
                input.nextLine();

                Productos pro = new Productos(Nombre, Precio, Stock);
                producto.add(pro);
                System.out.println("Producto agregado correctamente.");
            }

        } catch (InputMismatchException e) {
            System.out.println("⚠ Error: Debe ingresar un valor valido.");
            //Limpio el buffer
            input.nextLine();
        }


    }

    public static void listar() {

        System.out.println("""
                **********************************
                |        Lista de Productos      |
                **********************************
                """);
        if (Productos.producto.isEmpty()) {
            System.out.println("|        La Lista esta vacia      |");
            System.out.println("**********************************");
        } else {
            for (int i = 0; i < producto.size(); i++) {
                System.out.println("|" + (i + 1) + ". " + producto.get(i) + "|");
                System.out.println("**********************************");
            }
        }

    }

    @Override
    public String toString() {
        String stockFinal;

        if (stock == 0) {
            stockFinal = "❌ Stock no disponible";
        } else {
            stockFinal = "Stock: " + stock;
        }

        return "Producto: " + nombre + " | Precio: $" + precio + " | " + stockFinal;

    }

    public static boolean validarNombre(String Name){
        //Evito cargar campo nombre vacio
        if (Name.isEmpty()) {
            System.out.println("No se puede cargar un producto vacio");
            return false;
        }
        //Evito cargar numeros en string
        if (Name.matches(".*\\d.*")) {
            System.out.println("⚠ El nombre del producto no puede contener números.");
            return false;
        }

        //Evito carga de nombre duplicado
        for (Productos p : producto) {
            if (p.getNombre().equalsIgnoreCase(Name)) {
                System.out.println("⚠ El producto ya existe.");
                return false;
            }
        }

        return true;
    }
}
