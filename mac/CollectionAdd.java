package mac;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@Measurement(iterations = 1)
@Warmup(iterations = 1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
public class CollectionAdd {

    // When running with JoularJX, only use a single parameter:
    @Param({ "100000", "200000", "500000", "1000000" })
    public int setSize;

    public int[] valuesToAdd;

    @Setup
    public void iterationSetup() {
        valuesToAdd = new int[setSize];
        Random rand = new Random(9032);
        for (int i = 0; i < setSize; i++) {
            valuesToAdd[i] = rand.nextInt(setSize);
        }
    }

    @Benchmark 
    public List<Integer> addToJavaArrayList() {
        var result = new ArrayList<Integer>();
        for (int i = 0; i < valuesToAdd.length; i++) {
            result.add(valuesToAdd[i]);
        }
        return result;
    }

    @Benchmark
    public List<Integer> addToJavaLinkedList() {
        var result = new LinkedList<Integer>();
        for (int i = 0; i < valuesToAdd.length; i++) {
            result.add(valuesToAdd[i]);
        }
        return result;
    }

    @Benchmark
    public List<Integer> addToEclipseFastList() {
        var result = new FastList<Integer>();
        for (int i = 0; i < valuesToAdd.length; i++) {
            result.add(valuesToAdd[i]);
        }
        return result;
    }

    @Benchmark
    public MutableIntList addToEclipseIntArrayList() {
        var result = new IntArrayList();
        for (int i = 0; i < valuesToAdd.length; i++) {
            result.with(valuesToAdd[i]);
        }
        return result;
    }

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(CollectionAdd.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
