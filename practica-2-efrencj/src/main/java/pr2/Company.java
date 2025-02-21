package pr2;

// AQUESTA CLASSE NO POT SER MODIFICADA DE CAP MANERA

public class Company implements Comparable<Company>{
	
	private String name;
	private String country;

	
	public Company (String name, String country) {
		this.name = name;
		this.country = country;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCountry() {
		return country;
	}

	@Override
	public int compareTo(Company other) {
		return this.name.compareToIgnoreCase(other.name);
	}
	
	public boolean equals (Object other) {
		return  other instanceof Company ?
				compareTo((Company)other)==0 :false;
	}
	
	public int hashCode () {
		return this.name.toUpperCase().hashCode();
	}
}
