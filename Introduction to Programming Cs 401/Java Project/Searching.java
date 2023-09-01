
public class Searching<T extends Comparable<T>> {
	int numSteps;////variable to hold number of steps
	
	void resetNumSteps(){
		this.numSteps=0;//Method to reset number of steps
	}
	
	int linearSearch(T[] ar,T target,int n){   //Method to implement linear search
		for(int i=0;i<n;i++) {		//Looping over all the elements
			if(ar[i].compareTo(target)==0) {//Comparing the element is target or not
				
				return i;//returning index if it is present
			}
			numSteps++;
			}
		return -1; //return -1 if the element is not present in the array
		
	}	
	
	 int binarySearch(T ar[], int left, int right, T target)//Metho to implement binary search recursively
	    {
	        if (right >= left) {		//Making sure right>left else return -1
	            int mid = left + (right - left) / 2;//calculating the middle index
	            
	            
	            if (ar[mid].compareTo(target)==0) {
	            	numSteps++;//checking if target is the middle value
	                return mid;
	            }
	            if (ar[mid].compareTo(target)>0) {//Checking if element is greater than element at middle index and if its greater
	            	numSteps++;
	                return binarySearch(ar, left, mid - 1, target);//Calling binary search recursively on the right half
	            }
	            else {//if element is less than element at mid index
	            return binarySearch(ar, mid + 1, right, target);//Calling binary search recursively on the left half
	            }
	        }
	 
	        return -1;
	    }
	 
	 
}
