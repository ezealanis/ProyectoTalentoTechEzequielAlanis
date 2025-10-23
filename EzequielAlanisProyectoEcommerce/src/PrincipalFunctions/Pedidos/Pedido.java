package PrincipalFunctions.Pedidos;

import PrincipalFunctions.Productos.Productos;
import PrincipalFunctions.StockInsuficiente;

import java.util.ArrayList;
import java.util.Scanner;

public class Pedido {
    static Scanner input = new Scanner(System.in);

    private ArrayList<itemPedido> pedido = new ArrayList<>();
    private static ArrayList<Pedido> listaPedidos = new ArrayList<>();

    public double getTotal() {
        double total = 0;
        for (itemPedido item : pedido) {
            total += item.getSubtotal();
        }
        return total;
    }


    public static void EjecutarPedido() {
        boolean continuar = true;
        Pedido nuevoPedido = new Pedido();

        do {
            System.out.println("¿Qué producto desea cargar al pedido?");
            Productos.listar();
            System.out.print("Ingrese el ID del producto(0 para salir): ");
            int id = input.nextInt();

            if(id==0){
                if(nuevoPedido.pedido.isEmpty()){
                    System.out.println("No se cargó ningún producto. Cancelando pedido.");
                    return;
                }else{
                    continuar=false;
                    break;
                }
            }

            if (id <= 0 || id > Productos.producto.size()) {
                System.out.println("ID inválido.");
                continue;
            }

            Productos producto = Productos.producto.get(id - 1);

            if(producto.getStock()==0){
                System.out.println("⚠ El producto seleccionado no tiene stock disponible.");
                continue;
            }

            System.out.print("Ingrese la cantidad: ");
            int cantidad = input.nextInt();


        try{

            if (cantidad > producto.getStock()) {
                throw new StockInsuficiente("Stock Insuficiente para "+producto.getNombre());
            }


            boolean encontrado = false;

            for (itemPedido item : nuevoPedido.pedido) {
                if (item.getNombre().equalsIgnoreCase(producto.getNombre())) {
                    item.agregarCantidad(cantidad);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                nuevoPedido.pedido.add(new itemPedido(producto.getNombre(),producto.getPrecio(),cantidad));
            }

            producto.setStock(producto.getStock() - cantidad);
            System.out.println(" ");
            System.out.println("¿Desea agregar otro producto? (s/n): ");
            String rta = input.next().trim().toLowerCase();
            continuar = rta.equals("s");

        } catch (StockInsuficiente e){
            System.out.println("⚠ " + e.getMessage());
        }


        } while (continuar);

        listaPedidos.add(nuevoPedido);
        System.out.println(" Pedido cargado con éxito ✅ ");

    }

    public static void listarPedidos() {
        if (listaPedidos.isEmpty()) {
            System.out.println("⚠️ No hay pedidos registrados aún.");
            return;
        }

        System.out.println("""
        ******************************
        |      LISTA DE PEDIDOS      |
        ******************************
        """);
        int numPedido = 1;

        for (Pedido pedido : listaPedidos) {
            System.out.println("🧾 Pedido #" + numPedido ++);
            for (itemPedido item : pedido.pedido) {
                System.out.println(" - " + item.getNombre() + " | $" + item.getPrecioUnitario() +
                        " * " + item.getCantidad() + " = $" + item.getSubtotal());
            }
            System.out.println("➡ TOTAL DEL PEDIDO: $" + pedido.getTotal());
            System.out.println("------------------------------------");
            System.out.println(" ");
        }
    }
}
