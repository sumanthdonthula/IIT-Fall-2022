//Creating a class called jacobsthal
public class jacobsthal {
	long Jacobsthal_recursive(int n) {
		if(n==0) {		//Base case for jacobsthal
			return 0;			
		}
		if(n==1) {		//Base case for jacobsthal
			return 1;
			
		}
		else{			//Recursion step to implement jacobian
			return Jacobsthal_recursive(n-1)+2*Jacobsthal_recursive(n-2);
		}		
	}
	
	long Jacobsthal_iterative(int n) {
		int jac = 0;		//Initializing variable to store jacobsthal value
		int jn_1 = 0;			//Initializing base vale
		int jn_2=1;			//Initializing base vale
		if(n==0) {
			jac= 0;			//Jacobsthal value when n=0
		}
		if(n==1) {
			jac= 1;			//Jacobsthal value when n=1
		}
		else {
		//for loop to implement Jacobsthal value when n>1
		for(int i=2;i<n+1;i++) {
			jac=jn_2+2*jn_1;
			jn_1=jn_2;
			jn_2=jac;
			}
			
		}		
		return jac;
	}

}
