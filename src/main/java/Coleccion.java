/**
 * @author Rafael Narvaiza
 * PSP - TO 02
 *
 */

import java.util.concurrent.Semaphore;

public class Coleccion {

    private int[] buffer;
    private int escritorIndex = 0;
    private int lectorIndex = 0;
    private Semaphore semaforo = new Semaphore(1, true);
    private Semaphore checkData = new Semaphore(0, true);
    private Semaphore checkSpace;

    public Coleccion(int size){
        buffer = new int[size];
        checkSpace = new Semaphore(size, true);
    }

    public void insertData(int data) throws InterruptedException {
        System.out.println("Escritor: En disposición de escribir: ");
        checkSpace.acquire();
        semaforo.acquire();
        buffer[escritorIndex]=data;

        escritorIndex= (escritorIndex+1)%buffer.length;
        semaforo.release();
        checkData.release();
    }

    public int extractData(String nombreLector) throws InterruptedException {
        System.out.println("Lector: " + nombreLector + " En disposición de leer: ");
        checkData.acquire();
        semaforo.acquire();
        int now = lectorIndex;
        lectorIndex=(lectorIndex+1)%buffer.length;
        semaforo.release();
        checkSpace.release();
        return buffer[now];
    }
}
