package dell.eclipse;

import java.util.Scanner;

public class NumAddInString {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String n = null,no="";
		int sum=0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a String containing numbers :: ");
		n=scanner.nextLine();
		scanner.close();
		char str[]=n.toCharArray();
		
		for(int i=0; i<str.length;i++){
			if(str[i]>=48&&str[i]<=57){
				no+=str[i];
			}
			else{
				if(!(no.equals(""))) {
					sum+=Integer.parseInt(no);
				}
				no="";
			}
		}
		if(!(no.equals(""))) {
			sum+=Integer.parseInt(no);
		}
		System.out.println("Sum of numbers : "+sum);
	}

}
