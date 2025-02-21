package prac4.ex2;

/* The code in this class cannot be modified in any way */

public class Owner {

	private String name;
	private int id;
	private boolean individualProperty;

	public Owner(String name, int id, boolean individualProperty) {
		this.name = name;
		this.id = id;
		this.individualProperty = individualProperty;
	}

	public String getName() {return name;}

	public int getId() {return id;}

	public boolean isIndividualProperty() {return individualProperty;}

	public String toString () {
		return name+" ("+id+") individual property: "+(individualProperty?"yes":"no");
	}

	@Override
	public boolean equals(Object other) {
		//COMPLETE
		if (this == other) {
			return true;
		}
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		Owner owner = (Owner) other;
		return id == owner.id &&
				individualProperty == owner.individualProperty &&
				name.equals(owner.name);
	}
}