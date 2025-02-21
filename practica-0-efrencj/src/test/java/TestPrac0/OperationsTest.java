package TestPrac0;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import prac0.Operations;
import prac0.OperationsImplementation;

public class OperationsTest {

    @ParameterizedTest
    @CsvSource({
            "1, 1, 2",
            "2, 3, 5",
            "10, -3, 7"
    })
    void AddTest(int a, int b, int result) {
        Operations ops = new OperationsImplementation();
        Assertions.assertEquals(result, ops.Add(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "3, 2, 1",
            "5, 3, 2",
            "10, 10, 0"
    })
    void SubTest(int a, int b, int result) {
        Operations ops = new OperationsImplementation();
        Assertions.assertEquals(result, ops.Sub(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 6",
            "4, -2, -8",
            "5, 0, 0"
    })
    void MulTest(int a, int b, int result) {
        Operations ops = new OperationsImplementation();
        Assertions.assertEquals(result, ops.Mul(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "6, 2, 3",
            "10, -2, -5",
            "0, 5, 0"
    })
    void DivTest(int a, int b, int result) {
        Operations ops = new OperationsImplementation();
        Assertions.assertEquals(result, ops.Div(a, b));
    }

    @Test
    void ZeroDivTest() {
        Operations ops = new OperationsImplementation();
        Assertions.assertThrows(ArithmeticException.class, () -> ops.Div(5, 0));
    }
}
