
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.CyclicBarrier;
/*
крч штука классная, получилось прикольно
суть есть аук и два условия когда он завершается:
	1 по истечении 10 сек он закрывается и смотрит наибольшую заходную ставку клиента
	2 по набору (BIDS_COUNT)N-го кол-ва клиентов закрывается и находит наибольш ставку
*/
public class Auction extends Thread {

    private ArrayList<Bid> bids;
    private CyclicBarrier barrier;
    // Constant which define count of bids
    public final int BIDS_COUNT = 5;
    private boolean status;
    public Auction() {
        this.status = true;
        this.bids = new ArrayList<Bid>();
        this.barrier = new CyclicBarrier
                (this.BIDS_COUNT, new Runnable() {
                    @Override
                    public void run() {
                        if(status == true)
                        {
                        Bid winner = Auction.this.defineWinner();
                        System.err.println("Ставка #" +
                                winner.getBidId() +
                                ", цена: " + winner.getPrice() +
                                " победил!");
                        status = false;
                        }
                    }
                });
    }
    @Override
    public void run() {
        try /*{
            for(int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                System.out.println("Прошла секунда, осталось " + (9 - i));
            }
            if(this.status == false)
                System.err.println("Победитель определен, аункицон закончен!!!");
            else {
                Bid winner = Auction.this.defineWinner();
                System.err.println("Время закончилось\nСтавка #" +
                        winner.getBidId() +
                        ", цена: " + winner.getPrice() +
                        " победил!");
                this.status = false;
            }*/

            {
            for(int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                System.out.println("Прошла секунда, осталось " + (9 - i));

                if(this.status == false){
                    System.err.println("Победитель определен, аункицон закончен!!!");
                    break;
                }
            }
            if(this.status == true) {
                Bid winner = Auction.this.defineWinner();
                System.err.println("Время закончилось\nСтавка #" +
                        winner.getBidId() +
                        ", цена: " + winner.getPrice() +
                        " победил!");
                this.status = false;
                this.interrupt();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public CyclicBarrier getBarrier() {
        return barrier;
    }

    public boolean add(Bid e) {
        return bids.add(e);
    }

    public Bid defineWinner() {
        return Collections.max(bids, Comparator.comparingInt(Bid::getPrice));
    }

    public boolean getstatus() {
        return status;
    }
}
