package dell.eclipse;

import java.util.Scanner;

public class PaintTheTiles {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String C = in.next();
        in.close();
        int noOfStrokes=0,noOfRed,noOfBlue,j=0,flag=1;
        
        while(j<N)
        {
        	noOfRed=0;
        	noOfBlue=0;
            if(C.charAt(j)=='R')
            {
                for(;j<N;j++)
                {
                    if(C.charAt(j)=='R')
                    {
                        noOfRed++;
                    }
                    else
                    	break;
                }
                if(j>=N)
                {
                    flag=0;
                }
            }
            if(noOfRed>0)
                noOfStrokes++;
            if(flag==0)
                break;
            
            if(C.charAt(j)=='B')
            {
                for(;j<N;j++)
                {
                    if(C.charAt(j)=='B')
                    {
                        noOfBlue++;
                    }
                    else
                    	break;
                }
                if(j>=N)
                {
                    flag=0;
                }
            }
            if(noOfBlue>0)
                noOfStrokes++;
        }
        System.out.println(noOfStrokes);
    }
}
