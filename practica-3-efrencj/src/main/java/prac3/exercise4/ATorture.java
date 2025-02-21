package prac3.exercise4;

import java.util.Random;

public interface ATorture {
    String tortura(String s);

    String torturaRecursive(String s, int index);

    String torturaIterative(String s);

    String genCadena(int n);
}
