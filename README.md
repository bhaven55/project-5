Project 5:

implementing java program where graphics content will be used to calculate 
different types of Hamming Distances.

no overall source code is provided for this project.

There are four classes created to run this program:
CalculateHD
HammingDistFrame
ShowStation
StationList

class 1: CalculateHD

There are four private fields for this class which contains
the amount of Station that have the Hamming Distance 1,2,3, and 4

* distance1
* distance2
* distance3
* distance4

one constructor: public CalculateHD
reads in the file Mesonet.txt file and then it calculates the hamming 
Distance.
Afterward, it increments one of the four distances appropriately.
at last it closes the file. Try and catch blocks are used becuase of 
BufferedReader.


four methods:
* getDistance1
* getDistance2
* getDistance3
* getDistance4

Method 1: getDistance1
returns the value of Distance1

Method 2: getDistance2
returns the value of Distnace2

Method 3: getDistance3
returns the value of Distnace3

Method 4: getDistance4
returns the value of Distance4

** End of the Class CalculateHD **

Class 2: ShowStation

There are two private fields for this class:
* hammingDist
* STID

hammingDist stores the value given by the slider
STID stores the value given by the ComboBox

one Constructor: ShowStation(int HammingDist, String STID)
hammingDist stored into hammingDist and STID is stored in the local field 
STID

one method:
* citiesWithSameHammingDist()

Method 1: citiesWithSameHammingDist()
creates a new arrayList that will be returned at the end.

reads in the file Mesonet.txt

calculates the hamming distance. if the hamming distance of the station 
matches the hammingDist then it adds it to the StationIDs arrayList. This 
method uses try and catch block because of BufferedReader. At Last, it 
return the arrayList StationIDs.

** End of the Class ShowStation **

Class 3: StationList

There is one private field for this class:
* ArrayList<String> StationID

StationID field will present the station in the DisplayStation textArea

There is one constructor for this class:
* public StationList()

StationList constructor reads the file Mesonet.txt and adds all the Stations 
into the StationID arrayList. Try and catch blocks are used because of 
BufferedReader.

There are three method for this class:
* public ArrayList<String> getList()
* public boolean addToTheList(String STID)
* public DefaultComboBoxModel<String> getComboBoxModel(List<String> data)

method 1: getList()
returns the StationID arrayList

method 2: addToTheList(String STID)
changes the STID string to uppercase and then checks to see if the STID is 
four characters long. If STID is not 4 characters long, then it returns 
false. If it is 4 characters long then it adds it to the StationID arrayList 
and returns true.

method 3: getComboBoxModel(List<String> data)
gets all the Strings from the List data and adds it to another 
arrayList called displayStations and taht arrayLsit is changed into String[] 
comboBoxModel. finally, a new DefaultComboBoxModel<>(comboBoxModel) is 
returned.

** End of Class Station List **

class 4: HammingDistFrame

This class contains the GUI. It has all the panels and componenets in order 
for the program to run.
