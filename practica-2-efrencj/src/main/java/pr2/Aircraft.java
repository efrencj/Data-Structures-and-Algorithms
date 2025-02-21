package pr2;

// AQUESTA CLASSE NO POT SER MODIFICADA DE CAP MANERA. 

public class Aircraft implements Comparable<Aircraft> {
	
	private AircraftID id;
	private String name;
	private int year;
	private AircraftType type;
	
	public Aircraft (String name, int year, AircraftType type, String alpha, String beta) {
		this.id = new AircraftID(alpha, beta);
		this.name = name;
		this.year = year;
		this.type = type;
	}
	
	public AircraftID getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	public int getYear() {
		return year;
	}


	public AircraftType getType() {
		return type;
	}


	public int compareTo(Aircraft o) {
		return this.id.compareTo(o.id);
	}
	
	public boolean equals (Object o) {
		return (o instanceof Aircraft) ?
			   this.compareTo((Aircraft)o)==0 : false;
	}

	
	public String toString () {
		return "["+name+" ("+year+") "+type+" "+id+"]\n";
	}
	
	public int hashCode () {
		return this.id.hashCode();
	}

}
