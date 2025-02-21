# Práctica 0
El objetivo de la práctica es hacer una implementación de la interfaz Operations. Que engloba las operaciones suma, resta, multiplicación y división.

```java
package prac0;

public interface Operations {

    float Add(float a, float b);

    float Sub(float a, float b);

    float Mul(float a, float b);

    float Div(float a, float b);
}
```

La implementación se tiene que hacer en la clase OperationsImplementation:

```java
package prac0;

public class OperationsImplementation implements Operations{
    // Add methods to implement in Operations
}
```

El proyecto tiene test para probar que vuestra implementación es correcto. Podéis ver los tests en la clase OperationsTest.
```java
package TestPrac0;

import ...

public class OperationsTest {

    @ParameterizedTest
    @CsvSource({...})
    void AddTest(int a, int b, int result) {
        Operations ops = new OperationsImplementation();
        Assertions.assertEquals(result, ops.Add(a, b));
    }

    @ParameterizedTest
    @CsvSource({...})
    void SubTest(int a, int b, int result) {
        Operations ops = new OperationsImplementation();
        Assertions.assertEquals(result, ops.Sub(a, b));
    }

    @ParameterizedTest
    @CsvSource({...})
    void MulTest(int a, int b, int result) {
        Operations ops = new OperationsImplementation();
        Assertions.assertEquals(result, ops.Mul(a, b));
    }

    @ParameterizedTest
    @CsvSource({...})
    }
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
```

Esta práctica es una práctica de prueba para que veáis como funciona. No tiene nota ni es obligatorio entregar nada.
