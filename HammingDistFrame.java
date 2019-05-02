import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class HammingDistFrame extends JFrame
{
	
	//Add the componenet I will need
	private JLabel EnterHammingDist = new JLabel("Enter Hamming Dist:");
	private JTextField DisplayHammingDist = new JTextField();
	private JSlider hammingDist = new JSlider(1, 4, 1);
	private JButton ShowStationButton = new JButton("Show Station");
	private JTextArea DisplayStations = new JTextArea();
	private JLabel initalStation = new JLabel("Compare with:");
	private JComboBox<String> listOfStations = new JComboBox<>();
	private JButton CalculateHDButton = new JButton("Calculate HD");
	private JLabel Distance0 = new JLabel("Distance 0");
	private JTextField Answer0 = new JTextField();
	private JLabel Distance1 = new JLabel("Distance 1");
	private JTextField Answer1 = new JTextField();
	private JLabel Distance2 = new JLabel("Distance 2");
	private JTextField Answer2 = new JTextField();
	private JLabel Distance3 = new JLabel("Distance 3");
	private JTextField Answer3 = new JTextField();
	private JLabel Distance4 = new JLabel("Distance 4");
	private JTextField Answer4 = new JTextField();
	private JButton AddStationButton = new JButton("Add Station");
	private JTextField nameToBeAdded = new JTextField();
	
	//This will be on the Right Panel
	private JLabel errorLabel = new JLabel("Message Box:");
	private JTextField errorMessage = new JTextField();
	
	/**
	 * Constructor That makes this entire code run. Has all components
	 */
	public HammingDistFrame()
	{
		//the frame will be divided into two parts: left and right side
		this.setLayout(new GridLayout(1,2));
		
		//these are the two sides of the frame
		JPanel leftSide = new JPanel(new GridLayout(8,1));
		JPanel rightSide = new JPanel(new GridLayout(2,1));
		
		//left-side has eight rows.
		JPanel row1 = new JPanel(new GridLayout(1,2));
		JPanel row2 = new JPanel(new GridLayout(1,1));
		JPanel row3 = new JPanel(new GridLayout(1,1));
		JPanel row4 = new JPanel(new GridLayout(1,1));
		JPanel row5 = new JPanel(new GridLayout(1,2));
		JPanel row6 = new JPanel(new GridLayout(1,1));
		JPanel row7 = new JPanel(new GridLayout(5,2));
		JPanel row8 = new JPanel(new GridLayout(1,2));
		
		//compute the data for all the components.
		
		//Computing data for the Slider
		hammingDist.setMajorTickSpacing(1);
		hammingDist.setPaintLabels(true);
		hammingDist.addChangeListener((e) -> {
			
			//setting the text for EnterHammingDist.
			DisplayHammingDist.setText("" + hammingDist.getValue());
		});
		
		//EnterHammingDist should not be editable
		DisplayHammingDist.setEditable(false);
		
		//All the Distances are suppose to be uneditable as well
		Answer0.setEditable(false);
		Answer1.setEditable(false);
		Answer2.setEditable(false);
		Answer3.setEditable(false);
		Answer4.setEditable(false);
		
		//The TextArea that displays Stations should also be uneditable
		DisplayStations.setEditable(false);
		
		//add dropdown menu
		StationList stations = new StationList();
		ArrayList<String> listStations = stations.getList();
		listOfStations.setModel(stations.getComboBoxModel(listStations));
		listOfStations.setSelectedIndex(0);
		
		//Setting the text for all the distance
		CalculateHDButton.addActionListener((e) -> {
			CalculateHD distanceCaluclator = new CalculateHD(listOfStations.getSelectedItem().toString());
			Answer0.setText("" + 1);
			Answer1.setText("" + distanceCaluclator.getDistance1());
			Answer2.setText("" + distanceCaluclator.getDistance2());
			Answer3.setText("" + distanceCaluclator.getDistance3());
			Answer4.setText("" + distanceCaluclator.getDistance4());
		});
		
		// making the showStation button work
		ShowStationButton.addActionListener((e) -> {
			DisplayStations.setText(null);
			ShowStation StationsForTA = new ShowStation(hammingDist.getValue(), listOfStations.getSelectedItem().toString());
			
			ArrayList<String> dataList = StationsForTA.citiesWithSameHammingDist();
			
			for(int i = 0; i < dataList.size(); ++i)
			{
				DisplayStations.setText(DisplayStations.getText() + '\n' + dataList.get(i));
			}
		});
		
		//When the button AddStation is pressed, then this code goes off.
		AddStationButton.addActionListener((e) -> {
			boolean results = stations.addToTheList(nameToBeAdded.getText());
			if(!results)
			{
				errorMessage.setText("Could not add to the list.");
			}
			else
			{
				ArrayList<String> newStationList = stations.getList();
				listOfStations.setModel(stations.getComboBoxModel(newStationList));
				listOfStations.setSelectedIndex(0);
				errorMessage.setText("New station added to the list.");
			}
			
		});
		
		//Scrollbar that contain the DisplayStaions areaText within it. 
		JScrollPane scrollPane = new JScrollPane(DisplayStations, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		//add everything to the rows on the left side
		//adding to row 1
		row1.add(EnterHammingDist);
		row1.add(DisplayHammingDist);
		
		//adding to row 2
		row2.add(hammingDist);
		
		//adding to row 3
		row3.add(ShowStationButton);
		
		//adding to row 4
		row4.add(scrollPane);
		
		//adding to row 5
		row5.add(initalStation);
		row5.add(listOfStations);
		
		//adding to row 6
		row6.add(CalculateHDButton);
		
		//adding to row 7
		row7.add(Distance0);
		row7.add(Answer0);
		row7.add(Distance1);
		row7.add(Answer1);
		row7.add(Distance2);
		row7.add(Answer2);
		row7.add(Distance3);
		row7.add(Answer3);
		row7.add(Distance4);
		row7.add(Answer4);
		
		//adding to row 8
		row8.add(AddStationButton);
		row8.add(nameToBeAdded);
		
		//add all 8 rows to the left side
		leftSide.add(row1);
		leftSide.add(row2);
		leftSide.add(row3);
		leftSide.add(row4);
		leftSide.add(row5);
		leftSide.add(row6);
		leftSide.add(row7);
		leftSide.add(row8);
		
		//Add the components to the Right side
		rightSide.add(errorLabel);
		rightSide.add(errorMessage);
		
		//adds all the compoenent to the main frame
		this.add(leftSide);
		this.add(rightSide);
		this.setTitle("Hamming Distance");
		this.setSize(550, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		//runs the actual program.
		HammingDistFrame HDF = new HammingDistFrame();
	}
}