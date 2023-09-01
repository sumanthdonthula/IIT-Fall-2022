
public class Sorting<T extends Comparable<T>> {
	int numComp;   //variable to hold number of comparisons
	
	void resetNumComp(){//Method to reset number of comparisons variable
		this.numComp=0;
	}
	void selectionSort(T[] ar,int n){  	//Method to implement selection sort
		for (int i = 0; i < n-1; i++)  //Looping over the array elements till length -1
        {
 
            int minInd = i;
            for (int j = i+1; j < n; j++) {//looping the elements from index+1 location from current element
            	numComp++;
                if (ar[j].compareTo(ar[minInd])<0){
                    minInd = j;//Comparing the elements from index+1 location from current element
				}
            }
            T temp = ar[minInd];//Swapping if the elements at later index are less than the current one
            ar[minInd] = ar[i];
            ar[i] = temp;
        }

		}	

	void bubbleSort(T[] ar,int n){   //Method to implement Bubble sort             	
		
		for(int i=0;i<n-1;i++) {		//Looping over the array elements till length -1
			int flag=0;					//flag to check no more comparisons are required
			for(int j=0;j<n-i-1;j++) {  
				numComp++;				//Looping over the elements till the difference in current index and length 
				if(ar[j].compareTo(ar[j+1])>0) { 
					T temp =ar[j];
					ar[j]=ar[j+1];		//Swapping if the current element is greater than element at next index
					ar[j+1]=temp;
					flag=1;
				}		
			}
			if (flag==0) {
				break;//stopping loop if flag is 0
			}
		}

		
}
	
	void insertionSort(T[] ar, int n) { //Method to implement insertion sort
		
		for(int i=1;i<n;++i) {//Looping over the elements 
			T value=ar[i];
			int node=i-1;   //hold the node position 
			
			while(node>=0 && ar[node].compareTo(value)>0) {
				numComp++;
				ar[node+1]=ar[node];		//Moving the elements that are greater than node to their next position 		
				node=node-1;
			}
			ar[node+1]=value;
		}
	}
	@SuppressWarnings("unchecked")	
	void merge(T ar[], int left, int mid, int right)//Method to implement merge which will be used in merge sort
	{
		int n1 = mid - left + 1;//Length of left array
		int n2 = right - mid;   //Length of right array
		
		T[] leftArr = (T[]) new Comparable[n1];//Creating two arrays before mid and after mid
		T[] rightArr = (T[])new Comparable[n2];

		for (int i = 0; i < n1; ++i) {
			leftArr[i] = ar[left + i];  //Copying data to temp arrays from main array
		}
		for (int j = 0; j < n2; ++j) {
			rightArr[j] = ar[mid + 1 + j];//Copying data to temp arrays from main array
		}

		int i = 0;
		int j = 0;


		int k = left;
		while (i < n1 && j < n2) {
			
			if (leftArr[i].compareTo(rightArr[j])<=0) {
				ar[k] = leftArr[i];	//Checking if the elements in left array are less than right array and adding into
				i++;				//correct positions in array
				numComp++;
			}
			else {
				ar[k] = rightArr[j];//If elements in left array are larger add elements from right temp array
				j++;
			}
			k++;
		}


		while (i < n1) {
			ar[k] = leftArr[i];
			i++;				//Adding remaining elements in left array to main array
			k++;
		}


		while (j < n2) {
			ar[k] = rightArr[j];
			j++; 			//Adding remaining elements in right array to main array
			k++;
		}
	}
	
	
	void mergeSort(T arr[], int left, int right)//Method to implement merge sort recursively
	{	
		if (left < right ) {//Checking if left is always less than right
			
			int mid = left + (right - left) / 2; //calculating the middle element

			mergeSort(arr, left, mid);//sorting the left side of the array
			mergeSort(arr, mid + 1,right);//sorting the right side of array
			
			merge(arr, left, mid, right);//merging the sorted arrays
		}
	}
	
	int partition(T[] ar, int low, int high)
	{

		T pivot = ar[high];//pivot value to act as a key for sorting

		int i = low - 1;//index of smaller element

		for (int j = low; j <= high - 1; j++) {
			
			if (ar[j].compareTo(pivot)<0) {	//if current element is smaller than the pivot	
				
				i++;//incrementing index of smaller element
				T temp = ar[i];//swapping the values 
				ar[i] = ar[j];
				ar[j] = temp;
				
			}
		}
		numComp++;
		T temp = ar[i+1]; //swap the values at index+1 and the maximum element
		ar[i+1] = ar[high];
		ar[high] = temp;
		
		return i + 1;
	}

	void quickSort(T ar[], int low, int high)//Method to implement Quick Sort
	{	
		
		if (low < high) {  

			int part = partition(ar, low, high);//Making the partition index

			quickSort(ar, low, part - 1);//Sorting elements before partition
			quickSort(ar, part + 1, high);//Sorting elements after partition
		}
	}
	
	public void heapSort(T ar[], int n)
	{	
		//Heapifying the array
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(ar, n, i);
		}

		//Looping over all elements from heap
		for (int i = n - 1; i > 0; i--) {
			//Moving current root to end of the heap
			T temp = ar[0];
			ar[0] = ar[i];
			ar[i] = temp;
			//calling heapify on the smaller heap
			heapify(ar, i, 0);
		}
	}


	void heapify(T ar[], int n, int i)
	{
		int max = i; //Making a maximum value as root
		int left = 2 * i + 1; //Making left index from the root
		int right = 2 * i + 2; //Making right index from the root
		//Making left element as root if its greater than root
		if (left < n && ar[left].compareTo(ar[max])>0) {
			max = left;
			numComp++;
		}
		//Making right element as root if its greater than root
		if (right < n && ar[right].compareTo(ar[max])>0) {
			max = right;
			numComp++;
		}
		//if maximum is not the root swap the values
		if (max != i) {
			T temp = ar[i];
			ar[i] = ar[max];
			ar[max] = temp;
			//Recursively heapifying the sub tree
			heapify(ar, n, max);
		}
	}
	
}
