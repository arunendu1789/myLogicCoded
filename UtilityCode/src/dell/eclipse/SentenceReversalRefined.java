package dell.eclipse;

import java.util.Scanner;

public class SentenceReversalRefined {
	public static void main(String[] args) {
		String inputStr, outputStr="";
		int length, j=0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter any sentence: ");
		inputStr = scanner.nextLine();
		scanner.close();
		
		length = inputStr.length();
		j = length-1;
		
		for(int i=0; i<length; i++)
		{
			if(inputStr.charAt(i) != ' ')
			{
				if(inputStr.charAt(j) == ' ')
				{
					j--;
				}
				outputStr += inputStr.charAt(j);
				j--;
			}
			else
			{
				outputStr += " ";
			}
		}
		
		System.out.println("The sentence after reversal keeping the index of Space constant is : \n" +outputStr);
	}

}
