

public class Cuenta {

    private String numero; // Guarda el numero de la cuenta bancaria
    private double saldo; // Guarda el dinero disponible en la cuenta

    public Cuenta(String numero, double saldo) {
        this.numero = numero; // Guardamos el numero de cuenta recibido
        this.saldo = saldo; // Guardamos el saldo inicial recibido
    }

    public synchronized double getSaldo() {
        return saldo; // Devolvemos el saldo actual de la cuenta
    }

    public synchronized void ingresaCantidad(double cantidad) {
        saldo += cantidad; // Añadimos la cantidad indicada al saldo
    }

    public synchronized void sacarCantidad(double cantidad) {
        saldo -= cantidad; // Restamos la cantidad indicada del saldo
    }

    public String getNumeroCuenta() {
        return numero; // Devolvemos el número de la cuenta
    }

    public synchronized String toString() {
        return "Cuenta: " + numero + " Saldo: " + saldo; // Mostramos el número de cuenta y su saldo
    }
}
