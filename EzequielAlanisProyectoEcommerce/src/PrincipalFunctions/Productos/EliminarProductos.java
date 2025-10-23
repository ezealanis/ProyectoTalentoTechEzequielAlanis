package PrincipalFunctions.Productos;

import PrincipalFunctions.TextStyle;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EliminarProductos {
    static Scanner input = new Scanner(System.in);


    public static void BajaDeProducto(){

        try{
            System.out.println("Seleccione por qué método desea buscar un producto:");
            System.out.println("""
                    1. Buscar por Nombre.
                    2. Buscar por ID.
                    """);
            System.out.print("Ingrese la opción: ");
            int opcion = input.nextInt();
            input.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> BuscarEliminarPorNombre();
                case 2 -> BuscarEliminarPorId();
                default -> System.out.println("Opción inválida.");
            }

        }catch (InputMismatchException e){
            System.out.println("⚠ Error: Debe ingresar un número.");
            input.nextLine(); // limpiar buffer
        }
    }

    public static void BuscarEliminarPorNombre() {
        System.out.print("Ingrese el nombre del producto que desea buscar: ");
        String nombre = input.nextLine().trim();

        ArrayList<Integer> coincidencia = new ArrayList<>();
        String nombreBuscado = TextStyle.formatearNombreProducto(nombre);

        for (int i = 0; i < Productos.producto.size(); i++) {
            Productos p = Productos.producto.get(i);
            if (p.getNombre().contains(nombreBuscado)) {
                coincidencia.add(i);
                System.out.println("ID: " + (i + 1) +
                        " | Nombre: " + p.getNombre() +
                        " | Precio: " + p.getPrecio() +
                        " | Stock: " + p.getStock());
            }
        }

        if (coincidencia.isEmpty()) {
            System.out.println("⚠ No se encontró ningún producto con ese nombre.");
        } else if (coincidencia.size() > 1) {
            System.out.println("Se encontraron " + coincidencia.size() + " resultados.");
            EliminarConjuntoPorId(coincidencia);
        } else {
            System.out.println("Se encontró 1 resultado.");
            System.out.print("¿Querés Eliminar el producto? (s/n): ");
            String selection = input.nextLine().trim().toLowerCase();

            if (selection.equals("s") || selection.equals("si")) {
                EliminarProducto(coincidencia.get(0));
            } else {
                System.out.println("Cancelando operación.");
            }
        }
    }

    public static void EliminarConjuntoPorId(ArrayList<Integer> coincidencia) {
        try {
            System.out.print("Ingresa el ID del producto que deseas Eliminar: ");
            int IdIngreso = input.nextInt();
            input.nextLine(); // limpiar buffer

            int index = IdIngreso - 1;

            if (coincidencia.contains(index)) {
                Productos p = Productos.producto.get(index);
                System.out.println("Seleccionaste el producto: " + p.getNombre());
                System.out.print("¿Querés Eliminar el producto? (s/n): ");
                String selec = input.nextLine().trim().toLowerCase();

                if (selec.equals("s") || selec.equals("si")) {
                    EliminarProducto(index);
                } else {
                    System.out.println("Operación cancelada.");
                }
            } else {
                System.out.println("⚠ El ID ingresado no pertenece a los resultados mostrados.");
            }

        } catch (InputMismatchException e) {
            System.out.println("⚠ Error: Debe ingresar un número válido.");
            input.nextLine(); // limpiar buffer
        }
    }

    public static void BuscarEliminarPorId() {
        try {
            System.out.print("Elige el ID del producto que deseas Eliminar: ");
            int position = input.nextInt();
            input.nextLine(); // limpiar buffer

            if (position > 0 && position <= Productos.producto.size()) {
                Productos p = Productos.producto.get(position - 1);
                System.out.println("Seleccionaste: " + p.getNombre());
                System.out.print("¿Querés Eliminar este producto? (s/n): ");
                String confirm = input.nextLine().trim().toLowerCase();

                if (confirm.equals("s") || confirm.equals("si")) {
                    EliminarProducto(position - 1);
                } else {
                    System.out.println("Operación cancelada.");
                }
            } else {
                System.out.println("⚠ El ID ingresado no existe.");
            }

        } catch (InputMismatchException e) {
            System.out.println("⚠ Error: Debe ingresar un número válido.");
            input.nextLine(); // limpiar buffer
        }
    }


    public static void EliminarProducto(int index) {

        Productos.producto.remove(index);

        System.out.println("✅ El Producto fue Eliminado correctamente.");
    }
}
