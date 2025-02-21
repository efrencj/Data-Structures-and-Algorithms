package prac1;

//This class MUST NO be modified

public class PrivateVehicle extends Vehicle {

	private int seats;
	private int wheels;
	
	public PrivateVehicle(Plate plate,  double weight, String owner,
			              int seats, int wheels) {
		super(plate, weight, owner);
		this.seats = seats;
		this.wheels = wheels;
	}

	public int getSeats() {
		return seats;
	}

	public int getWheels() {
		return wheels;
	}
	
	public String toString () {
		return super.toString()+" PRIVATE ("+seats+", "+wheels+")";
	}
	
}
