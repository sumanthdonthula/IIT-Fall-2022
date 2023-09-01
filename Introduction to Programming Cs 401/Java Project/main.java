import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class main {

public static void main(String[] args) throws IOException{
	System.out.println(" ");
	System.out.println("** This Programme takes a text file from the User of Data Types Float, Int and String **\n"
			+"\n"
			+ "** User can choose to sort a specific data type using one simple (O(N2)) sort and O(Nlog2N) sort\n"
			+ ",the Programme compares the complexity and provides the Optimal Algorithm in terms of Big O **\n"
			+"\n"
			+ "** The Programme will also implement searching with linear, binary and hash function searching\n"
			+ "and analyzes the complexity"
			+ " **");
	
	System.out.println(" ");
	
	System.out.println("Please provide the location of the text file to read : ");
	System.out.println(" ");
	System.out.println("Sample format is as shown below : ");
	System.out.println("C:\\Users\\SRINU\\Desktop\\test.txt");
	System.out.println(" ");
	
	System.out.print("File Location (String) : ");
	
	System.out.println(" ");
	
	Scanner scan  = new Scanner(System.in);	//Initiating Scanner
    String fileLocation = scan.nextLine();  //Reading the value


    
    
	BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
     
	ArrayImplementation strAr = new ArrayImplementation();//Initiating the string array
	ArrayImplementation intAr = new ArrayImplementation();//Initiating the Integer array
	ArrayImplementation fltAr = new ArrayImplementation();//Initiating the Float array
	
	ArrayImplementation unsortStrAr=new ArrayImplementation();//Keeping array values as the original arrays get sorted
	ArrayImplementation unSortIntAr=new ArrayImplementation();
	ArrayImplementation unSortFltAr=new ArrayImplementation();
	
	try {
		
		

		
	    String newLine = reader.readLine();//Reading first line from the reader
	    
	    while (newLine != null) {		  //While loop to read all the mext lines from text 	
	    	if(newLine!=null) {	 
	     
	     try {
	    	 if(newLine.contains(".")) {//Checking and adding to float array if its float
	    	   fltAr.add(Float.parseFloat(newLine));
	    	   unSortFltAr.add(Float.parseFloat(newLine));
	    	    
	    	 }
	    	 else {
	    		 intAr.add(Integer.parseInt(newLine));//Adding to integer array of its integer
	    		 unSortIntAr.add(Integer.parseInt(newLine));
	    	 }
	   	     
	    	} catch (NumberFormatException e) {
	    	    strAr.add(newLine);//Adding to string array if its string
	    	    unsortStrAr.add(newLine);
	    	}
	        }
	    	
	    	newLine = reader.readLine();
	    	
	    }
	    
	} finally {
	    reader.close();					  //CLosing the reader
	}
	System.out.println(" ");
	System.out.print("String Array from the File : ");//Printing the values from string array
	for(int i=0;i<strAr.length();i++) {
		if (i % 15 == 0) {
            System.out.println();
        }
        System.out.print(strAr.strAr[i] + "|");
    }
	
	System.out.println("\n");
	
	System.out.print("Integer Array from the File : ");//Printing the values from Integer array
	for(int i=0;i<intAr.length();i++) {
		if (i % 15 == 0) {
            System.out.println();
        }
        System.out.print(intAr.intAr[i] + "|");
    }
	
	System.out.println("\n");
	
	System.out.print("Float Array from the File : ");////Printing the values from float array
	for(int i=0;i<fltAr.length();i++) {
		if (i % 15 == 0) {
            System.out.println();
        }
        System.out.print(fltAr.fltAr[i] + "|");
    }
	
	
	System.out.println(" ");
    System.out.println("Select the Data Type from the file to be sorted from the below menu : ");
    

    System.out.println("1. String");
    System.out.println("2. Integer");
    System.out.println("3. Float");
    System.out.println(" ");
    System.out.println("For instance to sort and apply Sorting and Searching Algos on String user needs to input : 1");
    System.out.println("values should be in the range of 1 and 3");
    System.out.println("Data type from the file to be Sorted and Search to be implemented on (Int Input) : ");
    int dataSel = scan.nextInt();  //Reading the Data from user
		
System.out.println("Select one of the Simple Sorting(O(N2)) Algorithm from the menu : ");
    
    System.out.println("1. Selection Sort");
    System.out.println("2. Bubble Sort");
    System.out.println("3. Insertion Sort");
    System.out.println(" ");
    System.out.println("For instance to use Selection Sort user needs to input : 1");
    System.out.println("values should be in the range of 1 and 3\n");

    
   
    System.out.println("First Sorting Algorithm Selection (Int Input) : ");
    int firSel = scan.nextInt();  //Reading the first selection
    

    
    System.out.println(" ");
    System.out.println("Select one of the O(LogN2) Algorithm from the menu : ");
    
    System.out.println("1. Merge Sort");
    System.out.println("2. Quick Sort");
    System.out.println("3. Heap Sort");
    System.out.println(" ");
    System.out.println("For instance to use Quick Sort user needs to input : 1");
    System.out.println("values should be in the range of 1 and 3");
    System.out.println("Second Sorting Algorithm Selection (Int) Input : ");
    int secSel = scan.nextInt();  //Reading the  second selection
	
	

    switch (dataSel) {//Cases for data types
    case 1: dataSel = 1;//Case for String
			Sorting<String> strSort = new Sorting<String>();//Inititiating sorting class
			
			switch(firSel){//cases for first group sorting algos
				case 1: firSel = 1;//implementing selection sort
				strSort.resetNumComp();
				strSort.selectionSort(strAr.strAr,strAr.numElem);
				
				System.out.println("The Sorted Array from Selection Sort is : ");
			    
				for(int i=0;i<strAr.numElem;i++) {
					if (i % 15 == 0) {
			            System.out.println();
			        }
			        System.out.print(strAr.strAr[i] + "|");
				}
				System.out.println(" ");
				System.out.println(" ");
				System.out.println("-> Number of Comparisons : "+strSort.numComp);
				System.out.println(" ");
				break;
				
				case 2: firSel = 2;//implementing bubble sort
				strSort.resetNumComp();
				strSort.bubbleSort(strAr.strAr,strAr.numElem);
				System.out.println("The Sorted Array from Bubble Sort is : ");
				for(int i=0;i<strAr.numElem;i++) {
					if (i % 15 == 0) {
			            System.out.println();
			        }
			        System.out.print(strAr.strAr[i] + "|");
					}
				System.out.println(" ");
				System.out.println(" ");
				System.out.println("-> Number of Comparisons : "+strSort.numComp);
				System.out.println(" ");
				break;
				
				case 3: firSel = 3;//implementing insertion sort
				strSort.resetNumComp();
				strSort.insertionSort(strAr.strAr,strAr.numElem);
				System.out.println("The Sorted Array from Insertion Sort is : ");

				for(int i=0;i<strAr.numElem;i++) {
					if (i % 15 == 0) {
			            System.out.println();
			        }
			        System.out.print(strAr.strAr[i] + "|");
					}
			    System.out.println(" ");
			    System.out.println(" ");
				System.out.println("-> Number of Comparisons : "+strSort.numComp);
				System.out.println(" ");
				break;	
			}
			
				switch(secSel){//cases for second sorting selection
				case 1: secSel = 1;//implementing merge sort
				strSort.resetNumComp();
				strSort.mergeSort(strAr.strAr,0,strAr.numElem-1);
				
				System.out.println("The Sorted Array from Merge Sort is : ");

				for(int i=0;i<strAr.numElem;i++) {
					if (i % 15 == 0) {
			            System.out.println();
			        }
			        System.out.print(strAr.strAr[i] + "|");
					}
				System.out.println(" ");
				System.out.println(" ");
				System.out.println("-> Number of Comparisons : "+strSort.numComp);
				System.out.println(" ");
				break;
				
				case 2: secSel = 2;//implementing quick sort
				System.out.println(strSort.numComp);
				strSort.resetNumComp();
				System.out.println(strSort.numComp);
				
				strSort.quickSort(strAr.strAr,0,strAr.numElem-1);
				System.out.println("The Sorted Array from Quick Sort is : ");
				for(int i=0;i<strAr.numElem;i++) {
					if (i % 15 == 0) {
			            System.out.println();
			        }
			        System.out.print(strAr.strAr[i] + "|");
					}
			    System.out.println(" ");
			    System.out.println(" ");
				System.out.println("-> Number of Comparisons : "+strSort.numComp);
				System.out.println(" ");
				break;
					
				case 3: secSel = 3;//implementing heap sort
				strSort.resetNumComp();
				strSort.heapSort(strAr.strAr,strAr.numElem);
				System.out.println("The Sorted Array from Heap Sort is : ");
				for(int i=0;i<strAr.numElem;i++) {
					if (i % 15 == 0) {
			            System.out.println();
			        }
			        System.out.print(strAr.strAr[i] + "|");
					}
			    System.out.println(" ");
			    System.out.println(" ");
				System.out.println("-> Number of Comparisons : "+strSort.numComp);
				System.out.println(" ");
				
				break;			
			}
			//Implementation of searching
			System.out.println("Implementation of Searching, please type the Target Value");
			System.out.println(" ");
			scan.nextLine();
			System.out.println("Target(String Input) :");
			String target = scan.nextLine();  //Reading the target
			
			Searching<String> strSearch=new Searching<String>();//Inititiating the searching class
			
			System.out.println("Implementation of Linear Search");
			System.out.println(" ");
			strSearch.resetNumSteps();
			long startTime = System.nanoTime();
			int ind =strSearch.linearSearch(unsortStrAr.strAr, target,unsortStrAr.numElem);
			long endTime = System.nanoTime();
			long execTime=endTime-startTime;
			if(ind!=-1) {
			System.out.println("The Target from Linear Search is at index : "+ind);
    }
	else {
		System.out.println("The target is not present in the array");
	}
			System.out.println("-> Number of Steps to find the Target : "+ strSearch.numSteps);
			System.out.println("The Linear Search took(ns) : "+execTime);
			System.out.println(" ");
			System.out.println("Implementation of Binary Search");
			System.out.println(" ");
			strSearch.resetNumSteps();
			startTime = System.nanoTime();
			ind=strSearch.binarySearch(strAr.strAr, 0, strAr.numElem-1, target);//Passing Sorted Array it is used in sorting methods
			endTime = System.nanoTime();
			execTime=endTime-startTime;
			if(ind!=-1) {
			System.out.println("The Target from Binary Search is at index : "+ind);
			}
			else {
				System.out.println("The target is not present in the array");
			}
			
			System.out.println("-> Number of Steps to find the Target : "+ strSearch.numSteps);
			System.out.println("The Binary Search took(ns) : "+execTime);
			System.out.println(" ");
			System.out.println("Implementation of Hash Search");
			System.out.println(" ");
			HashingImplementation hashStr=new HashingImplementation();//Initiating the hashing class
			
			
			String[] str=hashStr.HashArray(unsortStrAr.strAr, unsortStrAr.numElem);
			
			hashStr.resetnumSteps();
			startTime = System.nanoTime();
			ind = hashStr.HashSearch(str,target);
			endTime = System.nanoTime();
			execTime=endTime-startTime;
			
			if(ind!=-1) {
			System.out.println("The Target from Hash Search is at index : "+ind);
			 }
			else {
				System.out.println("The target is not present in the array");
			}
			
			System.out.println("-> Number of Steps to find the Target : "+ hashStr.numSteps);
			System.out.println("The Hash Search took(ns) : "+execTime);
			System.out.print(" ");
			
			
			
             break;
    case 2: dataSel = 2;//Cases for integer data type
    		Sorting<Integer> intSort = new Sorting<Integer>();//Initiating sorting class
			
			switch(firSel){//cases for selecting first group sorting algos
				case 1: firSel = 1;//Implementing Selection sort
				intSort.resetNumComp();
				intSort.selectionSort(intAr.intAr,intAr.numElem);
				System.out.println("The Sorted Array from Selection Sort is : ");
				for(int i=0;i<intAr.numElem;i++) {
					if (i % 15 == 0) {
			            System.out.println();
			        }
			        System.out.print(intAr.intAr[i] + "|");
					}
			    System.out.println(" ");
			    System.out.println(" ");
				System.out.println("-> Number of Comparisons : "+intSort.numComp);
				System.out.println(" ");
				break;
				
				case 2: firSel = 2;//Implementing Bubble Sort
				intSort.resetNumComp();
				intSort.bubbleSort(intAr.intAr,intAr.numElem);
				System.out.println("The Sorted Array from Bubble Sort is : ");
				for(int i=0;i<intAr.numElem;i++) {
					if (i % 15 == 0) {
			            System.out.println();
			        }
			        System.out.print(intAr.intAr[i] + "|");
					}
				System.out.println(" ");
				System.out.println(" ");
				System.out.println("-> Number of Comparisons : "+intSort.numComp);
				System.out.println(" ");
				break;
				
				case 3: firSel = 3;//Implementing Insertion Sort
				intSort.resetNumComp();
				intSort.insertionSort(intAr.intAr,intAr.numElem);
				System.out.println("The Sorted Array from Insertion Sort is : ");
				for(int i=0;i<intAr.numElem;i++) {
					if (i % 15 == 0) {
			            System.out.println();
			        }
			        System.out.print(intAr.intAr[i] + "|");
					}
				System.out.println(" ");
				System.out.println(" ");
				System.out.println("-> Number of Comparisons : "+intSort.numComp);
				System.out.println(" ");
				break;	
			}
			
				switch(secSel){//Cases for 2 group algorithms
				case 1: secSel = 1;//Implementing merge sort
				intSort.resetNumComp();
				intSort.mergeSort(intAr.intAr,0,intAr.numElem-1);	
				System.out.println("The Sorted Array from Merge Sort is : ");
				for(int i=0;i<intAr.numElem;i++) {
					if (i % 15 == 0) {
			            System.out.println();
			        }
			        System.out.print(intAr.intAr[i] + "|");
					}
			    System.out.println(" ");
			    System.out.println(" ");
				System.out.println("-> Number of Comparisons : "+intSort.numComp);
				System.out.println(" ");
				break;
				
				case 2: secSel = 2;//Implementing quick sort
				intSort.resetNumComp();
				intSort.quickSort(intAr.intAr,0,intAr.numElem-1);
				System.out.println("The Sorted Array from Quick Sort is : ");
				for(int i=0;i<intAr.numElem;i++) {
					if (i % 15 == 0) {
			            System.out.println();
			        }
			        System.out.print(intAr.intAr[i] + "|");
					}
			    System.out.println(" ");
			    System.out.println(" ");
				System.out.println("-> Number of Comparisons : "+intSort.numComp);
				System.out.println(" ");
				
				break;
				
				case 3: secSel = 3;//Implementing Heap Sort
				intSort.resetNumComp();
				intSort.heapSort(intAr.intAr,intAr.numElem);
				System.out.println("The Sorted Array from Heap Sort is : ");
				for(int i=0;i<intAr.numElem;i++) {
					if (i % 15 == 0) {
			            System.out.println();
			        }
			        System.out.print(intAr.intAr[i] + "|");
					}
			    System.out.println(" ");
			    System.out.println(" ");
				System.out.println("-> Number of Comparisons : "+intSort.numComp);
				System.out.println(" ");
				break;
					
			}
				System.out.println("Implementation of Searching, please type the Target Value");
				System.out.println(" ");
				scan.nextLine();
				System.out.println("Target(int) :");
				int intTarget = scan.nextInt();  //Reading the Taget
				System.out.println("Implementation of Linear Search");
				System.out.println(" ");
				Searching<Integer> intSearch=new Searching<Integer>();//Initiating searching object
				
				intSearch.resetNumSteps();
				startTime = System.nanoTime();
				ind =intSearch.linearSearch(unSortIntAr.intAr, intTarget,unSortIntAr.numElem);
				endTime = System.nanoTime();
				execTime=endTime-startTime;
				if(ind!=-1) {
				System.out.println("The Target from Linear Search is at index : "+ind);
	    }
		else {
			System.out.println("The target is not present in the array");
		}
				System.out.println("-> Number of Steps to find the Target : "+ intSearch.numSteps);
				System.out.println("The Linear Search took(ns) : "+execTime);
				System.out.println(" ");
				System.out.println("Implementation of Binary Search");
				System.out.println(" ");
				intSearch.resetNumSteps();
				startTime = System.nanoTime();
				ind=intSearch.binarySearch(intAr.intAr, 0, intAr.numElem-1, intTarget);//Passing Sorted Array it is used in sorting methods
				endTime = System.nanoTime();
				execTime=endTime-startTime;
				if(ind!=-1) {
				System.out.println("The Target from Binary Search is at index : "+ind);
				}
				else {
					System.out.println("The target is not present in the array");
				}
				
				System.out.println("-> Number of Steps to find the Target : "+ intSearch.numSteps);
				System.out.println("The Binary Search took(ns) : "+execTime);
				System.out.println(" ");
				System.out.println("Implementation of Hash Search");
				System.out.println(" ");
				HashingImplementation intHash=new HashingImplementation();//Initiating hashing object
				
				
				Integer[] intHashed=intHash.HashArray(unSortIntAr.intAr, unSortIntAr.numElem);
				
				intHash.resetnumSteps();
				startTime = System.nanoTime();
				ind = intHash.HashSearch(intHashed,intTarget);
				endTime = System.nanoTime();
				execTime=endTime-startTime;
				
				if(ind!=-1) {
				System.out.println("The Target from Hash Search is at index : "+ind);
				 }
				else {
					System.out.println("The target is not present in the array");
				}
				
				System.out.println("-> Number of Steps to find the Target : "+ intHash.numSteps);
				System.out.println("The Hash Search took(ns) : "+execTime);
				System.out.print(" ");
				
				
				
			break;
    case 3: dataSel = 3; //Case for implementing for Float
    		Sorting<Float> fltSort = new Sorting<Float>();
			
			switch(firSel){//Cases for first group Algos
				case 1: firSel = 1;//Implementing selection sort
				fltSort.resetNumComp();
				fltSort.selectionSort(fltAr.fltAr,fltAr.numElem);	
				System.out.println("The Sorted Array from Selection Sort is : ");
				for(int i=1;i<fltAr.numElem;i++) {
					if (i % 15 == 0) {
			            System.out.println();
			        }
			        System.out.print(fltAr.fltAr[i-1] + "|");
					}
			    System.out.println(" ");
			    System.out.println(" ");
				System.out.println("-> Number of Comparisons : "+fltSort.numComp);
				System.out.println(" ");
				break;
				
				case 2: firSel = 2;//Implementing bubble sort
				fltSort.resetNumComp();
				fltSort.bubbleSort(fltAr.fltAr,fltAr.numElem);
				System.out.println("The Sorted Array from Bubble Sort is : ");				
				for(int i=1;i<fltAr.numElem;i++) {
					if (i % 15 == 0) {
			            System.out.println();
			        }
			        System.out.print(fltAr.fltAr[i-1] + "|");
					}
			    System.out.println(" ");
			    System.out.println(" ");
				System.out.println("-> Number of Comparisons : "+fltSort.numComp);
			    System.out.println(" ");
			    
				break;
				
				case 3: firSel = 3;//Implementing insertion sort
				fltSort.resetNumComp();
				fltSort.insertionSort(fltAr.fltAr,fltAr.numElem);			
				System.out.println("The Sorted Array from Insertion Sort is : ");
				for(int i=1;i<fltAr.numElem;i++) {
					if (i % 15 == 0) {
			            System.out.println();
			        }
			        System.out.print(fltAr.fltAr[i-1] + "|");
					}
			    System.out.println(" ");
			    System.out.println(" ");
				System.out.println("-> Number of Comparisons : "+fltSort.numComp);
				System.out.println(" ");
				break;	
			}
			
				switch(secSel){//cases for selecting second group algos
				case 1: secSel = 1;//Implementing merge sort
				fltSort.resetNumComp();
				fltSort.mergeSort(fltAr.fltAr,0,fltAr.numElem-1);				
				System.out.println("The Sorted Array from Merge Sort is : ");
				for(int i=1;i<fltAr.numElem;i++) {
					if (i % 15 == 0) {
			            System.out.println();
			        }
			        System.out.print(fltAr.fltAr[i-1] + "|");
					}
			    System.out.println(" ");
			    System.out.println(" ");
				System.out.println("-> Number of Comparisons : "+fltSort.numComp);
				System.out.println(" ");
				break;
				
				case 2: secSel = 2;//Implementing quick sort
				fltSort.resetNumComp();
				fltSort.quickSort(fltAr.fltAr,0,fltAr.numElem-1);			
				System.out.println("The Sorted Array from Quick Sort is : ");
				for(int i=1;i<fltAr.numElem;i++) {
					if (i % 15 == 0) {
			            System.out.println();
			        }
			        System.out.print(fltAr.fltAr[i-1] + "|");
					}
			    System.out.println(" ");
			    System.out.println(" ");
				System.out.println("-> Number of Comparisons : "+fltSort.numComp);
				System.out.println(" ");
				
				break;
				
				case 3: secSel = 3;//Implementing heap sort
				fltSort.resetNumComp();
				fltSort.heapSort(fltAr.fltAr,fltAr.numElem);				
				System.out.println("The Sorted Array from Heap Sort is : ");
				for(int i=1;i<fltAr.numElem+1;i++) {
					if (i % 15 == 0) {
			            System.out.println();
			        }
			        System.out.print(fltAr.fltAr[i-1] + "|");
					}
			    System.out.println(" ");
			    System.out.println(" ");
				System.out.println("-> Number of Comparisons : "+fltSort.numComp);
				System.out.println(" ");
				
				break;
}
				
				System.out.println("Implementation of Searching, please type the Target Value");
				System.out.println(" ");
				scan.nextLine();
				System.out.println("Target(float) :");
				
				float fltTarget = scan.nextFloat();  //Reading the target
				System.out.println("Implementation of Linear Search");
				System.out.println(" ");
				Searching<Float> fltSearch=new Searching<Float>();//Inititalizing the search class
				
				fltSearch.resetNumSteps();
				startTime = System.nanoTime();
				ind =fltSearch.linearSearch(unSortFltAr.fltAr, fltTarget,unSortFltAr.numElem);
				endTime = System.nanoTime();
				execTime=endTime-startTime;
				if(ind!=-1) {
				System.out.println("The Target from Linear Search is at index : "+ind);
	    }
		else {
			System.out.println("The target is not present in the array");
		}
				System.out.println("-> Number of Steps to find the Target : "+ fltSearch.numSteps);
				System.out.println("The Linear Search took(ns) : "+execTime);
				System.out.println(" ");
				System.out.println("Implementation of Binary Search");
				System.out.println(" ");
				fltSearch.resetNumSteps();
				startTime = System.nanoTime();
				ind=fltSearch.binarySearch(fltAr.fltAr, 0, fltAr.numElem-1, fltTarget);//Passing Sorted Array it is used in sorting methods
				endTime = System.nanoTime();
				execTime=endTime-startTime;
				if(ind!=-1) {
				System.out.println("The Target from Binary Search is at index : "+ind);
				}
				else {
					System.out.println("The target is not present in the array");
				}
				
				System.out.println("-> Number of Steps to find the Target : "+ fltSearch.numSteps);
				System.out.println("The Binary Search took(ns) : "+execTime);
				System.out.println(" ");
				System.out.println("Implementation of Hash Search");
				System.out.println(" ");
				HashingImplementation fltHash=new HashingImplementation();//Initiating hashing class
				
				
				Float[] fltHashed=fltHash.HashArray(unSortFltAr.fltAr, unSortFltAr.numElem);
				
				fltHash.resetnumSteps();
				startTime = System.nanoTime();
				ind = fltHash.HashSearch(fltHashed,fltTarget);
				endTime = System.nanoTime();
				execTime=endTime-startTime;
				
				if(ind!=-1) {
				System.out.println("The Target from Hash Search is at index : "+ind);
				 }
				else {
					System.out.println("The target is not present in the array");
				}
				
				System.out.println("-> Number of Steps to find the Target : "+ fltHash.numSteps);
				System.out.println("The Hash Search took(ns) : "+execTime);
				System.out.print(" ");
				
break;
}
    
	
	}
	


	
}
