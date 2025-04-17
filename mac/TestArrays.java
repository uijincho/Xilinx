package mac;
import java.util.*;
public class TestArrays{
    public static void main(String[] args) throws InterruptedException
    {
        int size = 1000;
        int [] x = new int[size];
        int [] y = new int[size];
        for(int i = 0; i<size; i++){
            x[i] = (int) (Math.random() * 100);
            y[i] = (int) (Math.random() * 100);
        }
       
        //long start = System.nanoTime();
       
        SequentialMAC seq = new SequentialMAC();
        long startSeq = System.nanoTime();
        int resultSeq = seq.compute(x, y);
        long endSeq = System.nanoTime();
        long timeSeq = endSeq - startSeq;


        ParallelMAC par = new ParallelMAC();
        long startPar = System.nanoTime();
        int resultPar = par.compute(x, y);
        long endPar = System.nanoTime();
        long timePar = endPar - startPar;

        System.out.println("Sequential result: " + resultSeq);
        System.out.println("Parallel result: " + resultPar);
        System.out.println("Sequential time: " + timeSeq + " ns");
        System.out.println("Parallel time: " + timePar + " ns");
       
        if (resultSeq == resultPar) {
            System.out.println("Same");
        } else {
            System.out.println("Different");
        }
    }
}