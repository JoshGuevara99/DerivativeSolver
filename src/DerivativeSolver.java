import java.util.*;
import java.util.Scanner;
public class DerivativeSolver 
{
	
	
	public DerivativeSolver()
	{
		
	}
	
	
	/*
	 * Returns the derivative of a variable which is 1
	 */
	public String VariableOnly(String function)
{
	
	String answer = Integer.toString(1);
	System.out.println(answer);
	return answer;
	
}


//  Returns the derivative of a constant which is 0
// 
	public int ConstantOnly(String function)
	{
		
		int derivativeOfConstant = 0;
		System.out.println(derivativeOfConstant);
		return derivativeOfConstant;
	}
	/*
	 * Returns the derivative of 
	 */
	
	
	/*
	 * Returns the derivative of a coefficient with a variable that has no exponent
	 */
	public int coefficientVariableNoPower(String function)
	{
		int answer = Integer.parseInt(function.substring(0,function.length()-1));
		System.out.println(answer);
		return answer;
	}
	
	/*
	 * Returns the derivative of a function with a coefficient and power
	 * by getting the substring of the numbers and computing the new coefficient and variable
	 */
	 
	public String CoefficientAndPower(String function)
	{
		char variable = 'x';
		
		for(int i = 0; i<function.length();i++)
		{
			if(Character.isLetter(function.charAt(i)))
			{
				variable = function.charAt(i);
				break;
			}
		}
		
		int oldCoefficient = Integer.parseInt(function.substring(0,function.indexOf(variable)));
		int exponentStart = function.indexOf('^');
		int oldExponent = Integer.parseInt(function.substring(exponentStart+1,function.length()));
		
		int newCoefficient = oldCoefficient * oldExponent;
		int newExponent = oldExponent - 1;
		
		String answer = Integer.toString(newCoefficient)+variable+'^'+Integer.toString(newExponent);
		
		System.out.println(answer);
		return answer;
		
	}
	 
	
	public void arbitrarySimpleFunction (String function)
	{	
		boolean hasLetters = false;
		
		
			/*
			 * Function that has a coefficient,variable, and power
			 */
			if(Character.isDigit(function.charAt(0))&& (Character.isDigit(function.charAt(function.length()-1))) && (function.length()>3))
			{
				
				CoefficientAndPower(function);
			}
			
			//Case where function is a coefficient and variable without a power
			if(Character.isDigit(function.charAt(0))&& Character.isLetter(function.charAt(function.length()-1)))
				{
					coefficientVariableNoPower(function);
				}
			
			
			for(int i = 0;i<function.length();i++)
			{
				if(Character.isLetter(function.charAt(i)))
				{
					hasLetters = true;
				}
			}
			//Case where the function consists solely of a constant
			if(hasLetters == false)
			{
				ConstantOnly(function);
			}
			
			
			/*
			 * Case where the function consists solely of a single variable
			 */
			if(function.length()==1 && Character.isLetter(function.charAt(0)))
			{
				VariableOnly(function);
				
				
			}
					
		
	}
	
	
	
	public static void main (String[]args)
	{		
		
		DerivativeSolver first = new DerivativeSolver();
		
		first.arbitrarySimpleFunction("3x");
		first.arbitrarySimpleFunction("333");
		first.arbitrarySimpleFunction("3x^2");
		first.arbitrarySimpleFunction("c");
		first.arbitrarySimpleFunction("12a^12");
		first.arbitrarySimpleFunction("1243b^99");
		
		
	}

}
