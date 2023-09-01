import java.util.Scanner;

public class palindromemain {
    public static void main(String[] args) {

    	System.out.print("Enter string to validate : ");
        Scanner scan=new Scanner(System.in);      //Initiating Scanner
        String inputString = scan.nextLine();	  //Reading the input and assigning the string value
        scan.close();							  //Closing Scanner
        inputString=inputString.toLowerCase();
        
        palindrome p=new palindrome();
        if (p.isPalindrome(inputString))	//Checking whether the given string is a palindrome
            System.out.println("Given String is a Palindrome.");
        else
            System.out.println("Given String is not a Palindrome.");
        
    }
        
}
