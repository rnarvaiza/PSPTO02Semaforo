/**
 * @author Rafael Narvaiza
 * PSP - TO 02
 *
 */


public class Main {
    public static void main(String[] args) {
        Coleccion c = new Coleccion(3);
        Escritor escritor = new Escritor(c, 10);
        Lector lector = new Lector(c, 10);
        Lector lector1 = new Lector(c, 10);
        escritor.start();
        lector.start();
        lector1.start();
    }
}
