package tofile;

public class Check {
    private volatile int pr=0;

    public Check(int pr) {
        this.pr = pr;
    }

    public static void main(String[] args) throws InterruptedException {
        Check check = new Check(0);
        Thread t1 =  new Thread(new FileRead(check));
        Thread t2 = new Thread(new FileRead(check));
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(check.getPr());


    }
    public synchronized void incr() throws InterruptedException {
        pr++;


    }

    public int getPr() {
        return pr;
    }
}

