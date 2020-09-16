
import java.util.Random;

public class AuctionRunner {
    public static void main(String[] args) {
        Auction auction = new Auction();
        auction.start();
        int startPrice = new Random().nextInt(100);
        // Change (auction.BIDS_COUNT) on your
        for (int i = 1; i <= auction.BIDS_COUNT; i++) {
            Bid thread = new Bid(i, startPrice, auction.getBarrier(), auction);
            auction.add(thread);
            thread.start();
        }
    }
}
