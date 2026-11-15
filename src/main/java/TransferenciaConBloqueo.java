
public class TransferenciaConBloqueo {

    public static void main(String[] args) {

        // Creamos las dos cuentas
        Cuenta c1 = new Cuenta("ES388388433883838388484", 20500);
        Cuenta c2 = new Cuenta("ES99090499388484889399", 50000);

        // Mostramos los saldos iniciales
        System.out.println("SALDOS INICIALES");
        System.out.println(c1);
        System.out.println(c2);

        // Creamos los dos hilos con las cuentas en orden contrario
        Hilo h1 = new Hilo("Jesus Cantero", c1, c2);
        Hilo h2 = new Hilo("Cantero Jesus", c2, c1);

        // Los hacemos daemon para poder finalizar el programa
        h1.setDaemon(true);
        h2.setDaemon(true);

        // Iniciamos los hilos
        h1.start();
        h2.start();

        try {
            // Esperamos 3 segundos a que terminen
            h1.join(3000);
            h2.join(3000);

        } catch (InterruptedException e) {
            System.out.println("Error al esperar los hilos");
        }

        // Comprobamos si los hilos siguen bloqueados
        if (h1.isAlive() && h2.isAlive()) {
            System.out.println("\n¡SE HA PRODUCIDO UN INTERBLOQUEO!");
            System.out.println(h1.getName() + " espera la cuenta de " + h2.getName());
            System.out.println(h2.getName() + " espera la cuenta de " + h1.getName());
        }
    }
}