
public class ArrayImplementation {
	//Initializing array with size 10
	int maxSize=10;

	String[] strAr=new String[maxSize]; //Initiaiting String Array
	Integer[] intAr=new Integer[maxSize];//Initiaiting Integer Array
	Float[] fltAr=new Float[maxSize];//Initiaiting Float Array
	
	
	int numElem=0;//Variable Numelements
	//Method to add elements
	void add(String val) {
		if(isFull()) {		//checks if array is full and doubles the size of array	
		maxSize=maxSize*2;	
		String[] newArr=new String[maxSize];	
		for(int i=0;i<numElem;i++) {
			newArr[i]=strAr[i];      //copying elements to new Array
			}
		strAr=newArr;
		}
		numElem++;
		strAr[numElem-1]=val;
		}
	
	void add(int val) {
		if(isFull()) {		//checks if array is full and doubles the size of array	
		maxSize=maxSize*2;	
		Integer[] newArr=new Integer[maxSize];	
		for(int i=0;i<numElem;i++) {
			newArr[i]=intAr[i];      //copying elements to new Array
			}
		intAr=newArr;
		}
		numElem++;
		intAr[numElem-1]=val;
		}
	
	void add(Float val) {
		if(isFull()) {		//checks if array is full and doubles the size of array	
		maxSize=maxSize*2;	
		Float[] newArr=new Float[maxSize];	
		for(int i=0;i<numElem;i++) {
			newArr[i]=fltAr[i];      //copying elements to new Array
			}
		fltAr=newArr;
		}
		numElem++;
		fltAr[numElem-1]=val;
		}

	boolean isFull() {
		return maxSize==numElem;//method to check if Array is full or not
	}

	public int length() {
		// Method to return length of Array
		return numElem;
	}
	
	public int arSize() {
		// Method to return length of Array
		return maxSize;
	}
	
	
	

}
