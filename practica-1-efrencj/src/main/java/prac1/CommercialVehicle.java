package prac1;

//This class MUST NO be modified

public class CommercialVehicle extends Vehicle {

	private double maxLoad;
	private boolean dangerousPayload;

	public CommercialVehicle(Plate plate, double weight, String owner,
			                 double maxLoad, boolean dangerousPayload) {
		super(plate,  weight, owner);
		this.maxLoad = maxLoad;
		this.dangerousPayload = dangerousPayload;
	}

	public double getMaxLoad() {
		return maxLoad;
	}

	public boolean containsDangerousPayload() {
		return dangerousPayload;
	}
	
	public void setDangerousPayload (boolean dangerous) {
		this.dangerousPayload = dangerous; 
	}
	
	public String toString () {
		return super.toString()+" COMMERCIAL ml:"+maxLoad+" dg: "
	                           + (dangerousPayload?"yes":"no");
	}
}
