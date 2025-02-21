package prac4.ex2;

import java.util.*;
import java.io.*;

public class PropertyRegistry {

	private static final String MARK_END_PROPS = "1234567890_end_props";

	// This attribute cannot be modified or new ones added.
	private Map<Residence, List<Owner>> infrastructure;

	public PropertyRegistry() {
		// This constructor code cannot be modified
		infrastructure = new TreeMap<Residence, List<Owner>>(new Comparator<Residence>() {
			public int compare(Residence h1, Residence h2) {
				if (h1.getSurfaceArea() > h2.getSurfaceArea()) return 1;
				else if (h1.getSurfaceArea() < h2.getSurfaceArea()) return -1;
				else return 0;
			}
		});
	}

	public void dumpToBinFile(File binFile) throws IOException {
		DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(binFile)));
		List<Owner> owners;

		for (Residence h : this.infrastructure.keySet()) {
			output.writeDouble(h.getSurfaceArea());
			output.writeInt(h.getRooms());
			output.writeUTF(h.getAddress());
			owners = this.infrastructure.get(h);
			for (Owner p : owners) {
				output.writeUTF(p.getName());
				output.writeInt(p.getId());
				output.writeBoolean(p.isIndividualProperty());
			}
			output.writeUTF(PropertyRegistry.MARK_END_PROPS);
		}

		output.close();
	}

	public void loadFromBinFile(File binFile) throws IOException {
		this.infrastructure.clear();

		DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(binFile)));

		try {
			while (input.available() > 0) {
				double surfaceArea = input.readDouble();
				int rooms = input.readInt();
				String address = input.readUTF();
				Residence residence = new Residence(address, rooms, surfaceArea);
				List<Owner> owners = new ArrayList<>();

				while (true) {
					String name = input.readUTF();
					if (name.equals(MARK_END_PROPS)) {
						break;
					}
					int id = input.readInt();
					boolean individualProperty = input.readBoolean();
					owners.add(new Owner(name, id, individualProperty));
				}

				infrastructure.put(residence, owners);
			}
		} catch (EOFException e) {
			// Handle EOFException which signals the end of the stream
		} finally {
			input.close();
		}
	}

	public void dumpToTextFile(File textFile) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(textFile));

		for (Map.Entry<Residence, List<Owner>> entry : infrastructure.entrySet()) {
			Residence residence = entry.getKey();
			List<Owner> owners = entry.getValue();
			owners.sort(Comparator.comparing(Owner::getName));

			writer.write(residence.getAddress());
			writer.newLine();
			writer.write(String.valueOf(residence.getRooms()));
			writer.newLine();
			writer.write(String.valueOf(residence.getSurfaceArea()));
			writer.newLine();
			writer.write(String.valueOf(owners.size()));
			writer.newLine();

			for (Owner owner : owners) {
				writer.write(owner.getName());
				writer.newLine();
				writer.write(String.valueOf(owner.getId()));
				writer.newLine();
				writer.write(owner.isIndividualProperty() ? "Yes" : "No");
				writer.newLine();
			}
		}

		writer.close();
	}
}
