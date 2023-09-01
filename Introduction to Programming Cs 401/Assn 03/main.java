import java.util.Scanner;

public class main {
	
public static void main(String[] args) { 
		
	    System.out.print("Please enter the size of the Array : ");
	    Scanner scan  = new Scanner(System.in);	//Initiating Scanner
	    int n = scan.nextInt();                	//Reading the size of Array
	    int arr[] = new int[n];					//Initiating Array
	    System.out.println("Please enter the Elements of Array : ");
	    for(int i=0;i<n;i++) {
	    	arr[i] = scan.nextInt();			//Reading Array Elements
		}
	    
	    scan.close(); //closing scanner	
		BubbleSort ab= new BubbleSort();		//Creating an instance of the BubbleSort Class
		ab.BubbleSort(arr);						//Calling the Method to Sort Array
		System.out.println("Elements of Array in Sorted Order : ");
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);			//Looping array to return Elements
		}
		
	}

}
