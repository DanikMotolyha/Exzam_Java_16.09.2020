package sem;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Thread2 extends Thread {

    public static void main(String[] args) {
        Semaphore semaphore1=new Semaphore(5);
        for(int i = 1; i <= 7; i++)
            new Thread2(Integer.toString(i),semaphore1).start();
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
            if(semaphore.availablePermits() == 0){
                if(!semaphore.tryAcquire(3000, TimeUnit.MILLISECONDS)) {
                    System.out.println("Client " + string + " timeout");
                    this.interrupt();
                }
                else{
                    System.out.println("Client " + string + " get connection");
                    Thread.sleep(new Random().nextInt(4000) + 1500);
                    semaphore.release();
                    System.out.println("Client " + string + " relesed connection");
                }
            }
            else {
                semaphore.acquire();
                System.out.println("Client " + string + " get connection");
                Thread.sleep(new Random().nextInt(4000) + 1500);
                semaphore.release();
                System.out.println("Client " + string + " relesed connection");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
