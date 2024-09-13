import java.util.Scanner;

import modelo.Sucursal;

public class App {

    public static Sucursal sucursal = new Sucursal();

    public static void main(String[] args) throws Exception {
        Boolean salir = false;
        while (!salir) {
            salir = menuPrincipal();
        }
    }

    private static Boolean menuPrincipal() {
        Boolean salir = false;

        System.out.println("##############################");
        System.out.println("##### MENU PRINCIPAL #########");
        System.out.println("##############################");
        System.out.println("1 Alta Cliente");
        System.out.println("2 Baja Cliente");
        System.out.println("3 Alta Cuenta");
        System.out.println("4 Baja Cuenta");
        System.out.println("5 Ingresar Dinero");
        System.out.println("6 Sacar Dinero");
        System.out.println("7 Ver Dinero");
        System.out.println("8 Listar Clientes con Cantidad Total en la Cuenta");
        System.out.println("9 Salir");

        Scanner scanner = new Scanner(System.in);
        String opcion = scanner.nextLine();

        switch (opcion) {
            case "1":
                sucursal.altaCliente();
                break;
            case "2":
                sucursal.bajaCliente();
                break;
            case "3":
                sucursal.altaCuenta();
                break;
            case "4":
                sucursal.bajaCuenta();
                break;
            case "5":
                sucursal.ingresarDinero();

                break;
            case "6":
                sucursal.sacarDinero();
                break;
            case "7":
                sucursal.verDinero();
                break;
            case "8":
                sucursal.listarClientes();
                break;
            case "9":
                System.out.println("Saliendo...");
                salir = true;

                break;

            default:
                break;
        }
        return salir;

    }
}
