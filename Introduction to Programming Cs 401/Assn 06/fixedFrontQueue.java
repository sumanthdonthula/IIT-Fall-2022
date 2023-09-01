
public class fixedFrontQueue {
	
//Initiating an array list 
String Arr[] = new String[30];

int front=0;						//Initiating front variable for indexing
int rear=0;  						//Initiating rear variable for indexing

//Enqueue method to add an element at rear of the Queue

public void enqueue(String Emp) {

	Arr[rear]=Emp;			  //Adding an element into the Queue
	rear++;
}

//Dequeue Method to remove the priority element in an array

public String deque() {
String Em=Arr[front];
Arr[front]=null;
front++;
return Em;
}

public void printElements() {
for(int i=front;i<rear;i++) {
	System.out.println(Arr[i]);
}
}

}