import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Employeemain {
public static void main(String[] args) throws IOException { 
	Employee[] Arr = new Employee[30];		//Initiating the Array with number of Employees

	//Initiating BufferReader to Read the text file from the location 
	BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\SRINU\\Desktop\\emp.txt"));
	try {
	    String newLine = reader.readLine();//Reading first line from the reader
	    
	    int i=0;
	    while (newLine != null) {		  //While loop to read all the lines from text 	
	    	if(newLine!=null) {	 
	       String[] values=new String[2]; 			//Splitting the value of lines by space
	       values=newLine.split(" ");
	       Employee s= new Employee();	  			//Initiating an Employee
	       s.setID(Integer.parseInt(values[1]));	//Setting Id of Employee
	       s.setName(values[0]);					//Setting Name of Employee
	       Arr[i]=s;								//Adding the Employee elements to Array
	       i++;
	        }
	    	
	    	newLine = reader.readLine();
	    	
	    }
	    
	} finally {
	    reader.close();					  //CLosing the reader
	}
	
Employee e = new Employee();		//Creating the Employee Object
Employee[] arr=e.selectionSort(Arr);//Sorting using selection sort
System.out.print("Employee Id to scan for : ");
Scanner scan=new Scanner(System.in);        //Initiating Scanner
int id = scan.nextInt();		  //Reading the input and assigning the string value
scan.close();					//Closing Scanner
int pos =e.binarySearch(arr, 0, arr.length-1, id);//calling Binary Search Method
if(pos!=-1) {
System.out.println("Employee : "+ arr[pos].getName()+" with ID : "+arr[pos].getId()+ " is present at index "+pos+" in sorted array");
}
else {
System.out.println("The following Id is not present in the Employee list");
}
}

}
