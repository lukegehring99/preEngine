package engine;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

// Imports the data from a excel sheet with the specified guidelines
public class DataImport {
	
	private String address;
	
	//Takes a excel sheet, creates a Sport object, creates all the game objects
	//Adds all of the game objects to GameField
	public DataImport(String address)
	{
		this.address = address;
	}
	
	
	public Sport deserialzeSport() {

		Sport sport = null;

		FileInputStream fin = null;
		ObjectInputStream ois = null;

		try {

			fin = new FileInputStream(address);
			ois = new ObjectInputStream(fin);
			sport = (Sport) ois.readObject();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		return sport;
	}
	
}
