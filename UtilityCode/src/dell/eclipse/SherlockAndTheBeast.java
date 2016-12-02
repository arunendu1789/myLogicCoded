package dell.eclipse;

import java.util.Scanner;

public class SherlockAndTheBeast {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(),k,q3=0,q5=0;
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            q3=0;q5=0;
            System.out.println("1 :" +System.currentTimeMillis());
            if(n%3==0)
            {
                q3=n;
                q5=0;
            }
            else
            {
                k=n;
                System.out.println("2 :" +System.currentTimeMillis());
                while(k>5)
                {
                    if((k-5)%3==0)
                    {
                        q3=k-5;
                        q5=n-q3;
                        break;
                    }
                    k=k-5;
                }
                System.out.println("3 :" +System.currentTimeMillis());
                if(q3==0&&q5==0)
                {
                    if(n%5==0)
                    {
                        q3=0;
                        q5=n;
                    }
                }
                System.out.println("4 :" +System.currentTimeMillis());
            }
            if(q3==0&&q5==0)
            {
               System.out.println(-1); 
            }
            else
            {
            	System.out.println("5 :" +System.currentTimeMillis());
                for(int j=1;j<=q3;j++)
                {
                    System.out.print(5); 
                }
                for(int j=1;j<=q5;j++)
                {
                     System.out.print(3); 
                }
                
                System.out.println(); 
                System.out.println("6 :" +System.currentTimeMillis());
            }
        }
        
    }
}
