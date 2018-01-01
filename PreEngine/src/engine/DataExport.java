package engine;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DataExport 
{
	private String address;
	
	public DataExport(String location)
	{
		this.address = location;
	}

	public void serializeSport(Sport sport) 
	{

		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		String name = sport.getName();

		try {
			fout = new FileOutputStream(address + name + ".spr");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(sport);


		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
