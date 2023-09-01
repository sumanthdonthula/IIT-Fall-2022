import java.util.Scanner;

public class palindrome {


				
    Stack<Character> st = new Stack<Character>();//Initiating a new Stack Object        
	        
	        public boolean isPalindrome(String s) {
	        	for(int i=0;i<s.length();i++) {
	        		st.push(s.charAt(i));
	        		
	        	}
	        	String revStr = "";
	        	
	        	while (!st.isEmpty()) {
		        	revStr = revStr+st.peek();
		        	st.pop();
		        }
	        	
	        	return s.equals(revStr);
	    }
	}
	
