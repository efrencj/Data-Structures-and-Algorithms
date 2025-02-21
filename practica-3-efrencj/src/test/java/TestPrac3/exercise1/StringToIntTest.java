package TestPrac3.exercise1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import prac3.exercise1.StringToInt;
import prac3.exercise1.StringToIntImp;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringToIntTest {

    @ParameterizedTest
    @CsvSource({
            "1234,1234",
            "0,0",
            "050,50",
            "000000000000001,1",
            "999999999,999999999"
    })
    void validConversion(String s, int result) {
        StringToInt converter = new StringToIntImp();
        Assertions.assertEquals(result, converter.convert(s));
    }

    @ParameterizedTest
    @CsvSource({
            "abc", // Letters
            "-123", // Negative
            "123abc", // Numeric followed by non-numeric
            "abc123", // Non-numeric followed by numeric
    })
    void invalidConversion(String s) {
        StringToInt converter = new StringToIntImp();
        assertThrows(IllegalArgumentException.class, () -> converter.convert(s));
    }
}
