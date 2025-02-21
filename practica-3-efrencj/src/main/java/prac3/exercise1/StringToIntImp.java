package prac3.exercise1;

public class StringToIntImp implements StringToInt{
    @Override
    public int convert(String s){
        return convertRecursive(s);
    }

    @Override
    public int convertRecursive(String s){
        if(s.isEmpty()) return 0;
        int currentDigit = translateChar(s.charAt(0));
        int multiplier = (int)Math.pow(10, s.length()-1);
        return currentDigit * multiplier + convertRecursive(s.substring(1));
    }

}
