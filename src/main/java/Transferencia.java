
import java.util.concurrent.CountDownLatch;

public class Transferencia {

    private Cuenta c1;
    private Cuenta c2;

    // CountDownLatch sirve para que los dos hilos bloqueen primero sus cuentas
    private static CountDownLatch espera = new CountDownLatch(2);

    public Transferencia(Cuenta c1, Cuenta c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public static boolean transferencia(Cuenta c1, Cuenta c2, int cantidad) {

        synchronized (c1) {                         // Bloqueamos la primera cuenta

            espera.countDown();                     // Avisamos de que ya tenemos la cuenta bloqueada

            try {
                espera.await();                     // Esperamos a que el otro hilo bloquee su cuenta
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }

            synchronized (c2) {                     // Intentamos bloquear la segunda cuenta

                if (c1.getSaldo() >= cantidad) {

                    c1.sacarCantidad(cantidad);     // Sacamos dinero
                    c2.ingresaCantidad(cantidad);   // Ingresamos dinero

                    return true;
                }
            }
        }
        return false;
    }
}
