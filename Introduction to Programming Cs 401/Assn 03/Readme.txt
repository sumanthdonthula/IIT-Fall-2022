Problem 2:

We have 2 classes BubbleSort.java and main.java

BubbleSort.java:

BubbleSort class is used in initiating the variables and methods associated with it.

The main steps involved in BubbleSort class is :
1) Created a BubbleSort method which will accept the Array as an input arguement and
sorts the array.

BubbleSort :
In the BubbleSort method we will loop over all elements from 0 till n-1 index and compares with next elements.
If the next element is smaller than the current element it swaps the values.

2)This returns a sorted Array.
3)Calculated Start and End time of program to calculate run time
4)Complexity of Code is N^2

main.java:

main class is used to get the values of radius using scanner and calling the methods associated with BubbleSort class

The main steps involved in main class is :

1)Scanning the size value using a scanner
3)Initiating an empty array of size n.
2)Scanning the elements of array
2)Created an instance of the BubbleSort class
3)Passed the array to BubbleSort Method
4)Returned the Sorted Array