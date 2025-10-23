package PrincipalFunctions;

public class MenuPrincipal {
    public static void saludo(){
        System.out.println("¡Bienvenido a la tienda!");
    }

    public static void menu(){
        System.out.println("""
                ************************************
                |        Menu Principal            |
                *----------------------------------*
                | 1.Agregar Producto               |
                | 2.Listar Productos               |
                | 3.Buscar o Actualizar Producto   |
                | 4.Eliminar Producto              |
                | 5.Realizar Pedido                |
                | 6.Listar Pedidos                 |
                | 7.Salir del Programa             |
                ************************************
                """);
    }

    public static void goodby(){
        System.out.println("¡Gracias por utilizar el sistema, Hasta luego!");

    }
}
