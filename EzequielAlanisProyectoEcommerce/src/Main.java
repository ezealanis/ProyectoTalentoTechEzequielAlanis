import PrincipalFunctions.MenuPrincipal;
import PrincipalFunctions.Pedidos.Pedido;
import PrincipalFunctions.Productos.EliminarProductos;
import PrincipalFunctions.Productos.Productos;
import PrincipalFunctions.Productos.BuscarActualizarProductos;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args){

        Scanner input=new Scanner(System.in);
        boolean eleccion=true;

        MenuPrincipal.saludo();

        while(eleccion){

            MenuPrincipal.menu();
            System.out.print("Ingrese una opcion:");

            try{
                int opcion = input.nextInt();
                switch (opcion) {
                    case 1 -> Productos.alta();
                    case 2 -> Productos.listar();
                    case 3 -> BuscarActualizarProductos.BuscarProducto();
                    case 4 -> EliminarProductos.BajaDeProducto();
                    case 5 -> Pedido.EjecutarPedido();
                    case 6 -> Pedido.listarPedidos();
                    case 7->{
                        MenuPrincipal.goodby();
                        eleccion=false;
                    }
                    default -> System.out.println("Opcion Invalida,Digite un numero del 1-7.");
                }
            }catch(InputMismatchException e){
                    System.out.println("⚠ Error: Debe ingresar un número.");
                    input.nextLine();
                }

            //Limpio el Buffer
            input.nextLine();

            }

        }

    }