import java.util.Scanner;

public class infixPostfixmain {

	public static void main(String[] args){
	System.out.print("Infix Expression : ");
	Scanner scan  = new Scanner(System.in); //Initiating Scanner
	String infix = scan.nextLine(); //Assigning Student name with scanner
	scan.close();					//Closing Scanner
	infixPostfix in=new infixPostfix();//Initiating the infixPostfix class
	System.out.println("Postfix : "+ in.infixToPostfix(infix));//Printing the result
	String postFix=in.infixToPostfix(infix);
	System.out.println("Evaluation : "+in.evaluatePostfix(postFix));	
	
	}	

}
