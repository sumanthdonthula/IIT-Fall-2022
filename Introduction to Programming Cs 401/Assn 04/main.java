import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class main {
public static void main(String[] args) throws IOException { 
	
	Stack Employee = new Stack();	//Initiating an Employee object from Stack class
	//Initiating BufferReader to Read the text file from the location 
	BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\SRINU\\Desktop\\emp.txt"));
	try {
	    String newLine = reader.readLine();//Reading first line from the reader
	    
	    while (newLine != null) {		  //While loop to read all the lines from text 
	    	Employee.push(newLine);
	        newLine = reader.readLine();
	        }
	    
	} finally {
	    reader.close();					  //CLosing the reader
	}
	System.out.println(Employee.peek());  //Peeking the top of the Stack
	Employee.pop();						  //Popping an element from Stack	
	Employee.pop();						  //Popping an element from Stack
	System.out.println(Employee.peek());  //Peeking the top of the Stack
	
}
}
