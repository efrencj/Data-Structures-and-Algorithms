[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/DEL8INx7)
# Práctica 1
El objetivo de la práctica es hacer una implementación de la interfaz VehiclePark que esté
internamente basada en alguna clase implementadora de Collection.
```java
public interface VehiclePark {
    
    public int numVehicles();
    /* Returns the number of vehicles currently in the vehicle park */
    
    public boolean isEmpty();
    /* returns true if the vehicle park is empty, false otherwise */
    
    public int numPrivate();
    /* Returns the number of private vehicles in the Vehicle Park */
    
    public boolean inPark (Plate p);
    /* Returns true if the vehicle park contains a vehicle with plate p */
    
    public void enter (Vehicle v);
    /* Stores c in the VehiclePark, if possible.
    Throws (and does not store v):
        - a NullPointerException if the parameter is null
        - a AlreadyStoredException if the VehiclePark already contains a
          vehicle "like" v
    */
    
    public int enter (Collection vehicles);
    /* Stores in the VehiclePark the vehicles contained in the parameter
    Beware: the parameter may contain objects that are not vehicles
    Beware: the parameter may contain null objects
    Beware: the parameter may contain repetitions
    
    Returns: the number of vehicles effectively stored
    
    This method does not throw exceptions
    */
    
    public boolean leave (Plate p);
    /*
    Removes from VehiclePark all vehicles with Plate p
    Returns true if a vehicle has been removed. False otherwise
    */
    
    public Vehicle[] leave (String owner);
    /*
    Removes from VehiclePark all vehicles that "belong" to the given owner
    (parameter)
    Returns an array containing all the removed vehicles. This array:
        - has the exact length (no empty -null- positions)
        - has length 0 if no vehicles has been removed
        - is sorted according to the natural ordering of the vehicles (ascending)
    */
    
    public boolean containsDangerousPayload();
    /*
    Returns true if the VehiclePark contains any CommercialVehicle
    the payload of which is dangerous. False otherwise;
    */
}
```
La clase Vehícle (abstracta) y sus derivadas CommercialVehicle y PrivateVehicle ya están
codificadas y no se puede hacer ninguna modificación.

Como paso previo, tendréis que completar la implementación de la clase Plate (placa de matrícula). La
clase está totalmente implementada salvo sus métodos compareTo y equals. **Ojo: no podéis
modificar las cabeceras de estos métodos dado que hay que respetar el origen (la clase Object y la
interfaz Comparable).**
```java
public class Plate implements Comparable, Cloneable {
    
    private static final int MIN_AREA_CODE = 1;
    private static final int MAX_AREA_CODE = 6;
    
    private int areaCode;
    private String prefix;
    private String suffix;
    
    public Plate (int areaCode, String prefix, String suffix) {
        checkParams(areaCode, prefix, suffix);
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.suffix = suffix;
    }
    
    ...
    
    @Override
    public int compareTo (Object other) {
        /* this is how plates are sorted:
        first go plates with lower area codes. If they have the same area code...
        ... first go plates with a lower prefix. If the have the same prefix...
        ... first go plates with a lower suffix.
        */
        
        /* COMPLETE */
    }
        
    @Override
    public boolean equals (Object other) {
        /* COMPLETE */
    }
    ...
}
```
Un pequeño test de prueba (PlateTest.java suministrado) os permitirá de verificar el
comportamiento de la implementación de la comparación. Si esta es correcta tendríais que obtener todos los tests correctos.

Entonces ya podréis completar la clase VehicleParkImplementation. La declaración de atributos ya está
completa. Ojo: no podéis usar la notación <E> ni las iteraciones for-each.

```java
  import java.util.*;
  public class VehicleParkImplementation implements VehiclePark{
  private Collection infrastructure;
  // do not add more attributes. This is all you really need
  public VehicleParkImplementation () {
  infrastructure = /* COMPLETE */
  }
  /* COMPLETE */
      ...
  }
```
De cara a tener ciertas garantías respecto del correcto funcionamiento de la implementación, se os
suministra un pequeño test de prueba (VehicleParkImplementationTest.java). Este test intenta determinar la
presencia de algunos comportamientos erróneos.
Las entregas que no superen ambos tests obtendrán una calificación inferior al 50% (menos de
5 puntos sobre 10). Las entregas que superen ambos tests no tienen garantizada ninguna calificación
mínima.

Este dos tests son para comprobar vosotros que vais bien, pero tenéis que ir algo más allá. Para poner la nota hay más tests extra que ejecutara solo el profesor.
Estos tests extra mirarán más cosas como correctas excepciones, casos límite o simplemente muchos más datos diferentes para evitar que vuestro código solo funcione con los datos de los tests normales.