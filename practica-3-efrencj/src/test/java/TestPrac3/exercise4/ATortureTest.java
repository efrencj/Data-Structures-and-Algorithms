package TestPrac3.exercise4;

import org.junit.jupiter.api.Test;
import prac3.exercise4.ATorture;
import prac3.exercise4.ATortureImp;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ATortureTest {
    @Test
    public void genCadenaTest()
    {
        ATorture at = new ATortureImp();

        for (int i = 0; i < 100; ++i)
        {
            String str = at.genCadena(i);
            assertEquals(i, str.length());
        }
    }

    @Test
    public void tortureTest()
    {
        ATorture at = new ATortureImp();

        for (int i = 0; i < 100; ++i)
        {
            String str = at.genCadena(i);
            assertEquals(at.tortura(str), at.torturaIterative(str), str);
        }
    }
}
