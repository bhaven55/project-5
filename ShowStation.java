import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ShowStation 
{
	//these two fields will be used to show station with the hamming distance requested.
	private int hammingDist;
	private String STID;
	
	/**
	 * 
	 * @param hammingDist
	 * @param STID
	 */
	public ShowStation(int hammingDist, String STID)
	{
		this.hammingDist = hammingDist;
		this.STID = STID;
	}
	
	/**
	 * 
	 * @return StationIDs: arrayList that contains stations with the hamming distance required.
	 */
	public ArrayList<String> citiesWithSameHammingDist()
	{
		ArrayList<String> StationIDs = new ArrayList<String>();
		
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
			
			String STID1 = br.readLine(); // the line we want;
			
			while(STID1 != null)
			{
				int counter = 0;
				
				for(int i = 0; i < STID1.length(); ++i)
				{
					char[] list1 = this.STID.toCharArray();
					char[] list2 = STID1.toCharArray();
					if(list1[i] != list2[i])
					{
						counter++;
					}
				}
				
				//checks to see if the the  STID has the same HammingDist that is required
				if(counter == this.hammingDist)
				{
					//adds the station ID if the HammingDist meets the requirements
					StationIDs.add(STID1);
				}
					
				STID1 = br.readLine();
			}
			br.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return StationIDs;
	}
}
