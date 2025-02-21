package TestPrac3.exercise2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import prac3.exercise2.PalindromeGenerator;
import prac3.exercise2.PalindromeGeneratorImp;

public class PalindromeGeneratorTest {
    private static boolean checkPalindrome (String s) {
        String ns = "";
        for (int i=1; i<=s.length(); i++)
            ns = ns + s.charAt(s.length()-i);
        return s.equals(ns);
    }

    @ParameterizedTest
    @CsvSource({
            "0",
            "1",
            "2",
            "3",
            "4",
            "5",
            "10",
            "20",
            "25",
            "100",
            "999"
    })
    void checkPalindromes(int length) {
        PalindromeGenerator pgen = new PalindromeGeneratorImp();
        for(int i = 0; i < 100; ++i) {
            Assertions.assertTrue(checkPalindrome(pgen.generate(length)));
        }
    }
}
