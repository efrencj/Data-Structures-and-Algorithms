[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/M1GLJwGy)
# Práctica 2
Disponéis de las clases **Company**, **AircraftID** y **Aircraft** totalmente implementadas. También
disponéis de la enumeración **AircraftType**. Ni las clases anteriores ni la enumeración pueden ser
modificadas de ninguna forma. En toda esta práctica tenéis que hacer uso de la notación \<E\>.

```java
// AQUESTA CLASSE NO POT SER MODIFICADA DE CAP MANERA.
public class Company implements Comparable<Company>{
    ...
}
```
```java
// AQUESTA CLASSE NO POT SER MODIFICADA DE CAP MANERA.
public class AircraftID implements Comparable<AircraftID> {
    ...
}
```
```java
// AQUESTA CLASSE NO POT SER MODIFICADA DE CAP MANERA.
public class Aircraft implements Comparable<Aircraft> {
    
    private AircraftID id;
    private String name;
    private int year;
    private AircraftType type;
    
    ...
    
    public int compareTo(Aircraft o) {
        return this.id.compareTo(o.id);
    }
    
    public boolean equals (Object o) {
        return (o instanceof Aircraft) ? this.compareTo((Aircraft)o)==0 : false;
    }
    
    ...
}
```
```java
// AQUESTA ENUMERACIÓ NO POT SER MODIFICADA DE CAP MANERA
public enum AircraftType {
    
    FOUR_ENG, TWO_ENG, ONE_ENG, ONE_BLADE_PROP, SEV_BLADE_PROP
}
```
Los detalles de la implementación de estas clases son bastantes irrelevantes. Solo debeis tener
presente (y hacer uso cuando lo consideráis conveniente) que los objetos de la clase **Aircraft**
se identifican por su atributo id (**AircraftID**) –dos objetos de esta clase son “iguales” si sus
ids son “iguales”- y que también se ordenan en función de este atributo –es menor aquel objeto que tiene
un id menor-.

La interfaz **AirRegister** define la funcionalidad que tiene que tener un registro aéreo (un “almacén”
que conoce qué compañías aéreas existen, qué aviones, qué compañía es propietaria de
qué aviones, qué aviones son propiedad de qué compañía, etc. y permite responder algunas
preguntas sencillas como por ejemplo “qué compañías tienen aviones de un determinado tipo”.

```java
public interface AirRegister {
    /* Adds the given company to the register.
    If the company already exists in the register,
    this method does nothing and just returns false.
    If the company does not exist, it is registered
    and the method returns true. */
    public boolean addCompany (Company c);
    
    /* Registers the given aircraft for the given company.
    Throws UnknownCompanyException if the company is not already registered.
    Throws DifferentComapanyException if the aircraft is already registered
    to another company.
    Returns false if the aircraft is already registered to the given company
    and true otherwise */
    public boolean registerAircraft (Company c, Aircraft a);
    
    /* Returns the company owning the aircraft with the given id.
    Returns null if no company owns an aircraft with the given id*/
    public Company findCompany (AircraftID id);
    
    /* returns all the aircrafts registered to the given company.
    The result is an empty set if the company is unknown or has
    no aircrafts registered. The resulting set is sorted by
    aircraft year, ascending */
    public SortedSet<Aircraft> registeredAircrafts (Company c);
    
    /* Returns all the companies that own an aircraft (or more)
    of the given type. The resulting set is sorted by natural
    ordering */
    public SortedSet<Company> findCompanyByType (AircraftType t);
}
```

Vuestra tarea consiste en hacer una implementación totalmente operativa de esta interfaz que
se denomine **AirRegisterImp**. Esta clase tiene que tener exactamente este nombre y disponer de un
único constructor que no tenga ningún parámetro. Tenéis libertad para escoger la infraestructura que
consideráis más oportuna siempre teniendo presente que vuestro objetivo es conseguir que la
implementación de los métodos sea tan simple como sea posible.

> Tenéis, además, tres restricciones adicionales:
> 1) Algún método tiene que estar basado en una iteración sobre el resultado
     proporcionado por el método **entrySet** definido en **Map**
> 2) Algún método tiene que hacer uso de un iterador **for-each**
> 3) En ninguno de los métodos que implementáis podéis hacer uso de los métodos
     **getAlpha** y **getBeta** de la clase **AircraftID**

Prestad atención al método **registeredAircrafts**. Observad que su resultado NO tiene que estar ordenado
según el orden natural de la clase **Aircraft** sino que se pide que la ordenación se haga por año
(**year** es uno de los atributos de la clase **Aircraft** y tiene su correspondiente método get).
Para implementar correctamente este método os hacemos la siguiente sugerencia: id a la
documentación de la clase **TreeSet** y veréis que existe un constructor que toma un parámetro de
tipo **Comparator**. Documentaos sobre esta interfaz (**Comparator**) y... haced uso de esto.

Disponéis de un pequeño test que os puede ayudar a depurar vuestra implementación.
Tened presente que hay aspectos del registro que este programa no tiene en consideración... Hay que
superar este test para aprobar la entrega.

