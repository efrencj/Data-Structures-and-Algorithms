package pr2;

// AQUESTA CLASSE NO POT SER MODIFICADA DE CAP MANERA

public class AircraftID implements Comparable<AircraftID> {
	
private String alpha, beta;
	
	public AircraftID (String alpha, String beta) {
		if (alpha == null || beta == null) {
			throw new IllegalArgumentException ("nor alpha neither beta can be null");
		}
		this.alpha = alpha.toUpperCase();
		this.beta = beta.toUpperCase();
	}

	public String getAlpha () {return this.alpha;}
	public String getBeta () {return this.beta;} 
	
	public int compareTo(AircraftID other) {
		int cmp = this.alpha.compareTo(other.alpha);
		return cmp!=0 ? cmp : -this.beta.compareTo(other.beta);
	}
	
	public boolean equals (Object o) {
		if (!(o instanceof AircraftID)) return false;
		else return this.compareTo((AircraftID)o)==0;
	}
	
	public String toString () {
		return "id<"+this.alpha+"."+this.beta+">";
	}
	
	public int hashCode () {
		return alpha.hashCode()+beta.hashCode();
	}

}
