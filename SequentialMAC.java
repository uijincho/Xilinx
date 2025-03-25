package mac;
import java.util.*;

public class SequentialMAC {
    public int compute(int[] x, int[] y) {
        int result = 0;
        for (int i = 0; i < x.length; i++) {
            result += x[i] * y[i];
        }
        return result;
    }
}
