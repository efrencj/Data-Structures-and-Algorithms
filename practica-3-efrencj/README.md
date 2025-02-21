[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/WDxFvtIH)
# Práctica 3

## Primer ejercicio: Conversión de String a int

Crear la implementación de StringToInt llamada StringToIntImp que debe ser RECURSIVA, dada una cadena de caracteres no vacía que solo contiene dígitos, la convierta en el número entero correspondiente. Por ejemplo, si se le da la cadena "13045", debe devolver el número entero 13045. Si se le da la cadena "0", debe devolver el número entero 0 y si se le da la cadena "0050", debe devolver el número entero 50. Puede ser útil pensar en una estrategia "cola-cabeza" (ojo, "cola-cabeza" en lugar de "cabeza-cola").

## Segundo ejercicio: Generación de palíndromos

La siguiente es una definición recursiva de un palíndromo (cadena, String):

> 1. La cadena vacía ("") es un palíndromo (de tamaño 0).
> 2. Si c es un carácter cualquiera, la cadena que solo contiene c ("c") es un palíndromo (de tamaño 1).
> 3. Si c es un carácter cualquiera y S es un palíndromo, la cadena cSc es un palíndromo (de tamaño 2 + el tamaño de S).

Crear la implementación **PalindromeGenerator** llamada **PalindromeGeneratorImp**.

Se dispone de una función que genera caracteres al azar. Úsela para generar un "carácter cualquiera".

## Tercer ejercicio: ¿Vector "girado"?

Se debe escribir una función RECURSIVA que, dados dos vectores de enteros de la misma longitud, determine si uno es la versión "girada" del otro (contiene los mismos elementos pero en orden contrario). Por ejemplo, los vectores {5, 6, 8, 9} y {9, 8, 6, 5} son la versión girada el uno del otro. También lo son los vectores {1, 2, 3, 4, 5} y {5, 4, 3, 2, 1}. Sin embargo, los vectores {7, 3, 8, 9, 5} y {5, 9, 8, 3, 4} no lo son, al igual que los vectores {1, 2, 3, 5} y {5, 2, 3, 1}.

Para probar la implementación, se suministra una clase llamada VectorPair. Los objetos de esta clase encapsulan (aunque de manera pública) un par de vectores de enteros llamados one y two. Si al invocar el constructor de la clase el parámetro dado es true, entonces one y two son la versión girada uno del otro. Por el contrario, si el parámetro dado es false, one y two no son la versión girada uno del otro.

En este ejercicio debéis completar la función checkVectorPairRecursive dentro del test.

## Cuarto ejercicio: Torturando las 'a'

Basándose en la estrategia de las dos mitades, escribir una función RECURSIVA que, dada una cadena de caracteres, genere otra en la que los caracteres 'a' (en minúscula) que aparecen en posiciones pares sean reemplazados por el carácter '*' y los que aparecen en posición impar sean eliminados.

Por ejemplo, si la cadena suministrada es "abracadabral", la cadena resultante debería ser "*brcdbrl*". Si la cadena fuera "paranormalitats", la cadena resultante sería "prnorm*lit*ts". La cadena "pana" daría lugar a "pn" y la cadena "ana" daría lugar a "*n*".

Recordar que los caracteres en las cadenas se numeran a partir de cero.

Para ello debéis implementar la interfaz ATorture, la clase ATortureImp está ya creada pero le faltan los métodos.
> * String tortura(String s): punto de inicio para llamar a la función recursiva torturaRecursive
> * String torturaRecursive(String s, int index): implementación recursiva.
> * String torturaIterative(String s): implementación iterativa
> * String genCadena(int n): función auxiliar RECURSIVA para generar cadenas aleatorias usando los caracteres en la variable letters (a,b,c,d,e,f)
