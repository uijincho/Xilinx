package mac;
import java.util.*;

public class MacTest {
    public static void main(String[] args) throws InterruptedException {
        int[] x = {1, 2, 3, 4};
        int[] y = {5, 6, 7, 8};

        SequentialMAC seq = new SequentialMAC();
        int resultSeq = seq.compute(x, y);
        System.out.println("Sequential result: " + resultSeq);

    }
}
