package src.mac_legacy;

public class TestArrays{
    public static void main(String[] args) throws InterruptedException
    {
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {5,6,7,8};
        for (int i=0; i<4; i++){
            arr1[i] = i;
            arr2[i] = i;
        }
       
        long start = System.nanoTime();
       
        int parallel = ParallelMAC.compute(arr1, arr2);
       
        long end1 = (System.nanoTime()-start)/1000000;
        System.out.println("Parallel time complexity: " + end1);
       
        long start2 = System.nanoTime();
       
        int sequential = SequentialMAC.compute(arr1, arr2);
       
        long end2 = (System.nanoTime()-start2)/1000000 + 1;
        System.out.println("Sequential time complexity: " + end2);
       
        if (parallel == sequential){
            System.out.println("Both outputs are the same");
        } else{
            System.out.println("Both outputs are not the same");
        }



    }
}