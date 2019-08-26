import java.util.Scanner;
public class DerivativeSolver {
	
	private Scanner input = new Scanner(System.in);
	private String actualInput;
	
	
//	
	/*
	 * Starts the process of solving an derivative by prompting user
	 * to enter a function. If function not empty, invoke the
	 * solve method
	 */
	public DerivativeSolver()
	{
		System.out.println("Please enter a function:");
		actualInput = this.input.nextLine();
		if(actualInput != null)
		{
			for(int i = 0; i< actualInput.length();i++)
			{
				if(Character.isDigit(actualInput.charAt(actualInput.length()-1))&&i==1 && Character.isLetter(actualInput.charAt(i)))
				{
					SingleDigitCoefficientSingleDigitPower(actualInput);
					break;
				}
				if(i== 2 && Character.isLetter(actualInput.charAt(i)))
				{
					TwoDigitCoefficientSingleDigitPower(actualInput);
					break;
				}
				if(actualInput.length()== 1 && Character.isLetter(actualInput.charAt(i)))
				{
					VariableOnly(actualInput);
					break;
				}
				if(actualInput.length()== 2 && Character.isLetter(actualInput.charAt(actualInput.length()-1)))
				{
					SingleDigitCoefficientNoPower(actualInput);
					break;
				}
				if(actualInput.matches("[0-9]+"))
				{
					ConstantOnly(actualInput);
					break;
				}
			
			}

		}
		else
		{
			System.out.println("Null function");
		}
	}
	
	/*
	 * Takes in a simple String function with a single lead coefficient and power, and returns the derivative of it.
	 */
	public String SingleDigitCoefficientSingleDigitPower(String function)
	{	System.out.println("using SingleDigitCoefficientSingleDigitPower");
		int leadCoefficient1 = Integer.parseInt(function.substring(0, 1));
		char variable = actualInput.charAt(1);
		int power1 = Integer.parseInt(function.substring(function.length()-1,function.length()));
		
		int leadCoefficientProduct = leadCoefficient1 * power1;
		int power1Difference = power1 - 1;
		String answer = Integer.toString(leadCoefficientProduct)+variable+'^'+power1Difference;
		System.out.println(answer);
		return answer;
	}
	/*
	 * Takes in a String function with two lead coefficients and a single digit power.
	 */
	public String TwoDigitCoefficientSingleDigitPower(String function)
	{
		System.out.println("Derivitive of TwoDigitCoefficientSingleDigitPower");
		int leadCoefficient1 = Integer.parseInt(function.substring(0,1));
		int leadCoefficient2 = Integer.parseInt(function.substring(1,2));
		char variable = actualInput.charAt(2);
		int power1 = Integer.parseInt(function.substring(function.length()-1,function.length()));
		int leadCoefficientReal = Integer.parseInt(leadCoefficient1 + ""+ leadCoefficient2);
		int leadCoefficientProduct = leadCoefficientReal * power1;
		int power1Difference = power1 - 1;
		String answer = Integer.toString(leadCoefficientProduct)+variable+'^'+power1Difference;
		System.out.println(answer);
		return answer;
		
	}
/*
 *	Takes in String function with no lead Coefficient, one variable and no exponent
 */
	public String VariableOnly(String function)
{
	System.out.println("Derivitive of VariableOnly");
	String answer = Integer.toString(1);
	System.out.println(answer);
	return answer;
	
}
/*
 * Takes in simple function with one lead coefficient and one variable, no exponent
 */
	public String SingleDigitCoefficientNoPower(String function)

	
	{
		System.out.println("Derivitive of SingleDigitCoefficientNoPower");
		int leadCoefficient1 = Integer.parseInt(actualInput.substring(0,1));
		String answer = Integer.toString(leadCoefficient1);
		System.out.println(answer);
		return answer;
	}
/*
 * Takes in a constant without variable
 */
	public int ConstantOnly(String function)

	{
		System.out.println("Derivitive of ConstantOnly");
		int derivativeOfConstant = 0;
		System.out.println(derivativeOfConstant);
		return derivativeOfConstant;
	}
	
	
	public static void main (String[]args)
	{		
		
		DerivativeSolver first = new DerivativeSolver();
		
		
	}

}
