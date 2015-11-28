package dell.eclipse;

import java.util.Scanner;

public class Divisiblity {
	private int number;
	
	public Divisiblity(String n){
		this.number = Integer.parseInt(n, 2); 
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public int remainderWhenDivisibleByThree(int number){
		return number%3;
	}
	
	public static void main(String[] args) {
		String number;
		int DecNum;
		Scanner scanner = new Scanner(System.in);
		boolean isInputValid = true;
		do{
			System.out.println("Enter a number in Binary : ");
			number = scanner.next();
			
			if(number.isEmpty()){
				isInputValid = false;
			}
			else{
				char[] seqOfChar = number.toCharArray();
				int i=0,length = number.length();
				
				while(i<=length){
					if(seqOfChar[i]!='0' || seqOfChar[i]!='1'){
						isInputValid = false;
						break;
					}
				}
			}
		}while(!isInputValid);
		scanner.close();
		
		Divisiblity divisiblity = new Divisiblity(number);
		DecNum = divisiblity.getNumber();
		
		
	}
	
}
