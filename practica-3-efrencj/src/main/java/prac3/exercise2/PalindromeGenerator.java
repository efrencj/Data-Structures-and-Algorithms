package prac3.exercise2;

import java.util.Random;

public interface PalindromeGenerator {

    char[] VOWELS = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};

    Random random = new Random(System.currentTimeMillis());

    String generate(int length);

    static char randomVowel() {
        return VOWELS[random.nextInt(VOWELS.length)];
    }
}
