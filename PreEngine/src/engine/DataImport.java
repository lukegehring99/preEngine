package engine;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class DataImport {
	
	private String address;
	
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
