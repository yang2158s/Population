import java.util.List;
/**
 *	City data - the city name, state name, location designation,
 *				and population est. 2017
 *
 *	@author	
 *	@since	
 */
public class City implements Comparable<City> {
	
	// fields
	public String state,name,designation;
	public int population;
	// constructor
	
	/**	Compare two cities populations
	 *	@param other		the other City to compare
	 *	@return				the following value:
	 *		If populations are different, then returns (this.population - other.population)
	 *		else if states are different, then returns (this.state - other.state)
	 *		else returns (this.name - other.name)
	 */
	 public static City[] toArray(List<City> arr){
		City[] newarr = new City[arr.size()];
		for(int i = 0; i < newarr.length; i++){
			newarr[i] = arr.get(i);
		}
		return newarr;
	}
	 public Integer getPop(){
			return population;
	}
	public int compareTo(City other ){
		if(this.population!= other.population)
			return (this.population - other.population);
		if(this.state.equals(other.state))
			return (this.state.compareTo(other.state));
		return this.name.compareTo(other.name);
	}
	
	/**	Equal city name and state name
	 *	@param other		the other City to compare
	 *	@return				true if city name and state name equal; false otherwise
	 */
	
	/**	Accessor methods */
	
	/**	toString */
	@Override
	public String toString() {
		return String.format("%-22s %-22s %-12s %,12d", state, name, designation,
						population);
	}
}
