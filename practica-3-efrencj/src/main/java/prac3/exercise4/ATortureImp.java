package prac3.exercise4;

import java.util.Random;

public class ATortureImp implements ATorture {
    char[] letters = {'a', 'b', 'c', 'd', 'e', 'f'};
    Random random = new Random();

    public String tortura(String s) {
        return torturaRecursive(s, 0);
    }

    public String torturaRecursive(String s, int index) {
        if (index >= s.length()) {
            return "";
        }
        char currentChar = s.charAt(index);
        if (currentChar == 'a') {
            if (index % 2 == 0) {
                return "*" + torturaRecursive(s, index + 1);
            } else {
                return torturaRecursive(s, index + 1);
            }
        } else {
            return currentChar + torturaRecursive(s, index + 1);
        }
    }

    public String torturaIterative(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == 'a') {
                if (i % 2 == 0) {
                    result.append('*');
                }
                // If 'a' is at an odd position, we do nothing (i.e., skip it)
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    public String genCadena(int n) {
        if (n <= 0) {
            return "";
        }
        return letters[random.nextInt(letters.length)] + genCadena(n - 1);
    }

}
