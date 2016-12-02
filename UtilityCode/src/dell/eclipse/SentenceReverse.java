package dell.eclipse;

import java.util.Scanner;

public class SentenceReverse {

	public static void main(String[] args) {
		String inputStr, outputStr;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter any sentence: ");
		inputStr = scanner.nextLine();
		scanner.close();
		
		outputStr = "";
		for(int i=0; i<inputStr.length(); i++)
		{
			if(inputStr.charAt(i)!=' ')
			{
				if(inputStr.charAt(inputStr.length()-1-i) != ' ')
				{
					if((i-1)>=0)
					{
						if(inputStr.charAt(i-1) != ' ')
						{
							outputStr += inputStr.charAt(inputStr.length()-1-i);
						}
						else if (inputStr.charAt(i-1) == ' ')
						{
							outputStr += inputStr.charAt(inputStr.length()-i);
							outputStr += inputStr.charAt(inputStr.length()-1-i);
						}
					}
					else
					{
						
						
						outputStr += inputStr.charAt(inputStr.length()-1-i);
					}
				}
				else
				{
					outputStr += inputStr.charAt(inputStr.length()-i);
				}
			}
			else
			{
				outputStr += " ";
			}
		}
		
		System.out.println("The sentence after reversal keeping the index of Space constant is : \n" +outputStr);
	}

}
