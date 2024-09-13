package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Herramientas.Utilidades;

public class Sucursal {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    // METODO PARA CREAR A UN CLIENTE
    private Cliente crearCliente() {

        String nombre = Utilidades.leerString("NOMBRE DEL CLIENTE: ");
        String apellido = Utilidades.leerString("APELLIDO DEL CLIENTE: ");
        int idCliente = Utilidades.leerEntero("ID DEL CLIENTE: ");
        Cliente cliente = new Cliente(nombre, apellido, idCliente);
        return cliente;
    }

    // METODO PARA COMPROBAR EL CLIENTE
    private Cliente comprobarCliente(Cliente cliente) {
        for (Cliente clienteDentro : clientes) {
            if (clienteDentro.getDni() == cliente.getDni()) {
                return clienteDentro;
            }
        }
        return null;
    }

    public void altaCliente() {
        System.out.println("ALTA CLIENTE");
        Cliente cliente = crearCliente();
        Cliente clienteDentro = comprobarCliente(cliente);

        if (clienteDentro != null) {
            System.out.println("El cliente ya existe, no se puede dar de ALTA");
        } else {
            clientes.add(cliente);
            System.out.println("El cliente se ha dado de ALTA correctamente");
        }
    }

    public void bajaCliente() {
        System.out.println("BAJA CLIENTE");
        Cliente cliente = crearCliente();
        Cliente clienteDentro = comprobarCliente(cliente);

        if (clienteDentro == null) {
            System.out.println("El cliente NO existe, no se puede dar de BAJA");
        } else {
            clientes.remove(clienteDentro);
            System.out.println("El cliente se ha dado de BAJA correctamente");
        }

    }

    public void altaCuenta() {
        System.out.println("ALTA CUENTA");
        Cliente cliente = crearCliente();
        Cliente clienteDentro = comprobarCliente(cliente);

        if (clienteDentro == null) {
            System.out.println("El cliente no existe, no se puede dar de ALTA una cuenta");
        } else {
            clienteDentro.altaCuenta();
        }
    }

    public void bajaCuenta() {
        System.out.println("BAJA CUENTA");
        Cliente cliente = crearCliente();
        Cliente clienteDentro = comprobarCliente(cliente);

        if (clienteDentro == null) {
            System.out.println("El cliente no existe, no se puede dar de ALTA una cuenta");
        } else {
            clienteDentro.bajaCuenta();
        }
    }

    public void ingresarDinero() {
        Cliente cliente = crearCliente();
        Cliente clienteDentro = comprobarCliente(cliente);

        if (clienteDentro == null) {
            System.out.println("El cliente no existe, no se puede dar de ALTA una cuenta");
        } else {
            clienteDentro.ingresarDinero();
        }
    }

    public void sacarDinero() {
        Cliente cliente = crearCliente();
        Cliente clienteDentro = comprobarCliente(cliente);

        if (clienteDentro == null) {
            System.out.println("El cliente no existe, no se puede dar de ALTA una cuenta");
        } else {
            clienteDentro.sacarDinero();
        }
    }

    public void verDinero() {
        Cliente cliente = crearCliente();
        Cliente clienteDentro = comprobarCliente(cliente);

        if (clienteDentro == null) {
            System.out.println("El cliente no existe, no se puede dar de ALTA una cuenta");
        } else {
            clienteDentro.verDinero();
        }
    }

    /*
     * METODO PARA ORDENAR LOS CLIENTES Y DAR LA LISTA CON SUS DATOS Y LA CANTIDAD
     * TOTAL
     */
    // LISTAR CLIENTES ORDENADOS DE MAS A MENOS EFECTIVO TOTAL.
    public void listarClientes() {

        Collections.sort(clientes, new Comparator<Cliente>() {

            @Override
            public int compare(Cliente cliente1, Cliente cliente2) {
                return cliente2.cantidadTotal().compareTo(cliente1.cantidadTotal());
            }

        });

        for (Cliente cliente : clientes) {
            System.out.println("Nombre: " + cliente.getNombre() + " Apellido: " + cliente.getApellido() + " Dni: "
                    + cliente.getDni() + " Cantidad total: " + cliente.cantidadTotal());
        }
        // for (Cliente cliente : clientes) {
        // cliente.datosClienteConCantidadTotal();
    }
}
