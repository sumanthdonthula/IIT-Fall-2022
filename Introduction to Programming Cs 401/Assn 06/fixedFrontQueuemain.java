import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class fixedFrontQueuemain {
public static void main(String[] args) throws IOException { 
	
	fixedFrontQueue Employee = new fixedFrontQueue();	//Initiating an Employee object from Stack class
	//Initiating BufferReader to Read the text file from the location 
	BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\SRINU\\Desktop\\emp.txt"));
	try {
	    String newLine = reader.readLine();//Reading first line from the reader
	    
	    while (newLine != null) {		  //While loop to read all the lines from text 
	    	Employee.enqueue(newLine);
	        newLine = reader.readLine();
	        }
	    
	} finally {
	    reader.close();					  //CLosing the reader
	}
	System.out.println("Initial queue :");
	System.out.println(" ");
	Employee.printElements(); //printing the elements in Queue

	Employee.deque();		  //Dequeue element
	Employee.deque();		  //Dequeue element
	System.out.println(" ");
	System.out.println("After Performing Dequeue :");
	System.out.println(" ");
	Employee.printElements(); //printing the elements in Queue

}
}
