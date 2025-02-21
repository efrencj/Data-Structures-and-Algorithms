package prac1;

import java.util.*;

public class VehicleParkImplementation implements VehiclePark {

    private Collection infrastructure;

    // do not add more attributes. This is all you really need
    public VehicleParkImplementation() {
        infrastructure = new ArrayList<>();
        /* COMPLETE */
    }
    /* COMPLETE */
    public int numVehicles(){
        return infrastructure.size();
    }
    /* Returns the number of vehicles currently in the vehicle park */

    public boolean isEmpty(){
        return infrastructure.isEmpty();
    }
    /* returns true if the vehicle park is empty, false otherwise */

    public int numPrivate(){
        int num = 0;
        for(Object Vehicle : infrastructure){
            if(Vehicle instanceof PrivateVehicle){
                num++;
            }
        }
        return num;
    }
    /* Returns the number of private vehicles in the Vehicle Park */

    public boolean inPark (Plate p){
        for(Object Vehicle : infrastructure){
            if(Vehicle instanceof Vehicle && ((Vehicle) Vehicle).getPlate().equals(p)){
                return true;
            }
        }
        return false;
    }
    /* Returns true if the vehicle park contains a vehicle with plate p */

    public void enter (Vehicle v) throws NullPointerException, AlreadyStoredException{
        if(v==null){
            throw new NullPointerException("Null parameter");
        }
        if(inPark(v.getPlate())){
            throw new AlreadyStoredException("Already there");
        }
        infrastructure.add(v);
    }
    /* Stores c in the VehiclePark, if possible.
    Throws (and does not store v):
        - a NullPointerException if the parameter is null
        - a AlreadyStoredException if the VehiclePark already contains a
          vehicle "like" v
    */

    public int enter (Collection vehicles){
        int stored = 0;
        for(Object Vehicle : vehicles){
            if(Vehicle instanceof Vehicle){
                if(!inPark(((Vehicle)Vehicle).getPlate())){
                    infrastructure.add(Vehicle);
                    stored++;
                }
            }
        }
        return stored;
    }
    /* Stores in the VehiclePark the vehicles contained in the parameter
    Beware: the parameter may contain objects that are not vehicles
    Beware: the parameter may contain null objects
    Beware: the parameter may contain repetitions

    Returns: the number of vehicles effectively stored

    This method does not throw exceptions
    */

    public boolean leave (Plate p){
        boolean removed=false;
        Iterator<Object> iterator = infrastructure.iterator();
        while(iterator.hasNext()){
            Object Vehicle = iterator.next();
            if(Vehicle instanceof Vehicle && ((Vehicle) Vehicle).getPlate().equals(p)){
                iterator.remove();
                removed=true;
            }
        }
        return removed;
    }
    /*
    Removes from VehiclePark all vehicles with Plate p
    Returns true if a vehicle has been removed. False otherwise
    */

    public Vehicle[] leave (String owner){
        List<Vehicle> removed = new ArrayList<>();
        Iterator<Object> iterator = infrastructure.iterator();
        while(iterator.hasNext()){
            Object Vehicle = iterator.next();
            if(Vehicle instanceof Vehicle && ((Vehicle) Vehicle).getOwner().equals(owner)){
                removed.add((Vehicle) Vehicle);
                iterator.remove();
            }
        }
        return removed.toArray(new Vehicle[0]);
    }
    /*
    Removes from VehiclePark all vehicles that "belong" to the given owner
    (parameter)
    Returns an array containing all the removed vehicles. This array:
        - has the exact length (no empty -null- positions)
        - has length 0 if no vehicles has been removed
        - is sorted according to the natural ordering of the vehicles (ascending)
    */

    public boolean containsDangerousPayload(){
        for(Object Vehicle : infrastructure){
            if(Vehicle instanceof CommercialVehicle && ((CommercialVehicle) Vehicle).containsDangerousPayload()){
                return true;
            }
        }
        return false;
    }
    /*
    Returns true if the VehiclePark contains any CommercialVehicle
    the payload of which is dangerous. False otherwise;
    */
}
