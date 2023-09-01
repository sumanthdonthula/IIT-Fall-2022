
public class HashingImplementation{

int numSteps;  //variable to hold number of steps which is used in hash search
	
	void resetnumSteps(){
		this.numSteps=0;//resetting the value of num Steps
	}

int hash(String value,int arrLen) {//Method to apply hash funcion for string
	
	int sum=0;
    for(int i=0; i<value.length(); i++)
    {
      int asciiValue = value.charAt(i);//looping over all character of string and summing ascii values
      sum = sum+ asciiValue;
    }
	return sum%arrLen; //returning the hash value

}

int hash(int value,int arrLen) {//Method to apply hash function for integer
	  
	return value%arrLen;//returning the hash value
}

int hash(float value,int arrLen) {//Method to apply hash function for float
	return ((int) (value))% arrLen;//returning the hash value
}


String[] HashArray(String[] ar,int numElem) {//Method to create hash array of string
	
	String[] hashStrAr=new String[ar.length];//Creating an empty hash array
	for(int i=0;i<numElem;i++) {//looping over all elements
		int index=this.hash(ar[i], ar.length);//calculating hash value for the elements
		int curIndex = (index+1)%hashStrAr.length;
		if(hashStrAr[index]==null) {
			hashStrAr[index]=ar[i];//Adding element in hash array if the position is empty
		}
		else {
			
			while(curIndex!=index) {//Adding the element at the next available index if the index is already occupied
				if(hashStrAr[curIndex]==null) {
				hashStrAr[curIndex]=ar[i];			
				break;
				
				}
				
				curIndex=(curIndex+1)%hashStrAr.length;//increasing index to create a cyclic array
			}
		}
		
		
	}
	return hashStrAr;
	}

Integer[] HashArray(Integer[] ar,int numElem) {//Method to create hash array of Integer
	Integer[] hashIntAr=new Integer[ar.length];//Creating an empty hash array
	
	for(int i=0;i<numElem;i++) {//looping over all elements
		int index=this.hash(ar[i],ar.length);//calculating hash value for the elements
		int curIndex = (index+1)%hashIntAr.length;
		if(hashIntAr[index]==null) {//Adding element in hash array if the position is empty
			
			hashIntAr[index]=ar[i];
		}
		else {
			while(curIndex!=index) {//Adding the element at the next available index if the index is already occupied
				if(hashIntAr[curIndex]==null) {
					hashIntAr[curIndex]=ar[i];
					break;
				
				}
				
				curIndex=(curIndex+1)%hashIntAr.length;//increasing index to create a cyclic array
			}
		}
	}
	return hashIntAr;
	
	}

Float[] HashArray(Float[] ar,int numElem) {//Method to create hash array of Float

	Float[] hashFltAr=new Float[ar.length];//Creating an empty hash array
	for(int i=0;i<numElem;i++) {//looping over all elements
		int index=this.hash(ar[i], ar.length);//calculating hash value for the elements
		int curIndex = (index+1)%hashFltAr.length;
		if(hashFltAr[index]==null) {//Adding element in hash array if the position is empty
			
			hashFltAr[index]=ar[i];
		}
		else {
			while(curIndex!=index) {//Adding the element at the next available index if the index is already occupied
				if(hashFltAr[curIndex]==null) {
					hashFltAr[curIndex]=ar[i];
				
				break;
				
				}
				
				curIndex=(curIndex+1)%hashFltAr.length;//increasing index to create a cyclic array
			}
		}
	}
	return hashFltAr;
	
	}

int HashSearch(String[] ar,String target) {//Method to implement the searching
	boolean found=false;
	int pos=0;
	int index=hash(target,ar.length);//Calculating the hash value for the target
	int curIndex = (index+1)%ar.length;

	if(ar[index]!=null && ar[index].equals(target)) {//Checking if the target is at the hashed index
		pos= index;
		found=true;
		numSteps++;
	}
	
	else {
		
		while(curIndex!=index) {
			
			if(ar[curIndex]!=null && ar[curIndex].equals(target)) {//Checking the values at next indexes if it is not in hash index
				pos = curIndex;
				found=true;
				numSteps++;
				break;
			}
			curIndex=(curIndex+1)%ar.length;//increasing the next index cyclically
		}
		
	}
	
	if(found==true) {
		return pos;
	}
	else {
		return -1;
	}
}

int HashSearch(Integer[] ar,int target) {//Method to implement the searching
	boolean found=false;
	int pos=0;
	int index=hash(target,ar.length);//Calculating the hash value for the target
	int curIndex = (index+1)%ar.length;
	
	if(ar[index]!=null && ar[index]==target) {//Checking the values at next indexes if it is not in hash index
		pos= index;
		found=true;
		numSteps++;
	}
	
	else {
		curIndex++;
		while(ar[curIndex]!=null && curIndex!=index ) {//Checking the values at next indexes if it is not in hash index
			if(ar[curIndex]==target) {
				pos = curIndex;
				found=true;
				numSteps++;
			}
			curIndex=(curIndex+1)%ar.length;//increasing the next index cyclically
		}
		
	}
	
	if(found==true) {
		return pos;
	}
	else {
		return -1;
	}
}

int HashSearch(Float[] ar,float target) {//Method to implement the searching
	boolean found=false;
	int pos=0;
	int index=hash(target,ar.length);//Calculating the hash value for the target
	int curIndex = (index+1)%ar.length;
	
	if(ar[index]!=null &&ar[index]==target) {//Checking the values at next indexes if it is not in hash index
		pos= index;
		found=true;
		numSteps++;
	}
	
	else {
		curIndex++;
		while(curIndex!=index) {
			if(ar[curIndex]!=null && ar[curIndex]==target) {//Checking the values at next indexes if it is not in hash index
				pos = curIndex;
				found=true;
				numSteps++;
			}
			curIndex=(curIndex+1)%ar.length;//increasing the next index cyclically
		}
		
	}
	
	if(found==true) {
		return pos;
	}
	else {
		return -1;
	}
}
	
}




