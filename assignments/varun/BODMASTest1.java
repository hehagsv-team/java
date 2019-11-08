package assignments.varun;

import java.util.Stack;

// [Sunoop] Please refactor this code keeping only a maximum of 20 lines per method
// Modularize it further.
// The code is working which is great!!

public class BODMASTest1 {
	
	// [Sunoop] 
	// [1] why is static not removed yet?
	// [2] Have this method return float/double so that you can verify 
	// correctness using Assert from the main method
	// [3] Take in argument as String instead of Substring
	// Like double evalution(String substring)
	static void evaluate(StringBuffer substring)
	{
		int lastOpenBrace=substring.lastIndexOf("(");   
		int firstCloseBrace=substring.indexOf(")");
		if(firstCloseBrace==-1 && lastOpenBrace==-1)
		{	String string=substring.toString();
			char[] returned=calculateExpression(string);
			StringBuffer sb=new StringBuffer();
			String SpacelessString=String.valueOf(returned).trim();
			System.out.println(SpacelessString);
		}
		else
		{
			
			String cal=substring.substring(lastOpenBrace+1,firstCloseBrace);
			char[] returned=calculateExpression(cal);
			StringBuffer sb=new StringBuffer();
			String str=String.valueOf(returned).trim();
			sb=substring.replace(lastOpenBrace, firstCloseBrace+1, str);
			try
			{

				evaluate(sb);
       		 
			}
			catch(Exception e)
			{
				System.out.println("Please give the braces properly in the expression");
				System.exit(0);
			}
		}
		

	}

