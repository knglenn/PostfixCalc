/* PostfixCalc by Kevin Glenn

Description: postfix calculator with memory
*/

import java.util.*;

public class PostfixCalc
{
	private static HashMap<String, Double> memory = new HashMap<>();
	
	public static void printMemory()
	{
		
		System.out.println(memory);
		
	}
	
	public static void main(String[] args)
	{
		
		System.out.println("Postfix calculator with memory by Kevin Glenn");
		Scanner scan = new Scanner(System.in);
		Stack <Double> stack  = new Stack<>();
		double num1 = 0;
		double num2 = 0;
		

		
		while (true)
		{
			int start = 0;
			String varName = "";
			boolean variable = false;
			System.out.print("> ");
			String line = scan.nextLine();
			String[] tokens = line.split(" ");
			String temp = "";
			
			for (int i=0; i < tokens.length; i++)
			{
				char b = tokens[i].charAt(0);
				if (b == '=')
				{
					variable = true;
					start = 2;
				}
			}

			if (tokens[0].equals("quit"))
			{	
				System.exit(0);	
			}
			else if (tokens[0].equals("var"))
			{	
				System.out.println(memory);	
				continue;
			}
			else if (tokens[0].equals("clear"))
			{	
				memory.clear();	
				continue;	
			}
			else if (tokens[0].equals("delete"))
			{
				memory.remove(tokens[1]);
				continue;
			}

			for (int k=start; k < tokens.length; k++)
			{
				char c = tokens[k].charAt(0);
				double output = 0;

				if (variable == true)
				{
					varName = tokens[0];
				}
				
				if (tokens[k].equals("+"))
				{	
					try 
					{
						num1 = stack.pop();
						num2 = stack.pop();
						stack.push(num1 + num2);	
					}	
					catch (EmptyStackException e)	
					{							
						System.out.println("Error");							
					}
											
						
				}
				else if (tokens[k].equals("-"))
				{
					try 
					{								
						num1 = stack.pop();
						num2 = stack.pop();	
						stack.push(num2 -num1);						
					}	
					catch (EmptyStackException e)	
					{							
						System.out.println("Error");						
					}
					
				} 
				else if (tokens[k].equals("/"))
				{
					try 
					{		
						num1 = stack.pop();
						num2 = stack.pop();
						stack.push(num2 / num1);
					}	
					catch (EmptyStackException e)	
					{	
						System.out.println("Error");						
					}
							
				}
				else if (tokens[k].equals("*"))
				{
					try 
					{	
						num1 = stack.pop();
						num2 = stack.pop();
						stack.push(num1 * num2);
					}	
					catch (EmptyStackException e)	
					{	
						System.out.println("Error");		
					}

				}

				else if (tokens[k].equals("^"))
				{
					try
					{
						num1 = stack.pop();
						num2 = stack.pop();
						stack.push(Math.pow(num2, num1));
					}
					catch (EmptyStackException e)
					{
						System.out.println("Error");
					}
				}
				else if (memory.containsKey(tokens[k]))
				{
					stack.push(memory.get(tokens[k]));	
				}
				else if (tokens[k].equals("="))
				{
					
					variable = true;
					
				}
				else if (Character.isDigit(c)) 
				{
					double number = Double.parseDouble(tokens[k]);
					stack.push(number);	
				}
				else
				{
					System.out.println("Error '" + tokens[k] + "' is not recognized");
					break;
				}
			}
			
			
			
			if (variable == true)
			{				
				try 
				{							
					temp = "" + stack.pop();
					num1 = Double.parseDouble(temp);
					memory.put("" + varName, num1);	
					System.out.println(varName + "= " + memory.get(varName));				
				}	
				catch (EmptyStackException e)	
				{						
					System.out.println("Error: Please Try Again");						
				}			
				variable = false;		
			}
			else if ((!tokens[0].equals("clear")) && (!tokens[0].equals("var")) && (!tokens[0].equals("quit") && (!tokens[0].equals("delete"))))
			{
				try 
				{	
						System.out.println(stack.pop());				
				}	
				catch (EmptyStackException e)	
				{	
						System.out.println("Error: Please Try Again!");	
				}	
			}
		}
	}
}
