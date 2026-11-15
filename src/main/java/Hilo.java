

public class Hilo extends Thread {

    private Cuenta c1; // Guarda la cuenta desde la que se realiza la transferencia
    private Cuenta c2; // Guarda la cuenta que recibe el dinero

    public Hilo(String nombre, Cuenta c1, Cuenta c2) {
        super(nombre); // Asignamos un nombre al hilo
        this.c1 = c1; // Guardamos la primera cuenta
        this.c2 = c2; // Guardamos la segunda cuenta
    }

    public void run() { // Metodo que ejecuta el hilo al iniciarse

        for (int i = 0; i < 1000; i++) { // Repetimos las transferencias 1000 veces

            System.out.println(getName() + " intenta transferir 10 euros"); // Mostramos que hilo está realizando la transferencia

            Transferencia.transferencia(c1, c2, 10); // Llamamos al metodo que realiza la transferencia de 10 euros
        }

        System.out.println(getName() + " ha terminado"); // Indicamos que el hilo ha terminado
    }
}
