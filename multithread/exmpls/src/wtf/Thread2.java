package wtf;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Thread2 extends Thread {

    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(5);
        for(int i = 1; i <= 7; i++)
        new Thread2(Integer.toString(i),semaphore).start();
    }

    public Thread2(String string, Semaphore semaphore) {
        this.string = string;
        this.semaphore = semaphore;
    }

    String string;
    Semaphore  semaphore;
    @Override
    public void run() {
        try {
            semaphore.acquire();
            if(!semaphore.tryAcquire(3000, TimeUnit.MILLISECONDS)) {
                System.out.println("Client " + string + " timeout");
                this.interrupt();
            }
            else{
                System.out.println("Client " + string + " get connection");
            }
            semaphore.release();
            System.out.println("Client " + string + " relesed connection");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
