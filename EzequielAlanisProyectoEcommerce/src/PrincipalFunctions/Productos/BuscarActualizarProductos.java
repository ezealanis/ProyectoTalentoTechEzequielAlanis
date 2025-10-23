package PrincipalFunctions.Productos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import PrincipalFunctions.TextStyle;

import static PrincipalFunctions.Productos.Productos.producto;

public class BuscarActualizarProductos {

    static Scanner input = new Scanner(System.in);

    public static void BuscarProducto() {
        try {
            System.out.println("Seleccione por qué método desea buscar un producto:");
            System.out.println("""
                    1. Buscar por Nombre.
                    2. Buscar por ID.
                    """);
            System.out.print("Ingrese la opción: ");
            int opcion = input.nextInt();

            input.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> BuscarPorNombre();
                case 2 -> BuscarPorId();
                default -> System.out.println("Opción inválida.");
            }

        } catch (InputMismatchException e) {
            System.out.println("⚠ Error: Debe ingresar un número.");
            input.nextLine(); // limpiar buffer
        }
    }

    public static void BuscarPorNombre() {
        System.out.print("Ingrese el nombre que desea buscar: ");
        String nombre = input.nextLine();

        ArrayList<Integer> coincidencia = new ArrayList<>();
        String nombreBuscado = TextStyle.formatearNombreProducto(nombre);

        for (int i = 0; i < producto.size(); i++) {
            Productos p = producto.get(i);
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
            BuscarConjuntoPorId(coincidencia);
        } else {
            System.out.println("Se encontró 1 resultado.");
            System.out.print("¿Querés modificar el producto? (s/n): ");
            String selection = input.nextLine().trim().toLowerCase();

            if (selection.equals("s") || selection.equals("si")) {
                ModificarProducto(coincidencia.get(0));
            } else {
                System.out.println("Cancelando operación.");
            }
        }
    }

    public static void BuscarConjuntoPorId(ArrayList<Integer> coincidencia) {
        try {
            System.out.print("Ingresa el ID del producto que deseas modificar: ");
            int IdIngreso = input.nextInt();

            input.nextLine(); // limpiar buffer

            int index = IdIngreso - 1;

            if (coincidencia.contains(index)) {
                Productos p = producto.get(index);
                System.out.println("Seleccionaste el producto: " + p.getNombre());
                System.out.print("¿Querés modificar el producto? (s/n): ");
                String selec = input.nextLine().trim().toLowerCase();

                if (selec.equals("s") || selec.equals("si")) {
                    ModificarProducto(index);
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

    public static void BuscarPorId() {
        try {
            System.out.print("Elige el ID del producto que deseas modificar: ");
            int position = input.nextInt();
            input.nextLine(); // limpiar buffer

            if (position > 0 && position <= producto.size()) {
                Productos p = producto.get(position - 1);
                System.out.println("Seleccionaste: " + p.getNombre());
                System.out.print("¿Querés modificar este producto? (s/n): ");
                String confirm = input.nextLine().trim().toLowerCase();

                if (confirm.equals("s") || confirm.equals("si")) {
                    ModificarProducto(position - 1);
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

    public static void ModificarProducto(int index) {
        Productos p = producto.get(index);

        System.out.println("Modificando producto: " + p.getNombre());

        System.out.print("Nuevo nombre (ENTER para mantener): ");
        String nuevoNombre = input.nextLine().trim();

        ;
        if (!nuevoNombre.isBlank() && validarNombre(nuevoNombre)){
                p.setNombre(TextStyle.formatearNombreProducto(nuevoNombre));
        }

        System.out.print("Ingrese el nuevo precio (ENTER para mantener): ");
        String Precio = input.nextLine().trim();
        if (!Precio.isEmpty()) {
            try {
                double nuevoPrecio = Double.parseDouble(Precio);
                if (nuevoPrecio >= 0) {
                    p.setPrecio(nuevoPrecio);
                } else {
                    System.out.println("⚠ El precio no puede ser menor a 0. Se mantiene el valor anterior.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠ Entrada inválida. Se mantiene el precio anterior.");
            }
        }

        System.out.print("Ingrese el nuevo stock (ENTER para mantener): ");
        String Stock = input.nextLine().trim();
        if (!Stock.isEmpty()) {
            try {
                int nuevoStock = Integer.parseInt(Stock);
                if (nuevoStock >= 0) {
                    p.setStock(nuevoStock);
                } else {
                    System.out.println("⚠ El stock no puede ser menor a 0. Se mantiene el valor anterior.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠ Entrada inválida. Se mantiene el stock anterior.");
            }
        }

        System.out.println("✅ Producto actualizado correctamente.");
    }

    public static boolean validarNombre(String nuevoNombre){
        //Evito cargar campo nombre vacio
        if(nuevoNombre.isEmpty()){
            System.out.println("No se puede cargar un producto vacio");
            return false;
        }
        //Evito cargar numeros en string
        if (nuevoNombre.matches(".*\\d.*")) {
            System.out.println("⚠ El nombre del producto no puede contener números.");
            return false;
        }

        //Evito carga de nombre duplicado
        for (Productos p : producto) {
            if (p.getNombre().equalsIgnoreCase(nuevoNombre)) {
                System.out.println("⚠ El producto ya existe.");
                return false;
            }
        }

        return true;

    }
}