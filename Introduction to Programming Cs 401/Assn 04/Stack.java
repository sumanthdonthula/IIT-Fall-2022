import java.util.ArrayList;
//Creating a Stack Class
public class Stack {
	
//Initiating an array list 
ArrayList<String> Arr = new ArrayList<String>();

int top=-1;						//Initiating top variable for indexng  

//Push method to add an element at top of the Stack

public void push(String Emp) {
	top++;					  //Increase the top by 1 as we are adding the element	
	Arr.add(Emp);			  //Adding an element into the Stack
}

//Pop Method to remove the top element in an array

public void pop() {
	Arr.remove(Arr.get(top)); //Remove element at top from stack
	top--;					  //Decrease the index as element is removed
	
}

//Peek Method to return top element in the stack

public String peek() {
	return Arr.get(top); 	//Returning an element at top
}

	
}