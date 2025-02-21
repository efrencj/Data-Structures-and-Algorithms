package prac1;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// PLATE = (PLACA DE) MATRICULA

public class Plate implements Comparable, Cloneable {

	private static final int MIN_AREA_CODE = 1;
	private static final int MAX_AREA_CODE = 6;

	private int areaCode;
	private String prefix;
	private String suffix;

	public Plate (int areaCode, String prefix, String suffix) {
		checkParams(areaCode, prefix, suffix);
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.suffix = suffix;
	}

	public int getAreaCode() {
		return areaCode;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public boolean checkParams (int areaCode, String prefix, String suffix) {
		if(areaCode < MIN_AREA_CODE || areaCode > MAX_AREA_CODE) throw new IllegalArgumentException("Illegal area code");
		String regex="\\d{4}";
		if (prefix == null || !prefix.matches("\\d{4}")) {
			throw new IllegalArgumentException("Illegal prefix");
		}

		if(suffix==null||!suffix.matches("[a-zA-Z]{3}")) {
            throw new IllegalArgumentException("Illegal suffix");
        }

		return true;
		/* Check that the parameters are correct. Return an exception if any parameter is incorrect
		   - areCode must be between MIN_AREA_CODE and MAX_AREA_CODE
		   - prefix is a String but the content is really a number with only 4 digits
		   - suffix must be all letters, no numbers and only of 3 letters
        */
		/* COMPLETE */
	}

	@Override
	public int compareTo (Object other) {
		if(other==null) throw new NullPointerException("Cannot compare to null");
		if(!(other instanceof Plate)) throw new ClassCastException("That is not a plate");

		if(this.areaCode>((Plate) other).getAreaCode()) return 1;
		else if(this.areaCode<((Plate) other).getAreaCode()) return -1;


		if(Integer.parseInt(this.prefix)<Integer.parseInt(((Plate) other).getPrefix())) return -1;
		else if (Integer.parseInt(this.prefix)>Integer.parseInt(((Plate) other).getPrefix())) return 1;

		return this.suffix.compareTo(((Plate) other).getSuffix());



        /* this is how plates are sorted:
        first go plates with lower area codes. If they have the same area code...
        ... first go plates with a lower prefix. If they have the same prefix...
        ... first go plates with a lower suffix.
        */

		/* COMPLETE */
	}

	@Override
	public boolean equals (Object other) {
		/* COMPLETE */
		if(other==null) throw new NullPointerException("Cannot compare to null");
		if(!(other instanceof Plate)) throw new ClassCastException("That is not a plate");
		if(this.areaCode != ((Plate) other).getAreaCode()) return false;
		if(!(this.prefix.equals(((Plate) other).getPrefix()))) return false;
        return this.suffix.equals(((Plate) other).getSuffix());
    }
}
