package TestPrac3.exercise3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import prac3.exercise3.VectorPair;

import java.util.Arrays;

public class VectorPairTest {
    private static boolean checkVectorPair (VectorPair vp) {
        return checkVectorPairRecursive(vp.one, vp.two);
    }

    private static boolean checkVectorPairRecursive(int[] one, int[] two) {
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

    @ParameterizedTest
    @CsvSource({
            "true",
            "false"
    })
    void checkVectorPairs(boolean reversed) {
        for(int i = 0; i < 100; ++i) {
            VectorPair vp = new VectorPair(reversed);
            boolean checked = checkVectorPair(vp);
            Assertions.assertEquals(reversed, checked);
        }
    }
}