package com.dss.basics;

import java.util.Stack;

public class Bodmas {
	
	 void evalution(StringBuffer substring)
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
			System.out.println(sb);
			try
			{

				evalution(sb);
       		 
			}
			catch(Exception e)
			{
				System.out.println("Please give the braces properly in the expression");
				System.exit(0);
			}
		}
		

	}

	private  char[] calculateExpression(String cal) {

		char[] splitString=cal.toCharArray();
		char[] splitString1=removalOfOperators(splitString);
        for(int i=0;i<splitString1.length;i++)
        {
        	division(splitString1);
        	//integers.clear();
        	String strd1=new String(splitString1);
        	splitString1=strd1.trim().toCharArray();
        	//for multiplication
        	multiplicaton(splitString1);
        	String strd2=new String(splitString1);
        	splitString1=strd2.trim().toCharArray();
        	//for addition
        	addition(splitString1);
        	String strd3=new String(splitString1);
        	splitString1=strd3.trim().toCharArray();
        	//for substraction
        	substraction(splitString1);	
        }	
        return splitString1;	
	}

	private void substraction(char[] splitString1) {
		// TODO Auto-generated method stub
		Stack<Integer> integers=new Stack<Integer>();
		Stack<Character> operators=new Stack<Character>();
		int highForSub,lowForSub,sr,sh_s;

    	for(int sub=0;sub<splitString1.length;sub++)
    	{
    		if(splitString1[sub]=='-')
    		{
    			StringBuffer num = new StringBuffer();
    			for(lowForSub=sub-1;lowForSub>=0;lowForSub--)
    			{
    				if(splitString1[lowForSub]>='0' && splitString1[lowForSub]<='9')
    					num.append(splitString1[lowForSub]);
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
    				//System.exit(0);
    			}
    			num.delete(0, num.length());
    			for(highForSub=sub+1;highForSub<splitString1.length;highForSub++)
    			{
    				if(splitString1[highForSub]>='0' && splitString1[highForSub]<='9')
    					num.append(splitString1[highForSub]);
    				else
    					break;
    			}
    			integers.push(Integer.parseInt(num.toString()));
    			num.delete(0, num.length());
    			int f1Sub=calculate(integers.pop(),integers.pop(),splitString1[sub]);
    			String c1Sub=Integer.toString(f1Sub);
    			char[] splitForSub=c1Sub.toCharArray();
    			for(sr=0;sr<splitForSub.length;sr++)
    			{
    				sh_s=lowForSub+sr+1;
    				splitString1[sh_s]=splitForSub[sr];
    			}
    			int shiftRepForSub=(highForSub-1)-(lowForSub+splitForSub.length);
    			int count=0;
    			int backupForSub=shiftRepForSub;
    			while(shiftRepForSub>0)
    			{
    				shiftleft(lowForSub+splitForSub.length+1,splitString1.length,splitString1);
    				shiftRepForSub--;
    				count++;
    			}
    			//make last 2 elements null
    			for(int it=splitString1.length-1;it>=(splitString1.length-backupForSub);it--)
    			{
    				splitString1[it]='\0';
    			}
    		}	
    	}
		
	}

	private void addition(char[] splitString1) {
		// TODO Auto-generated method stub
		Stack<Integer> integers=new Stack<Integer>();
		Stack<Character> operators=new Stack<Character>();
		int lowForAdd,highForAdd,sr,sh_s;
		if(splitString1[0]=='+')
    	{
    		shiftleft(0,splitString1.length,splitString1);
    		splitString1[splitString1.length-1]='\0';
    		String strdup=new String(splitString1);
    		splitString1=strdup.trim().toCharArray();
    	}
    	for(int add=0;add<splitString1.length;add++)
    	{
    		if(splitString1[add]=='+')
    		{
    			StringBuffer num = new StringBuffer();
    			for(lowForAdd=add-1;lowForAdd>=0;lowForAdd--)
    			{
    				if(splitString1[lowForAdd]>='0' && splitString1[lowForAdd]<='9')
    					num.append(splitString1[lowForAdd]);
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
    			for(highForAdd=add+1;highForAdd<splitString1.length;highForAdd++)
    			{
    				if(splitString1[highForAdd]>='0' && splitString1[highForAdd]<='9')
    					num.append(splitString1[highForAdd]);
    				else
    					break;
    			}
    			integers.push(Integer.parseInt(num.toString()));
    			num.delete(0, num.length());
    			int f1Add=calculate(integers.pop(),integers.pop(),splitString1[add]);
    			String c1Add=Integer.toString(f1Add);
    			char[] splitForAdd=c1Add.toCharArray();
    			for(sr=0;sr<splitForAdd.length;sr++)
    			{
    				sh_s=lowForAdd+sr+1;
    				splitString1[sh_s]=splitForAdd[sr];
    			}
    			int shiftRepForAdd=(highForAdd-1)-(lowForAdd+splitForAdd.length);
    			int count=0;
    			int backupForAdd=shiftRepForAdd;
    			while(shiftRepForAdd>0)
    			{
    				shiftleft(lowForAdd+splitForAdd.length+1,splitString1.length,splitString1);
    				shiftRepForAdd--;
    				count++;
    			}
    			//make last 2 elements null
    			for(int it=splitString1.length-1;it>=(splitString1.length-backupForAdd);it--)
    			{
    				splitString1[it]='\0';
    			}
    		}	
    	}
		
	}

	private void multiplicaton(char[] splitString1) {
		// TODO Auto-generated method stub
		Stack<Integer> integers=new Stack<Integer>();
		Stack<Character> operators=new Stack<Character>();
		int lowForMultiplication,highforMultiplication,sr,sh_s;
		for(int mul=0;mul<splitString1.length;mul++)
    	{
    		if(splitString1[mul]=='*')
    		{
    			StringBuffer num = new StringBuffer();
    			for(lowForMultiplication=mul-1;lowForMultiplication>=0;lowForMultiplication--)
    			{
    				if(splitString1[lowForMultiplication]>='0' && splitString1[lowForMultiplication]<='9')
    					num.append(splitString1[lowForMultiplication]);
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
    			for(highforMultiplication=mul+1;highforMultiplication<splitString1.length;highforMultiplication++)
    			{
    				if(splitString1[highforMultiplication]>='0' && splitString1[highforMultiplication]<='9')
    					num.append(splitString1[highforMultiplication]);
    				else
    					break;
    			}
    			integers.push(Integer.parseInt(num.toString()));
    			num.delete(0, num.length());
    			int value=calculate(integers.pop(),integers.pop(),splitString1[mul]);
    			String c1=Integer.toString(value);
    			char[] splitForMul=c1.toCharArray();
    			for(sr=0;sr<splitForMul.length;sr++)
    			{
    				sh_s=lowForMultiplication+sr+1;
    				splitString1[sh_s]=splitForMul[sr];
    			}
    			int shiftRepForMul=(highforMultiplication-1)-(lowForMultiplication+splitForMul.length);
    			int backupForMUL=shiftRepForMul;
    			while(shiftRepForMul>0)
    			{
    				shiftleft(lowForMultiplication+splitForMul.length+1,splitString1.length,splitString1);
    				shiftRepForMul--;
    			}
    			//make last 2 elements null
    			for(int it=splitString1.length-1;it>=(splitString1.length-backupForMUL);it--)
    			{
    				splitString1[it]='\0';
    			}
    		}	
    	}
		
	}

	private void division(char[] splitString1) {
		// TODO Auto-generated method stub
		int lowForDivison,highForDivision,sr,sh_s;;
		Stack<Integer> integers=new Stack<Integer>();
		Stack<Character> operators=new Stack<Character>();
		for(int div=0;div<splitString1.length;div++)
    	{
    		if(splitString1[div]=='/')
    		{
    			StringBuffer num = new StringBuffer();
    			for(lowForDivison=div-1;lowForDivison>=0;lowForDivison--)
    			{
    				if(splitString1[lowForDivison]>='0' && splitString1[lowForDivison]<='9')
    					num.append(splitString1[lowForDivison]);
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
    			for(highForDivision=div+1;highForDivision<splitString1.length;highForDivision++)
    			{
    				if(splitString1[highForDivision]>='0' && splitString1[highForDivision]<='9')
    					num.append(splitString1[highForDivision]);
    				else
    					break;
    			}
    			integers.push(Integer.parseInt(num.toString()));
    			num.delete(0, num.length());
    			int value=calculate(integers.pop(),integers.pop(),splitString1[div]);
    			String c=Integer.toString(value);
    			char[] split2=c.toCharArray();
    			for(sr=0;sr<split2.length;sr++)
    			{
    				sh_s=lowForDivison+sr+1;
    				splitString1[sh_s]=split2[sr];
    			}
    			//System.out.println(splitString1);
    			int repetetionForShift=(highForDivision-1)-(lowForDivison+split2.length);
    			int backup=repetetionForShift;
    			while(repetetionForShift>0)
    			{
    				shiftleft(lowForDivison+split2.length+1,splitString1.length,splitString1);
    				repetetionForShift--;
    			}
    			//make last 2 elements null
    			for(int it=splitString1.length-1;it>=(splitString1.length-backup);it--)
    			{
    				splitString1[it]='\0';
    			}
    		}	
    	}
		
	}

	private char[] removalOfOperators(char[] splitString) {
		// TODO Auto-generated method stub
		Stack<Integer> numbers=new Stack<Integer>();
		Stack operator_s=new Stack();
		Stack operator2=new Stack();
		//System.out.println(splitString);
		//System.out.println(splitString.length);
		for(int i=0;i<splitString.length;i++)
		{
			int low,arL = 0,arH = 0;
			int high;
			int k,dupK,shiftLeftCount=0;
			int[] arrayLow = new int[10];
			int[] arrayHigh= new int[10];
			if(splitString[i]=='/' || splitString[i]=='*')
			{
				StringBuffer sb1=new StringBuffer();
				int breaki=0; //if + or - got encountered then no need of checking that  '0' and '9'
				for(low=i-1;low>=0;low--)
				{
					if(splitString[low]>='0' && splitString[low]<='9' && breaki==0)
						continue;//sb1.append(splitstring[i]);
					else if(splitString[low]=='+' || splitString[low]=='-')
					{
						operator_s.add(splitString[low]);
						arrayLow[arL++]=low;
						breaki++;
						
					}
					else if(splitString[low]>='0' && splitString[low]<='9' && breaki==0)
						continue;
					else
						break;
				}
				for(high=i+1;i<splitString.length;high++)
				{
					if(splitString[high]=='+' || splitString[high]=='-')
					{
						operator_s.add(splitString[high]);
						arrayHigh[arH++]=high;
					}
					else if(splitString[high]=='(')
						continue;//operators.add(splitstring[high]);
					else
						break;
				}
				k=operator_s.size();
				dupK=k;
				//poping and removing + and - operators between / and * operators
				while(k>1)
				{
					String returned=checkoperators(operator_s.pop(),operator_s.pop());
					operator_s.add(returned);
					k--;
				}
				if(dupK>1)
				{
					Object e=operator_s.peek();
					String ls=e.toString();
					//System.out.println(ls);
					char[] spl=ls.toCharArray();
					  // k is stack size
					splitString[low+1]=spl[0];
				}
				
				//shifting elements 
				for(int rev=0;rev<dupK-1;rev++)
				{
					shiftleft(arrayHigh[rev],splitString.length,splitString);
					shiftLeftCount++;
					for(int p=rev+1;p<dupK-1;p++)
					{
						arrayHigh[p]=arrayHigh[p]-1;
					}
				}
				
				
				//making last shifted elements null
				for(int it=splitString.length-1;it>splitString.length-shiftLeftCount-1;it--)
				{
					splitString[it]='\0';
					
				}
				String split23=new String(splitString);
				splitString=split23.trim().toCharArray();
				//System.out.println(splitString);
				operator_s.clear();
			}
			
		}
		char[] splitString2=removalOfop(splitString);
		return splitString2;
		
	}

	private char[] removalOfop(char[] splitString) {
		// TODO Auto-generated method stub
		int shiftl=0;
		for(int shiftop=0;shiftop<splitString.length-1;shiftop++)
		{
			if(splitString[shiftop]=='/' || splitString[shiftop]=='*' || splitString[shiftop]=='(' || splitString[shiftop]==')')
			{
				if(splitString[shiftop+1]=='+')
				{
					shiftleft(shiftop+1,splitString.length,splitString);
					shiftl++;
				}
			}
		} 
		
		//making last shifted elements null
		String split2=new String(splitString);
		splitString=split2.trim().toCharArray();

		for(int it=splitString.length-1;it>splitString.length-shiftl-1;it--)
		{
			splitString[it]='\0';
			
		}
		
		String split22=new String(splitString);
		splitString=split22.trim().toCharArray();
		//System.out.println(splitString);
		return splitString;
		
		
	}

	private void shiftleft(int start, int length, char[] splitString) {
		
		for(int starts=start;starts<splitString.length-1;starts++)   //start_i--->s_i
		{
			splitString[starts]=splitString[starts+1];
		}

	}

	private int calculate(Integer num1, Integer num2, char operand) {
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
	private String checkoperators(Object op1, Object op2) {
		String str1=op1.toString();
		String str2=op2.toString();
		if(str1.equals("-")  && str2.equals("+"))
			return "-";
		else if(str1.equals("+")  && str2.equals("-"))
			return "-";
		else if(str1.equals("+")  && str2.equals("+"))
			return "+";
		else if(str1.equals("-")  && str2.equals("-"))
			return "+";
		return str2;
	}

	public static void main(String[] args) {
		Bodmas b=new Bodmas();
		StringBuffer sb=new StringBuffer("-12/-2*6+9/5+(14+22+(22+33+(-44/-2*(22)-2+444/-2)))");
		b.evalution(sb);
		}
	}
