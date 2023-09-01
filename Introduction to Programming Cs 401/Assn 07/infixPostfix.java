
public class infixPostfix {
	// initializing empty stack
	
	//Priority Method to assign priority to operators 
	public int priorityOrder(char ch)
	{
		if (ch=='+' | ch=='-') {
			return 1;	
		}

		else if (ch=='/' | ch=='*') {
			return 2;
		}

		else if (ch=='^') {
			return 2;
		}
		
		return 0;
		
}

	public String infixToPostfix(String expression)
	{	
		Stack<Character> s= new Stack<Character>();
	
		// initializing empty String for postfix
		String postfix = new String("");


		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);

			//Add the character to postfix strings if its an operand
			if (Character.isLetterOrDigit(ch)) {
				postfix += ch;
			}
			
			//When an operator is present then check the priority of operator
			//If operator with greater priority is present pop the operator and add it to postfix
			else // an operator is encountered
			{
				while (!s.isEmpty()
					&& priorityOrder(ch) <= priorityOrder(s.peek())) {

					postfix += s.peek();
					s.pop();
				}
				s.push(ch);
			}
		}

		// pop all the operators from the stack and append to postfix
		while (!s.isEmpty()) {
			if (s.peek() == '(')
				return "Invalid Expression";
			postfix += s.peek();
			s.pop();
		}
		return postfix;
	}
	
	public int evaluatePostfix(String expression)
    {
		Stack<Integer> st= new Stack<Integer>();
        // Scan all characters one by one
        for(int i=0;i<expression.length();i++)
        {
            char ch=expression.charAt(i);
             
            //If the Char is operand push into stack
            if(Character.isDigit(ch)) {
            st.push(Character.getNumericValue(ch));
            }
            //  If the scanned character is an operator, pop operands and perform the operation and push it back to stack
            // 
            else
            {
                int val1 = st.peek();
                st.pop();
                int val2 = st.peek();
                st.pop();
                
                if(ch=='+')
                {
                 st.push(val2+val1);
                }
                else if(ch=='-') {   
                    st.push(val2- val1);
                }
                else if(ch=='/')   {  
                    st.push(val2/val1);
                }
                else if(ch=='*')   { 
                    st.push(val2*val1);
              }
            }
        }
        return st.peek();   //Reading the final value of the evaluation
    }
	
}
