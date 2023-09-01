import java.util.ArrayList;
//Creating a Stack Class
public class Stack<T> {
	
 //Initiating an array list 
ArrayList<T> Arr = new ArrayList<T>();

int top=-1;						//Initiating top variable for indexng  

//Push method to add an element at top of the Stack

public void push(T value) {
	top++;					  //Increase the top by 1 as we are adding the element
	Arr.add(value);			  //Adding an element into the Stack
	
}

//Pop Method to remove the top element in an array

public void pop() {
if(!Arr.isEmpty())	{
	Arr.remove(top); //Remove element at top from stack
		top--;				  //Decrease the index as element is removed	
}
	
}

//Peek Method to return top element in the stack

public T peek() {
if(!Arr.isEmpty()) {
	return Arr.get(top);//Return element at top Index
}
return null;
}

public boolean isEmpty() {
	if(top==-1) {
		return true;   //Checking if Stack is empty or not
	}
	return false;
	
}


}



