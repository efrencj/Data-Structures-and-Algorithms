package pr2;

import java.util.*;

public class AirRegisterImp implements AirRegister{
    private Map<Company, Set<Aircraft>> register;
    public AirRegisterImp() {
        register= new HashMap<>();
    }
    /* Adds the given company to the register.
	If the company already exists in the register,
	this method does nothing and just returns false.
	If the company does not exist, it is registered
	and the method returns true. */
    public boolean addCompany (Company c){
        return register.putIfAbsent(c, new HashSet<>()) == null;
    }

    /* Registers the given aircraft for the given company.
    Throws UnknownCompanyException if the company is not already
    registered
    Throws DifferentComapanyException if the aircraft is already registered
    to another company
    Returns false if the aircraft is already registered to the given company
    and true otherwise;*/
    public boolean registerAircraft(Company c, Aircraft a) {
        if (!register.containsKey(c)) {
            throw new UnknownCompanyException("Company does not exist");
        }
        for (Map.Entry<Company, Set<Aircraft>> entry : register.entrySet()) {
            if (!entry.getKey().equals(c) && entry.getValue().contains(a)) {
                throw new DifferentCompanyException("Aircraft already belongs to another comapany");
                //encara que comapany estigui mal escrit, ho he escrit així per evitar errors en el test
            }
        }
        Set<Aircraft> aircrafts = register.get(c);
        if (aircrafts.contains(a)) {
            return false;
        } else {
            aircrafts.add(a);
            return true;
        }
    }


    /* Returns the company owning the aircraft with the given id.
    Returns null if no company owns an aircraft with the given id*/
    public Company findCompany (AircraftID id){
        for (Map.Entry<Company, Set<Aircraft>> entry : register.entrySet()) {
            for (Aircraft aircraft : entry.getValue()) {
                if (aircraft.getId().equals(id)) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    /* returns all the aircrafts registered to the given company.
    The result is an empty set if the company is unknown or has
    no aircrafts registered. The resulting set is sorted by
    aircraft year, ascending */
    public SortedSet<Aircraft> registeredAircrafts (Company c){
        Set<Aircraft> aircrafts = register.get(c);
        if (aircrafts == null) {
            return null; // Company is unknown
        } else {
            SortedSet<Aircraft> result = new TreeSet<>(Comparator.comparingInt(Aircraft::getYear));
            result.addAll(aircrafts);
            return result;
        }
    }

    /* Returns all the companies that own an aircraft (or more)
       of the given type. The resulting set is sorted by natural
       ordering */
    public SortedSet<Company> findCompanyByType (AircraftType t){
        SortedSet<Company> result = new TreeSet<>();
        for (Map.Entry<Company, Set<Aircraft>> entry : register.entrySet()) {
            for (Aircraft aircraft : entry.getValue()) {
                if (aircraft.getType() == t) {
                    result.add(entry.getKey());
                    break; // Once a company with the desired type is found, exit the loop
                }
            }
        }
        return result;
    }
}
