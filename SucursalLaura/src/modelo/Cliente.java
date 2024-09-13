package modelo;

import java.util.ArrayList;

import Herramientas.Utilidades;

public class Cliente {
    private String nombre;
    private String apellido;
    private int dni;
    private ArrayList<Cuenta> cuentas;

    public Cliente(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        cuentas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getDni() {
        return dni;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    // METODO PARA CREAR UNA CUENTA
    private Cuenta crearCuenta() {
        int numCuenta = Utilidades.leerEntero("NUMERO DE CUENTA DEL CLIENTE: ");
        int idCuenta = Utilidades.leerEntero("ID CUENTA DEL CLIENTE: ");

        Cuenta cuenta = new Cuenta(numCuenta, idCuenta);
        return cuenta;
    }

    // METODO PARA COMPROBAR UNA CUENTA
    private Cuenta comprobarCuenta(Cuenta cuenta) {
        for (Cuenta cuentaDentro : cuentas) {
            if (cuentaDentro.getIdCuenta() == cuenta.getIdCuenta()) {
                return cuentaDentro;
            }
        }
        return null;
    }

    public void altaCuenta() {
        System.out.println("ALTA CUENTA");
        Cuenta cuenta = crearCuenta();
        Cuenta cuenta1 = comprobarCuenta(cuenta);

        if (cuenta1 != null) {
            System.out.println("La cuenta no se puede dar de ALTA porque ya existe");
        } else {
            cuentas.add(cuenta);
            System.out.println("La cuenta se ha dado de ALTA correctamente");
        }
    }

    public void bajaCuenta() {
        System.out.println("BAJA CUENTA");
        Cuenta cuenta = crearCuenta();
        Cuenta cuenta1 = comprobarCuenta(cuenta);

        if (cuenta1 == null) {
            System.out.println("La cuenta no se puede dar de BAJA porque no existe");
        } else {
            cuentas.remove(cuenta1);
            System.out.println("La cuenta se ha dado de BAJA correctamente");
        }
    }

    public void ingresarDinero() {
        Cuenta cuenta = crearCuenta();
        Cuenta cuenta1 = comprobarCuenta(cuenta);
        if (cuenta1 == null) {
            System.out.println("La cuenta no existe.");
        } else {
            // CREAR VARIABLE PARA INGRESAR UNA CANTIDAD
            // METODO EN CUENTA1 PARA DEPOSITAR DINERO
            float cantidad = Utilidades.leerFloat("CANTIDAD A INGRESAR");
            cuenta1.depositar(cantidad);
            System.out.println("Dinero añadido correctamente, el saldo actual es: " + cuenta1.getCantidad());
        }
    }

    public void sacarDinero() {
        Cuenta cuenta = crearCuenta();
        Cuenta cuentaDentro = comprobarCuenta(cuenta);

        Cuenta cuenta1 = comprobarCuenta(cuenta);
        if (cuenta == null) {
            System.out.println("La cuenta no existe.");
        } else {
            float cantidad = Utilidades.leerFloat("CANTIDAD A SACAR");
            cuenta1.sacarDinero(cantidad);
        }
    }

    public void verDinero() {
        Cuenta cuenta = crearCuenta();
        Cuenta cuentaDentro = comprobarCuenta(cuenta);

        Cuenta cuenta1 = comprobarCuenta(cuenta);
        if (cuenta == null) {
            System.out.println("La cuenta del cliente no existe.");
        } else {
            cuenta1.getCantidad();
            System.out.println("La cantidad en la cuenta del cliente es: " + cuenta1.getCantidad());

        }

    }

    public Float cantidadTotal() {
        float cantidadTotal = 0;
        for (Cuenta cuenta : cuentas) {
            cantidadTotal += cuenta.getCantidad();
        }
        return cantidadTotal();
    }
}

/*
 * public void datosClienteConCantidadTotal() {
 * 
 * if (cuentas.size() == 0) {
 * System.out.println("La cuenta de " + nombre +
 * " no tiene clientes inscritos");
 * } else {
 * Collections.sort(cuentas, Comparator.comparingInt(cuenta ->
 * cuenta.getcantidadTotal()));
 * cuentas.get(cuentas.size() - 1).escribirDatos();
 * }
 * }
 */
