package prac0;

public class OperationsImplementation implements Operations{
    public int Add(int a, int b) {
        return a + b;
    }

    
    public int Sub(int a, int b) {
        return a - b;
    }

    
    public int Mul(int a, int b) {
        return a * b;
    }

    
    public int Div(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("No es pot dividir entre zero!");
        }
        return a / b;
    }
}
