import java.util.Scanner;

public class main {
public static void main(String[] args) { 
	jacobsthal jac=new jacobsthal();   			   //initiating jacobsthal class
    Scanner scan  = new Scanner(System.in);	//Initiating Scanner
    int n = scan.nextInt();                	//Reading the size
    long start = System.nanoTime();
	 

	 
	for(int j=0;j<n;j++) {
		System.out.println(jac.Jacobsthal_recursive(j));// calling Jacobsthal_recursive method	
	}
	 long end = System.nanoTime();
	 long runTime = end - start;
	 System.out.println("Time taken to execute iterative version: "+runTime+" nanoseconds");

	start = System.nanoTime();
	for(int i=0;i<n;i++) {
		System.out.println(jac.Jacobsthal_iterative(i));// calling Jacobsthal_iterative method	
	}
	 end = System.nanoTime();
	 runTime = end - start;
	 System.out.println("Time taken to execute recursive version: "+runTime+" nanoseconds");
	
}
}
