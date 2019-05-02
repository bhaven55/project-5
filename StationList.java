import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

public class StationList 
{
	//this will be used to present stations in the DisplayStations textarea
	private ArrayList<String> StationID = new ArrayList<String>();
	
	/**
	 * reads in the txt file and then adds to the arrayList the stations meets the hamming distance
	 */
	public StationList()
	{
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
	
			String strg = br.readLine(); // the line we want;
			
			while(strg != null)
			{	
				this.StationID.add(strg);
				
				strg = br.readLine(); // reads the new line
			}
			
			br.close();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return StationID
	 */
	public ArrayList<String> getList()
	{
		return this.StationID;
	}
	
	/**
	 * changes to STID to upper case and then checks to see if it meets the requirements to be added.
	 * the value is added to the StationID arraylist
	 * 
	 * @param STID
	 * @return true
	 */
	public boolean addToTheList(String STID)
	{
		String newStation = STID.toUpperCase();
		
		if(STID.length() != 4)
		{
			return false;
		}
		else
		{
			this.StationID.add(newStation);
			return true;
		}
	}
	
	/**
	 * this is how the dropdown menu works
	 * @param data
	 * @return new DefaultComboBoxModel<>(comboBoxModel);
	 */
	public DefaultComboBoxModel<String> getComboBoxModel(List<String> data)
	{
		ArrayList<String> displayStations = new ArrayList<String>();
		for(String station: data)
		{
			displayStations.add(station);
		}
		String[] comboBoxModel = displayStations.toArray(new String[displayStations.size()]);
	    return new DefaultComboBoxModel<>(comboBoxModel);
	}
}
