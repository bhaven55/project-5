import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CalculateHD 
{
	//these will contain the amount of Stations that have the Hamming Distance 1,2,3, and 4
	private int distance1;
	private int distance2;
	private int distance3;
	private int distance4;
	
	/**
	 * assigns each distance with the starting result of 0.
	 * and it reads in the file mesonet.txt
	 * afterwards, it calculates the distance
	 * and adds one to the appropriate distance
	 * 
	 * @param StationID
	 */
	public CalculateHD(String StationID)
	{
		this.distance1 = 0;
		this.distance2 = 0;
		this.distance3 = 0;
		this.distance4 = 0;
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
			
			String strg = br.readLine(); // the line we want;
			
			while(strg != null)
			{
				int counter = 0;
				
				for(int i = 0; i < StationID.length(); ++i)
				{
					char[] list1 = strg.toCharArray();
					char[] list2 = StationID.toCharArray();
					if(list1[i] != list2[i])
					{
						counter++;
					}
				}
	
				if(counter == 1) 
				{
					this.distance1++;
				}
				if(counter == 2)
				{
					this.distance2++;
				}
				if(counter == 3)
				{
					this.distance3++;
				}
				if(counter == 4)
				{
					this.distance4++;
				}
				else if(counter > 4)
				{
					
				}
				
				//reads the next Line in the file
				strg = br.readLine();
			}
			
				// closes the BufferedReader
				br.close();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return distance1
	 */
	public int getDistance1() 
	{
		return distance1;
	}

	/**
	 * 
	 * @return distance2
	 */
	public int getDistance2() 
	{
		return distance2;
	}

	/**
	 * 
	 * @return distance3
	 */
	public int getDistance3() 
	{
		return distance3;
	}

	/**
	 * 
	 * @return distnace4
	 */
	public int getDistance4() 
	{
		return distance4;
	}
	
	
}
