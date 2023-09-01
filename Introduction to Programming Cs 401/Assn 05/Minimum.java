public class Minimum {
public static int minimum(int A[], int size) {
	
if(size==1) {
	return A[0];	//Implementing base case when size of array=1
	
}
else {
	//Recursive step to implement Minimum function
	return Math.min(A[size-1], minimum(A,size-1));
}
}
public static void main(String args[]) {
int A[] = {10, -20, 1, 2, 0, 5, 100};
int s = minimum(A, A.length);
System.out.println(s);
}
}