	// [Sunoop] Remove static
	private static char[] calculateExpression(String cal) {
		Stack<Integer> integers=new Stack<Integer>();
		Stack<Character> operators=new Stack<Character>();
		char[] splitString=cal.toCharArray();
		//System.out.println(splitString);
		int lowForSub;
		int lowForDivison,highForDivision;
		int lowForMultiplication,highforMultiplication;
		int lowForAdd,highForAdd;
		int highForSub,sr,sh_s;//sh_s---->shift start
        for(int i=0;i<splitString.length;i++)
        {
        	for(int div=0;div<splitString.length;div++)
        	{
        		if(splitString[div]=='/')
        		{
        			StringBuffer num = new StringBuffer();
        			for(lowForDivison=div-1;lowForDivison>=0;lowForDivison--)
        			{
        				if(splitString[lowForDivison]>='0' && splitString[lowForDivison]<='9')
        					num.append(splitString[lowForDivison]);
        				else
        					break;
        			}
        			num.reverse();
        			try
        			{

               			integers.push(Integer.parseInt(num.toString()));
               		 
        			}
        			catch(Exception e)
        			{
        				System.out.println("Please do not enter the operator followed by operator");
        				System.exit(0);
        			}
        			num.delete(0, num.length());
        			for(highForDivision=div+1;highForDivision<splitString.length;highForDivision++)
        			{
        				if(splitString[highForDivision]>='0' && splitString[highForDivision]<='9')
        					num.append(splitString[highForDivision]);
        				else
        					break;
        			}
        			integers.push(Integer.parseInt(num.toString()));
        			num.delete(0, num.length());
        			int value=calculate(integers.pop(),integers.pop(),splitString[div]);
        			String c=Integer.toString(value);
        			char[] split2=c.toCharArray();
        			for(sr=0;sr<split2.length;sr++)
        			{
        				sh_s=lowForDivison+sr+1;
        				splitString[sh_s]=split2[sr];
        			}
        			int repetetionForShift=(highForDivision-1)-(lowForDivison+split2.length);
        			int backup=repetetionForShift;
        			while(repetetionForShift>0)
        			{
        				shiftleft(lowForDivison+split2.length+1,splitString.length,splitString);
        				repetetionForShift--;
        			}
        			//make last 2 elements null
        			for(int it=splitString.length-1;it>=(splitString.length-backup);it--)
        			{
        				splitString[it]='\0';
        			}
        		}	
        	}
        	integers.clear();
        	//for multiplication
        	for(int mul=0;mul<splitString.length;mul++)
        	{
        		if(splitString[mul]=='*')
        		{
        			StringBuffer num = new StringBuffer();
        			for(lowForMultiplication=mul-1;lowForMultiplication>=0;lowForMultiplication--)
        			{
        				if(splitString[lowForMultiplication]>='0' && splitString[lowForMultiplication]<='9')
        					num.append(splitString[lowForMultiplication]);
        				else
        					break;
        			}
        			num.reverse();
        			try
        			{

               			integers.push(Integer.parseInt(num.toString()));
               		 
        			}
        			catch(Exception e)
        			{
        				System.out.println("Please do not enter the operator followed by operator");
        				System.exit(0);
        			}
        			num.delete(0, num.length());
        			for(highforMultiplication=mul+1;highforMultiplication<splitString.length;highforMultiplication++)
        			{
        				if(splitString[highforMultiplication]>='0' && splitString[highforMultiplication]<='9')
        					num.append(splitString[highforMultiplication]);
        				else
        					break;
        			}
        			integers.push(Integer.parseInt(num.toString()));
        			num.delete(0, num.length());
        			int value=calculate(integers.pop(),integers.pop(),splitString[mul]);
        			String c1=Integer.toString(value);
        			char[] splitForMul=c1.toCharArray();
        			for(sr=0;sr<splitForMul.length;sr++)
        			{
        				sh_s=lowForMultiplication+sr+1;
        				splitString[sh_s]=splitForMul[sr];
        			}
        			int shiftRepForMul=(highforMultiplication-1)-(lowForMultiplication+splitForMul.length);
        			int backupForMUL=shiftRepForMul;
        			while(shiftRepForMul>0)
        			{
        				shiftleft(lowForMultiplication+splitForMul.length+1,splitString.length,splitString);
        				shiftRepForMul--;
        			}
        			//make last 2 elements null
        			for(int it=splitString.length-1;it>=(splitString.length-backupForMUL);it--)
        			{
        				splitString[it]='\0';
        			}
        		}	
        	}
        	//for addition 
        	for(int add=0;add<splitString.length;add++)
        	{
        		if(splitString[add]=='+')
        		{
        			StringBuffer num = new StringBuffer();
        			for(lowForAdd=add-1;lowForAdd>=0;lowForAdd--)
        			{
        				if(splitString[lowForAdd]>='0' && splitString[lowForAdd]<='9')
        					num.append(splitString[lowForAdd]);
        				else
        					break;
        			}
        			num.reverse();
        			try
        			{

               			integers.push(Integer.parseInt(num.toString()));
               		 
        			}
        			catch(Exception e)
        			{
        				System.out.println("Please do not enter the operator followed by operator");
        				System.exit(0);
        			}
        			num.delete(0, num.length());
        			for(highForAdd=add+1;highForAdd<splitString.length;highForAdd++)
        			{
        				if(splitString[highForAdd]>='0' && splitString[highForAdd]<='9')
        					num.append(splitString[highForAdd]);
        				else
        					break;
        			}
        			integers.push(Integer.parseInt(num.toString()));
        			num.delete(0, num.length());
        			int f1Add=calculate(integers.pop(),integers.pop(),splitString[add]);
        			String c1Add=Integer.toString(f1Add);
        			char[] splitForAdd=c1Add.toCharArray();
        			for(sr=0;sr<splitForAdd.length;sr++)
        			{
        				sh_s=lowForAdd+sr+1;
        				splitString[sh_s]=splitForAdd[sr];
        			}
        			int shiftRepForAdd=(highForAdd-1)-(lowForAdd+splitForAdd.length);
        			int count=0;
        			int backupForAdd=shiftRepForAdd;
        			while(shiftRepForAdd>0)
        			{
        				shiftleft(lowForAdd+splitForAdd.length+1,splitString.length,splitString);
        				shiftRepForAdd--;
        				count++;
        			}
        			//make last 2 elements null
        			for(int it=splitString.length-1;it>=(splitString.length-backupForAdd);it--)
        			{
        				splitString[it]='\0';
        			}
        		}	
        	}
        	//for subtraction
        	for(int sub=0;sub<splitString.length;sub++)
        	{
        		if(splitString[sub]=='-')
        		{
        			StringBuffer num = new StringBuffer();
        			for(lowForSub=sub-1;lowForSub>=0;lowForSub--)
        			{
        				if(splitString[lowForSub]>='0' && splitString[lowForSub]<='9')
        					num.append(splitString[lowForSub]);
        				else
        					break;
        			}
        			num.reverse();
        			try
        			{

               			integers.push(Integer.parseInt(num.toString()));
               		 
        			}
        			catch(Exception e)
        			{
        				System.out.println("Please do not enter the operator followed by operator");
        				System.exit(0);
        			}
        			num.delete(0, num.length());
        			for(highForSub=sub+1;highForSub<splitString.length;highForSub++)
        			{
        				if(splitString[highForSub]>='0' && splitString[highForSub]<='9')
        					num.append(splitString[highForSub]);
        				else
        					break;
        			}
        			integers.push(Integer.parseInt(num.toString()));
        			num.delete(0, num.length());
        			int f1Sub=calculate(integers.pop(),integers.pop(),splitString[sub]);
        			String c1Sub=Integer.toString(f1Sub);
        			char[] splitForSub=c1Sub.toCharArray();
        			for(sr=0;sr<splitForSub.length;sr++)
        			{
        				sh_s=lowForSub+sr+1;
        				splitString[sh_s]=splitForSub[sr];
        			}
        			int shiftRepForSub=(highForSub-1)-(lowForSub+splitForSub.length);
        			int count=0;
        			int backupForSub=shiftRepForSub;
        			while(shiftRepForSub>0)
        			{
        				shiftleft(lowForSub+splitForSub.length+1,splitString.length,splitString);
        				shiftRepForSub--;
        				count++;
        			}
        			//make last 2 elements null
        			for(int it=splitString.length-1;it>=(splitString.length-backupForSub);it--)
        			{
        				splitString[it]='\0';
        			}
        		}	
        	}
        	
        	
        }	
        return splitString;	
	}

	private static void shiftleft(int start, int length, char[] splitString) {
		
		for(int starts=start;starts<splitString.length-1;starts++)   //start_i--->s_i
		{
			splitString[starts]=splitString[starts+1];
		}

	}

	private static int calculate(Integer num1, Integer num2, char operand) {
		switch(operand)
		{
		case '/':
			return num2/num1;
		case '*':
			return num2*num1;
		case '+':
			return num2+num1;
		case '-':
			return num2-num1;
		}
		return 0;
		
	}

	public static void main(String[] args) {
//		StringBuffer sb=new StringBuffer("12/2*6+9/5(14+22+(22+33+(44/2*22-2+444/2)))");
//		StringBuffer sb=new StringBuffer("12/(2*2/2)");
		StringBuffer sb=new StringBuffer("-12/-2");
		evaluate(sb);
		
		// [Sunoop] Use assert to test for various scenarios
		// For eg:
		// assert evaluate ("12/2") == 6;
		// assert evaluate (-12/2") == -6;
		// You can use java's built in assert (https://docs.oracle.com/javase/7/docs/technotes/guides/language/assert.html#usage) 
		// or use org.junit.Assert (You will have to add junit.jar to the Build classpath in eclipse to compile)
		
		}
	}