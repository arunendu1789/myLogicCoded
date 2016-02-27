package dell.eclipse;

import java.util.Scanner;

public class WordFrequency {
	
	public String shiftArray(String traceWord)
	{
		String str="";
		int len=traceWord.length();
		char[] charStr = new char[len];
		charStr = traceWord.toCharArray();
		
		/*for(int i=0; i<len; i++)
		{
			for(int j=i+1; j<len; j++)
			{
				if(charStr[i]==charStr[j])
				{
					charStr[j]=' ';
				}
			}
		}*/
		
		for(int i=0;i<len;i++)
		{
			if(charStr[i]!=' ')
				str+=traceWord.charAt(i);
		}
		System.out.println(str);
		return str;
	}
	
	public static void main(String[] args) {
		String inputWord, traceWord;
		char[] workingCopy;
		int i,j,iwLen, twLen, freq=0, flag=0;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the word in which Search is to be implemented :");
		inputWord = scanner.next();
		System.out.println("Enter the word to be traced :");
		traceWord = scanner.next();
		System.out.println(traceWord);
		scanner.close();
		
		iwLen = inputWord.length();
		twLen = traceWord.length();
		//to remove the duplicate characters
		//traceWord = new WordFrequency().shiftArray("cc   hhh        g g");
		do
		{
			if(iwLen<twLen)
			{
				break;
			}
			else
			{
				workingCopy = inputWord.toCharArray();
				for(i=0;i<twLen;i++)
				{
					flag=0;
					for(j=0;j<iwLen;j++)
					{
						if(workingCopy[j]==traceWord.charAt(i))
						{
							workingCopy[j] = ' ';
							flag=1;
							break;
						}
					}
					if(flag==0)
					{
						break;
					}
						
				}
				if(flag==0)
				{
					break;
				}
				freq++;
				inputWord = new WordFrequency().shiftArray(String.valueOf(workingCopy));
				iwLen = inputWord.length();
			}
		}while(iwLen>twLen);
		
		if(freq!=0)
		{
			System.out.println("No of frequency = " +freq);
		}
		else
		{
			System.out.println("No of frequency = 0");
		}

	}

}
