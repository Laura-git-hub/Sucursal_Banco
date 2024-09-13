package modelo;

public class Cuenta {
    private int numCuenta;
    private int idCuenta;
    private float cantidad;

    public Cuenta(int numCuenta, int idCuenta) {
        this.numCuenta = numCuenta;
        this.idCuenta = idCuenta;
        cantidad = 0;

    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public float getCantidad() {
        return cantidad;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    // meterCantidad es la cantidad que hemos ingresado
    // va a aumentar la variable cantidad que guarda el dinero ingresado.
    public void depositar(Float meterCantidad) {
        cantidad += meterCantidad; // meterCantidad aumenta la variable cantidad.
    }

    public void sacarDinero(float cantidadSacar) {
        if (cantidadSacar > cantidad) {
            System.out.println("Lo siento no tienes fondos suficientes");
        } else {
            cantidad -= cantidadSacar; // cantidadSacar resta la cantidad que tenemos en la variable cantidad.
            System.out.println("Dinero sacado correctamente");
        }
    }

    /*
     * public int getcantidadTotal() {
     * ArrayList<Cuenta> cuentas = new ArrayList<>();
     * int cantidadTotal = 0;
     * for (Cuenta cuenta : cuentas) {
     * cantidadTotal += cuenta.getCantidad();
     * }
     * return cantidadTotal;
     * }
     */

    public void escribirDatos() {
        System.out.println("Numero de cuenta: " + numCuenta);
        System.out.println("ID cuenta: " + idCuenta);
        System.out.println("Cantidad Total: " + cantidad);

    }
}
