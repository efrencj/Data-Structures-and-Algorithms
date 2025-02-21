package pr2;

import java.util.*;

public interface AirRegister {
	
	/* Adds the given company to the register. 
	If the company already exists in the register,
	this method does nothing and just returns false. 
	If the company does not exist, it is registered 
	and the method returns true. */
	public boolean addCompany (Company c);
	
	/* Registers the given aircraft for the given company.
	Throws UnknownCompanyException if the company is not already
	registered
	Throws DifferentComapanyException if the aircraft is already registered
	to another company
	Returns false if the aircraft is already registered to the given company
	and true otherwise;*/
	public boolean registerAircraft (Company c, Aircraft a);
	
	/* Returns the company owning the aircraft with the given id.
	Returns null if no company owns an aircraft with the given id*/
	public Company findCompany (AircraftID id);
	
	/* returns all the aircrafts registered to the given company.
	The result is an empty set if the company is unknown or has
	no aircrafts registered. The resulting set is sorted by
	aircraft year, ascending */
	public SortedSet<Aircraft> registeredAircrafts (Company c);
	
	/* Returns all the companies that own an aircraft (or more) 
	   of the given type. The resulting set is sorted by natural 
	   ordering */
	public SortedSet<Company> findCompanyByType (AircraftType t);

}
