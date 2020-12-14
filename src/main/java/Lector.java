/**
 * @author Rafael Narvaiza
 * PSP - TO 02
 *
 */

import java.util.Random;

public class Lector extends Thread {

    private Coleccion c;
    private int size;
    private Random r = new Random();

    public Lector(Coleccion c, int size){
        this.c = c;
        this.size = size;
    }


    @Override
    public void run(){
        for (int i= 0; i<size; i++){
            int aux = 0;
            try {
                String nombreLector=Thread.currentThread().getName();
                aux = c.extractData(nombreLector);
                System.out.println("\u001B[32m" + "Lector: " + nombreLector +" intenta leer : " + "\u001B[0m" + aux);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            try{
                Thread.sleep(r.nextInt(2000));
            } catch (InterruptedException e){
                System.out.println(e.getMessage());
            }

        }
    }
}
