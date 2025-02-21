package prac3.exercise2;

public class PalindromeGeneratorImp implements PalindromeGenerator {

    @Override
    public String generate(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("Length cannot be negative");
        }
        return generatePalindrome(length);
    }

    private String generatePalindrome(int length) {
        if (length == 0) {
            return "";
        } else if (length == 1) {
            return String.valueOf(PalindromeGenerator.randomVowel());
        } else {
            char c = PalindromeGenerator.randomVowel();
            String middle = generatePalindrome(length - 2);
            return c + middle + c;
        }
    }
}
