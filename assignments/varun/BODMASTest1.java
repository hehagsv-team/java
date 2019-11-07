package assignments.varun;


import java.util.Stack;

public class BODMASTest1
{
    public int evaluate(String expr)
    {
        char[] splitString = expr.toCharArray();

        Stack<Integer> numbers = new Stack<Integer>();
        Stack<Character> operators = new Stack<Character>();

        for (int i = 0; i < splitString.length; i++)
        {
            // ignore space
        	if (Character.isWhitespace(splitString[i]))
        		continue;
//        	if (splitString[i] == ' ')
//                continue;

        	// check for negative sign followed by digits but it should not be minus operator
        	// define a negative number:
        	// 1. there should not be digit before the negative sign
        	// 2. there should not be an operation before the negative sign
        	
        	// if digits and the following numbers are digits
        	if (Character.isDigit(splitString[i]))
//            if (splitString[i] >= '0' && splitString[i] <= '9')
            {
        		// return the entire number 
//        		int localNumber = getNumber (splitString, i);
        		
                StringBuffer numberString = new StringBuffer();
                while (i < splitString.length && splitString[i] >= '0' && splitString[i] <= '9')
                    numberString.append(splitString[i++]);
                numbers.push(Integer.parseInt(numberString.toString()));
            }

            /**
             * brackets take precedence.
             * push all operations within a bracket into a stack
             * a bracket within a bracket takes more precedence.
             */
            
            else if (splitString[i] == '(')
                operators.push(splitString[i]);

            else if (splitString[i] == ')')
            {
                while (operators.peek() != '(')
                  numbers.push(calculate(operators.pop(), numbers.pop(), numbers.pop()));
                operators.pop();
            }

            else if (splitString[i] == '+' || splitString[i] == '-' ||
                     splitString[i] == '*' || splitString[i] == '/')
            {
                
                while (!operators.empty() && checkPrecedence(splitString[i], operators.peek()))
                  numbers.push(calculate(operators.pop(), numbers.pop(), numbers.pop()));

                
                operators.push(splitString[i]);
            }
        }

        while (!operators.empty())
            numbers.push(calculate(operators.pop(), numbers.pop(), numbers.pop()));

        
        return numbers.pop();
    }

    public boolean checkPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    public int calculate(char op, int b, int a)
    {
        switch (op)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        }
        return 0;
    }

    public static void main(String[] args)
    {
        BODMASTest1 test = new BODMASTest1(); 
    	System.out.println(test.evaluate("-12 * ( 2+ (-12*2) ) / 14"));
    }
}
