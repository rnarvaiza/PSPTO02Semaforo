/**
 * @author Rafael Narvaiza
 * PSP - TO 02
 *
 */

import java.util.Random;

public class Escritor extends Thread{

    private Random r = new Random();
    private Coleccion c;
    private int size;

    public Escritor(Coleccion c, int size){
        this.c = c;
        this.size = size;
    }


    @Override
    public void run(){
        for(int i =0; i<size; i++){
            int aux = r.nextInt(1000);
            try {
                c.insertData(aux);
                System.out.println("\u001B[31m" +"Escritor intenta escribir: " +"\u001B[0m" + aux);
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
