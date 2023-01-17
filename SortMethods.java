/**
 *	SortMethods - Sorts an array of Integers in ascending order.
 *
 *	@author 
 *	@since	
 */
public class SortMethods {
	
	/**
	 *	Bubble Sort algorithm - in ascending order
	 *	@param arr		array of Integer objects to sort
	 */
	
	/**
	 *	Swaps two Integer objects in array arr
	 *	@param arr		array of Integer objects
	 *	@param x		index of first object to swap
	 *	@param y		index of second object to swap
	 */
	private void swap(City[] arr, int x, int y) {
		City temp =arr[x];
		arr[x]= arr[y];
		arr[y] = temp;
	}
	
	/**
	 *	Selection Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 */
	public void selectionSort(City [] arr) {
		for(int i = arr.length- 1 ; i >0 ; i--){
			int m = 0;
			for(int j = 0 ; j <= i ; j++){
				if(arr[j].getPop().compareTo(arr[m].getPop()) >0 )
					m= j;
			}
			swap(arr, i , m);
		}
	}
	
	/**
	 *	Insertion Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 */
	public void insertionSort(City [] arr) {
		for(int i =1 ; i < arr.length ; i++){
			City num =arr[i] ;
			
			int j = i;
			while( j>0 && num.name.compareTo(arr[j-1].name)<0){
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = num;
		}
	}
	
	/**
	 *	Merge Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 */
	 public void merge(City [] arr , int start, int mid , int end){
		 int p1 = start;
		 int p2 = mid;
		 City[] newarr = new City[end -start];
		 
		 for(int i = 0 ; i < newarr.length; i++){
			 if( p1 == mid ){
				newarr[i] = arr[p2 ];
				p2++;
			}else if (p2 == end){
				newarr[i] = arr[p1];
				p1++;
			}else 
			 if(arr[p1].compareTo( arr[p2])>0){
				newarr[i] = arr[p1];
				p1++;
			}
			 else {
				newarr[i] = arr[p2 ];
				p2++;
			}
		}
		 
		 
		for(int i = start ; i < end; i++){
			arr[i] = newarr[i-start];
			
		} 
		 
	}
	/**
	 * Merge Sort accending
	 */
	public void mergeAcc(City [] arr , int start, int mid , int end){
		 int p1 = start;
		 int p2 = mid;
		 City[] newarr = new City[end -start];
		 
		 for(int i = 0 ; i < newarr.length; i++){
			 if( p1 == mid ){
				newarr[i] = arr[p2 ];
				p2++;
			}else if (p2 == end){
				newarr[i] = arr[p1];
				p1++;
			}else 
			 if(arr[p1].compareTo( arr[p2])<0){
				newarr[i] = arr[p1];
				p1++;
			}
			 else {
				newarr[i] = arr[p2 ];
				p2++;
			}
		}
		 
		 
		for(int i = start ; i < end; i++){
			arr[i] = newarr[i-start];	
		}	 
	}
	
	/**
	 * Merge two sorted arrays by name
	 */
	 public void mergeByName(City [] arr , int start, int mid , int end){
		 int p1 = start;
		 int p2 = mid;
		 City[] newarr = new City[end -start];
		 
		 for(int i = 0 ; i < newarr.length; i++){
			 if( p1 == mid ){
				newarr[i] = arr[p2 ];
				p2++;
			}else if (p2 == end){
				newarr[i] = arr[p1];
				p1++;
			}else 
			 if(arr[p1].name.compareTo( arr[p2].name)>0){
				newarr[i] = arr[p1];
				p1++;
			}
			 else {
				newarr[i] = arr[p2 ];
				p2++;
			}
		}
		 
		 
		for(int i = start ; i < end; i++){
			arr[i] = newarr[i-start];
			
		} 
		 
	}
	
	public void mergesortMethod(City [] arr , int start , int end){
		int mid = (end+ start)/2;
		if(mid == start) {
			return;
		}
		mergesortMethod(arr, start , mid);
		mergesortMethod(arr, mid , end);
		
		merge( arr, start , mid , end);
		
	}
	public void mergesortMethodAcc(City [] arr , int start , int end){
		int mid = (end+ start)/2;
		if(mid == start) {
			return;
		}
		mergesortMethodAcc(arr, start , mid);
		mergesortMethodAcc(arr, mid , end);
		
		mergeAcc( arr, start , mid , end);
		
	}
	public void mergesortMethodByName(City [] arr , int start , int end){
		int mid = (end+ start)/2;
		if(mid == start) {
			return;
		}
		mergesortMethodByName(arr, start , mid);
		mergesortMethodByName(arr, mid , end);
		
		mergeByName( arr, start , mid , end);
		
	}
	public void mergeSort(City [] arr) {
		mergesortMethod(arr, 0 , arr.length);
		
	}
	public void mergeSortAcc(City [] arr) {
		mergesortMethodAcc(arr, 0 , arr.length);
		
	}
	
	public void mergeSortByName(City [] arr) {
		mergesortMethodByName(arr, 0 , arr.length);
		
	}
	/*****************************************************************/
	/************************* For Testing ***************************/
	/*****************************************************************/
	
	/**
	 *	Print an array of Integers to the screen
	 *	@param arr		the array of Integers
	 */
	public void printArray(Integer[] arr) {
		if (arr.length == 0) System.out.print("(");
		else System.out.printf("( %4d", arr[0]);
		for (int a = 1; a < arr.length; a++) {
			if (a % 10 == 0) System.out.printf(",\n  %4d", arr[a]);
			else System.out.printf(", %4d", arr[a]);
		}
		System.out.println(" )");
	}

	public static void main(String[] args) {
		SortMethods se = new SortMethods();
	}
	
}
