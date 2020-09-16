
import java.io.Closeable;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Bid extends Thread{

    private Integer bidId;
    private int price;
    private CyclicBarrier barrier;
    private Auction auction;

    public Bid(int id, int price, CyclicBarrier barrier, Auction auction) {
        this.bidId = id;
        this.price = price;
        this.barrier = barrier;
        this.auction = auction;
    }

    public Integer getBidId() {
        return bidId;
    }

    public int getPrice() {
        return price;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10000+1) + 2000);
            System.out.println("Клиент " + this.bidId + " определил цену.");
            if(auction.getstatus() == false) System.err.println("Но не может сделать ставку, так как аукцион закрыт");
                else{
                price += new Random().nextInt(50);
                System.out.println("Ставка " + this.bidId + " : " + price);
                System.out.println("Подождите...");
            }
            this.barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
