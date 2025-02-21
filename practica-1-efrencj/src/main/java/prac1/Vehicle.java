package prac1;

// This class MUST NO be modified

public abstract class Vehicle implements Comparable {

	private Plate plate;
	private String owner;
	private double weight; // in tons
	
	public Vehicle (Plate plate, double weight, String owner) {
		this.plate = plate;
		this.weight = weight;
		this.owner = owner;
	}

	public Plate getPlate() {return plate;}

	public double getWeight() {return weight;}
	
	public String getOwner() {return owner;}
	
	@Override
	public int compareTo (Object other) {
		// vehicles are sorted by plate
		Vehicle otherVehicle = (Vehicle)other; // Throws classCastException if required
		return this.plate.compareTo(otherVehicle.plate);
	}
	
	@Override
	public boolean equals (Object other) {
		try {
			return this.compareTo(other)==0;
		}
		catch (ClassCastException cce) {
			return false;
		}
	}
	
	
	@Override
	public String toString () {
		return "VEHICLE: "+plate+" ow:"+owner;
	}
}
