[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/y5tR2_pI)
# Práctica 4

## Primer ejercicio: indexador (30%)
Tenéis que completar el código del procedimiento:
```java
private static Map<String, SortedSet<Integer>> createIndex(File file) throws IOException {
```
Este procedimiento crea un índice de palabras a partir del contenido del archivo (de texto) dado como
parámetro. Este índice contiene:
* Como claves, todas las palabras del texto que empiezan con una letra mayúscula (el hecho de
  empezar con una letra mayúscula es lo que indica que la palabra tiene que formar parte del
  índice).
* Como valor, de cada clave, los números de todas las líneas donde la palabra aparece.

Las palabras que tienen una medida inferior a 5 aunque empiecen con una letra mayúscula no se
tienen en consideración. Las palabras que se introducen al índice son previamente convertidas a “todo
mayúsculas”.

Para conseguir separar las palabras que forman cada línea, utilizáis el método _split_ de la
clase _String_ con parámetro la siguiente cadena: `"[\\s!?\"\',;:.-//)//(]+"`

Utilizad los test para ver si funciona.

## Segundo ejercicio: Carga y descarga del “registro de la propiedad” (70%)
Disponéis de las clases Residence y Owner que no podéis modificar. En Owner debeis completar el método equals.
```java
public class Residence {

  private String address;
  private int rooms;
  private double surfaceArea;

  public Residence(String address, int rooms, double surfaceArea) {
    this.address = address;
    this.rooms = rooms;
    this.surfaceArea = surfaceArea;
  }

  public String getAddress() {
    return address;
  }

  public int getRooms() {
    return rooms;
  }

  public double getSurfaceArea() {
    return surfaceArea;
  }

  public String toString () {
    return "RESIDENCE: "+address+" ("+rooms+" rooms) "+surfaceArea+" m2";
  }
}
```
```java
public class Owner {

  private String name;
  private int id;
  private boolean individualProperty;

  public Owner(String name, int id, boolean individualProperty) {
    this.name = name;
    this.id = id;
    this.individualProperty = individualProperty;
  }

  public String getName() {return name;}

  public int getId() {return id;}

  public boolean isIndividualProperty() {return individualProperty;}

  public String toString () {
    return name+" ("+id+") individual property: "+(individualProperty?"yes":"no");
  }

  @Override
  public boolean equals(Object other) {
    //COMPLETE
  }
}
```
También disponéis de una parte del código de la clase _PropertyRegistry_ el propósito de los objetos de la cual
es almacenar viviendas junto con todos sus propietarios.

El objetivo de esta práctica es “poblar” la infraestructura de estos objetos con datos obtenidos
de un archivo almacenado en formato binario y también poder guardar todos estos datos en un archivo
de formado texto.
```java
public class PropertyRegistry {

  private static final String MARK_END_PROPS = "1234567890_end_props";

  // This attribute cannot be modified or new ones added.
  private Map<Residence, List<Owner>> infrastructure;

  public PropertyRegistry() {
    // This constructor code cannot be modified
    infrastructure = new TreeMap<Residence, List<Owner>>(new Comparator<Residence>() {
      public int compare(Residence h1, Residence h2) {
        if (h1.getSurfaceArea() > h2.getSurfaceArea()) return 1;
        else if (h1.getSurfaceArea() < h2.getSurfaceArea()) return -1;
        else return 0;
      }
    });
  }
  ...
```

### Primera parte: “carga” desde un archivo binario
Se os proporciona un archivo binario denominado RegPropietat.bin. Este archivo ha sido creado con
el método dumpToBinFile.
```java
/* This is the method that was used to create the .bin
	file submitted. Analyze it to deduce how the method
	that reads and "transfers" its contents to the
	infrastructure should be. */
public void dumpToBinFile(File binFile) throws IOException {
  DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(binFile)));
  List<Owner> owners;

  for (Residence h : this.infrastructure.keySet()) {
    output.writeDouble(h.getSurfaceArea());
    output.writeInt(h.getRooms());
    output.writeUTF(h.getAddress());
    owners = this.infrastructure.get(h);
    for (Owner p : owners) {
      output.writeUTF(p.getName());
      output.writeInt(p.getId());
      output.writeBoolean(p.isIndividualProperty());
    }
    output.writeUTF(PropertyRegistry.MARK_END_PROPS);
  }

  output.close();
}
```
Lo que tenéis que hacer es escribir el código del método _loadFromBinFile_ que hace la operación inversa: lee
el contenido del archivo y lo utiliza para rellenar la infraestructura de la clase. Si vuestro método es
correcto.

### Segunda parte: “descarga” a un archivo de texto
Ahora lo que tenéis que hacer es completar el método _dumpToTextFile_ el propósito del cual es generar un
archivo de texto que tenga el contenido de la infrastructura del registro de la propiedad.

```java
/*
	This method writes the infrastructure content to a text file.

	The file should have the following format:
		Residence address
		Number of rooms in the Residence
		Surface area of the Residence
		Number of Owners of the Residence
	For each of the Owners of the Residence:
  		Name
  		ID
  		Yes/No (depending on whether it is an individual Owner or not)

	Residences must appear ordered by surface area (first those with smaller surface areas).
	The Owners of each Residence must appear ordered alphabetically by name.
	 */

public void dumpToTextFile(File textFile) throws IOException {
  //COMPLETE
}
```
Prestad atención al tema de la ordenación...

Usad los test para comprobar que vuestro código sea correcto.