package tofile;


public class FileRead implements Runnable{
private Check check;

    public FileRead(Check check) {
        this.check = check;
    }

    @Override
    public  void run() {
for(int i = 0; i<10000;i++){
    try {
        check.incr();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

    }
}
