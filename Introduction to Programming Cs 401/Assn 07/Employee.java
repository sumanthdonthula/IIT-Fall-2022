
//Creating a Employee Class implementing Comparable interface
public class Employee{
	int Id; 		//Initiating Id
	String Name;	//Initiating Name

//Method to Set Id	

	void setID(int id) {
		this.Id=id;
	}

//Method to return Id value	

	
	int getId() {
		return this.Id;
	}
	
//Method to set Name	

	void setName(String name){
		this.Name=name;

	}

//Method to return Name value	
	
	
	String getName() {
		return this.Name;
	}	
	
    public Employee[] selectionSort(Employee[] arr)
    {
        int n = arr.length;
		
 
        // looping over all Employee IDs
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
			int minId=i;
			
            for (int j = i+1; j < n; j++)
			{
                if (arr[j].getId()<arr[minId].getId() )
                    minId = j;
			}

            // Swap minimum element with current element
            Employee temp = arr[minId];
            arr[minId] = arr[i];
            arr[i] = temp;
        }
        
    return arr;
    }
    
    public int binarySearch(Employee arr[], int l, int r, int ID)
    {	

		
        if (r >= l) {
            int mid = l + (r - l) / 2;
 
            //Checking if the Id is present in middle
            if (arr[mid].getId() == ID)
                return mid;
 
            //If ID is less than mid value
            if (arr[mid].getId() > ID)
                return binarySearch(arr, l, mid - 1, ID);
 
            //If ID is greater than mid value
            return binarySearch(arr, mid + 1, r, ID);
        }
 
        //When ID is not present it will return -1
        return -1;
    }
    
//Method to return Name and Id of Employee
	
	public String toString() {
		return "Employee Name : "+ this.Name+"\n"+"Employee Id : "+this.Id+"\n";
	}
	

}
