package Semaphore;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for(int i = 0; i < 7; i++){
            new Thread(new Philosoph(i, semaphore)).start();
        }

    }
}
class Philosoph implements Runnable{
private int id;
private Semaphore semaphore;

    public Philosoph(int id, Semaphore semaphore) {
        this.id = id;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
        Thread.sleep(500);
        System.out.println(id + " talk");

            Thread.sleep(500);
            System.out.println(id + " stop talk");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
    }
}

