package prac1;

import java.util.*;

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