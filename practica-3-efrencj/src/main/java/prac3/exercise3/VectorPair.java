package prac3.exercise3;

import java.util.Random;

public class VectorPair {

    private static Random random = new Random();

    public  int [] one;
    public int [] two;

    public VectorPair(boolean correctlyReversed) {
        this.one = this.randomIntVector(correctlyReversed ? random.nextInt(10) : random.nextInt(10)+1);
        this.two = this.reversed(this.one);
        if (!correctlyReversed) {
            this.two[random.nextInt(this.two.length)]++;
        }
    }

    private static int[] reversed (int [] v) {
        int [] result = new int[v.length];
        for (int i=0; i<v.length; i++) {
            result[v.length-1-i]=v[i];
        }
        return result;
    }

    private static int[] randomIntVector (int length) {
        int [] result = new int[length];
        for (int i=0; i<length; i++) {
            result[i] = random.nextInt(10);
        }
        return result;
    }

    public static boolean checkVectorPairRecursive(int[] one, int[] two) {
        if (one.length != two.length) {
            return false;
        }
        return checkRecursive(one, two, 0);
    }

    private static boolean checkRecursive(int[] one, int[] two, int index) {
        if (index >= one.length) {
            return true;
        }
        if (one[index] != two[two.length - 1 - index]) {
            return false;
        }
        return checkRecursive(one, two, index + 1);
    }
}