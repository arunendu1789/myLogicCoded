package dell.eclipse;

import java.util.HashSet;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num={1412,1213};
		//int num2=1213;
		HashSet hs= new HashSet();
		
		for(int j=2;j<3;j++){
			for(int i=0;i<num.length;i++){
				if(hs.add(num[i]%j)){
					System.out.println("num");
				}
				else{
					
					System.out.println("Duplicate");
					break;
				}
			}
			
		}
			
		

	}

}
