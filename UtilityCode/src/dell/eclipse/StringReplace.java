package dell.eclipse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringReplace {
	
	public static void main(String[] args) {
		String str, intToBinary, suffixToAdd = "0";
		int noOfQMark = 0, noOfStrPossible,k,flag=0;
		List<String> strOut = new ArrayList<>();
		char[] strToCharArr;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a String : ");
		str = scanner.next();
		scanner.close();
		
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='?'){
				noOfQMark++;
			}
		}
		
		noOfStrPossible =(int) Math.pow(2, noOfQMark);
		System.out.println("No of String possible = "+noOfStrPossible);
		
		for(int i=0;i<noOfStrPossible;i++){
			
			intToBinary = Integer.toBinaryString(i);
			System.out.println("Converted : "+i+" to Binary as : "+intToBinary+ "\n\n\n\n\n");
			
			if(noOfQMark-intToBinary.length()>0){
				suffixToAdd = "0";
				for(int l=0;l<(noOfQMark-intToBinary.length())-1;l++){
					suffixToAdd +="0";
				}
				intToBinary = suffixToAdd+intToBinary;
			}
			
			System.out.println("Suffix added : "+intToBinary+ "\n\n\n\n\n");
			
			strToCharArr = str.toCharArray();
			System.out.println("Converted String to Character Array!!!"+ "\n\n\n\n\n");
			k=0;
			flag=0;
			for(int j=0;j<str.length();j++){
				if(strToCharArr[j]=='?'){
					strToCharArr[j] = intToBinary.charAt(k);
					k++;
					flag=1;
				}
			}
			if(flag==1){
				strOut.add(String.valueOf(strToCharArr));
			}
		}
		
		System.out.println("Possible Strings are :");
		for(String strout : strOut){
			System.out.println("=> "+ strout);
		}
		
	}

}
