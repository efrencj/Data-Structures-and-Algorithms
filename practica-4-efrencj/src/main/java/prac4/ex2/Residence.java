package prac4.ex2;

// This code cannot be modified in any way

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