//Creating a Bubble Sort Class
public class BubbleSort {  
	long startTime = System.nanoTime();			//Start Time
	int[] BubbleSort(int[] ar){                 //Creating a Method for Sorting		
		for(int i=0;i<ar.length-1;i++) {		//For loop over Elements of Array till n-1
			for(int j=0;j<ar.length-1-i;j++) {  				
				if(ar[j]>ar[j+1]) {
					ar[j]=ar[j]+ar[j+1];		//Comparing the value of each element with next element and swapping if its larger
					ar[j+1]=ar[j]-ar[j+1];
					ar[j]=ar[j]-ar[j+1];
				}		
			}
		}
		long endTime   = System.nanoTime();		//End time
		long runTime = endTime - startTime;		//Finding difference to get Execution Time
		System.out.println("Run time in Nano Seconds :"+runTime);
		return ar; //Returning Sorted Array
	}
	}
