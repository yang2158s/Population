import java.util.List;
import java.util.ArrayList;
/**
 *	Population - <description goes here>
 *
 *	Requires FileUtils and Prompt classes.
 *
 *	@author	Yi Yang Hsu
 *	@since	1/17/22
 */
import java.util.Scanner;
public class Population {
	// List of cities
	private ArrayList<City> cities;
	
	// US data file
	private final String DATA_FILE = "usPopData2017.txt";
	
	
	/**	Prints the introduction to Population */
	public void printIntroduction() {
		System.out.println("   ___                  _       _   _");
		System.out.println("  / _ \\___  _ __  _   _| | __ _| |_(_) ___  _ __ ");
		System.out.println(" / /_)/ _ \\| '_ \\| | | | |/ _` | __| |/ _ \\| '_ \\ ");
		System.out.println("/ ___/ (_) | |_) | |_| | | (_| | |_| | (_) | | | |");
		System.out.println("\\/    \\___/| .__/ \\__,_|_|\\__,_|\\__|_|\\___/|_| |_|");
		System.out.println("           |_|");
		System.out.println();
	}
	
	/**	Print out the choices for population sorting */
	public void printMenu() {
		System.out.println("1. Fifty least populous cities in USA (Selection Sort)");
		System.out.println("2. Fifty most populous cities in USA (Merge Sort)");
		System.out.println("3. First fifty cities sorted by name (Insertion Sort)");
		System.out.println("4. Last fifty cities sorted by name descending (Merge Sort)");
		System.out.println("5. Fifty most populous cities in named state");
		System.out.println("6. All cities matching a name sorted by population");
		System.out.println("9. Quit");
	}
	public static void main(String args[]){
		Population a = new Population();
	}
	public Population(){
		
		//Initialize Variables
		SortMethods se = new SortMethods();
		Scanner in = new Scanner(System.in);
		Scanner file = FileUtils.openToRead(DATA_FILE).useDelimiter("[\t\n]");
		City[] arr = null;
		City[] newarr = null;
		long startMillisec=0;
		long endMillisec=0;
		System.out.println("Loading Data...");
		cities = new ArrayList<City>();
		while(file.hasNext()){
			City temp = new City();
			temp.state = file.next();
			temp.name = file.next();
			temp.designation = file.next();
			temp.population = file.nextInt();
			cities.add(temp);
		}
		printIntroduction();
		while(true){
			
			arr = City.toArray(cities);
			newarr = new City[50];
			startMillisec=0;
			endMillisec=0;
			printMenu();
			int selected=0;
			while(selected==0 ){ 
				try{
					System.out.println("Enter Selection :");
					 selected = Integer.parseInt(in.next());
				}catch(Exception e){
					System.out.println("Invalid try again");
				}
			}
			switch(selected){
				case 1 : 
				
					//Sorts entire list and getting the first 50 by resizing
					startMillisec = System.currentTimeMillis();
					
					if(arr.length != 0)
					se.selectionSort(arr);
					endMillisec = System.currentTimeMillis();
					arr= resize(arr,50);
					break;
				case 2 : 
					
					//Sorts entire list and getting the first 50 by resizing
					startMillisec = System.currentTimeMillis();
					if(arr.length != 0)
						se.mergeSort(arr);
					 endMillisec = System.currentTimeMillis();
					arr= resize(arr,50);
					break;
				case 3 : 
				
					startMillisec = System.currentTimeMillis();
					
					//Sorts array with the 50 first cities
					if(arr.length != 0)
						se.insertionSort(arr);
					//Gets first 50 cities and stores it within new arr
					for(int i = 0 ; i < 50 ; i ++){
						newarr[i]= arr[i];
					}
					arr= newarr;
					endMillisec = System.currentTimeMillis();
					break;
				
				case 4 : 
					
					startMillisec = System.currentTimeMillis();
					
					//Sorts array 
					if(arr.length != 0)
						se.mergeSortByName(arr);
					endMillisec = System.currentTimeMillis();
					//Gets last 50 cities in the array and stores it
					for(int i = 0 ; i < 50 ; i ++){
						newarr[i]= arr[arr.length-i-1];
					}
					arr= newarr;
					arr= resize(arr,50);
					break;
				case 5 : 
					
					System.out.println("Name a state : ");
					String promptState = in.next().trim();
					int statesFound = 0;
					
					//Finds states with the input name and stores it into an array
					for(int i = 0 ; i<arr.length && statesFound<50; i ++){
						
						if(arr[i].state.trim().equalsIgnoreCase(promptState))
						{
							newarr[statesFound]= arr[i];
							statesFound++;
						}
					}
					
					//Move the array of found cities to the array to sort
					arr= new City[statesFound];
					for(int i = 0 ; i < statesFound ; i ++){
						arr[i]= newarr[i];
					}
					
					startMillisec = System.currentTimeMillis();
					
					if(arr.length != 0)
						se.mergeSort(arr);
					endMillisec = System.currentTimeMillis();
					break;
				case 6 : 
					System.out.println("Name a city : ");
					String promptCity = in.next().trim();
					int citiesFound = 0;
					
					//Finds the cities with the name of the designated name
					for(int i = 0 ; i<arr.length ; i ++){
						
						if(arr[i].name.trim().equalsIgnoreCase(promptCity))
						{
							newarr[citiesFound]= arr[i];
							citiesFound++;
						}
					}
					arr= new City[citiesFound];
					for(int i = 0 ; i < citiesFound ; i ++){
						arr[i]= newarr[i];
					}
					startMillisec = System.currentTimeMillis();
					if(arr.length != 0)
					se.mergeSort(arr);
					endMillisec = System.currentTimeMillis();
					break;
				case 9: 
					file.close();
					in.close();
					System.out.println("\nThanks for using Population!");
					return;
				default: // If an non-option is selected
					arr= null;
			}
			
			
			//Checks if a option is selected based off of if arr is null
			if(arr!= null){
				
				//Prints time
				System.out.printf("Time Elapsed : %dms\n",(endMillisec - startMillisec));
				
				//If nothing is there to print
				if(arr.length == 0)
					System.out.println("No Objects within Parameters");
				
				//Prints the cities in order
				for(int i = 0 ; i < arr.length; i++){
					if(arr[i] != null)
					System.out.printf("%80s\n",(i+1) + ": " +arr[i].toString());
				}
			}else
				System.out.println("Invalid Option Try Again");
		}
		
	}
	
	/**
	 * Resizes an array to it's target size
	 * @param City[] arr 	Input array
	 * @param int target  	target size
	 * @return newarr 		Resized array
	 */
	private City[] resize(City[] arr , int target){
		
		City[] newarr= new City[target];
		for(int i = 0 ; i<target; i++)
			//If the target size is more than the array length then just duplicate the last object in array
			if( arr.length >i ) 
				newarr[i] = arr[i];
			else
				newarr[i] = arr[arr.length -1];
		return newarr;
	}
}
