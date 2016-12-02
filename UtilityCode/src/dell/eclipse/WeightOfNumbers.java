package dell.eclipse;

/*Statement

Let us denote an n digit decimal number by a1a2a3...an with the condition that each ai should be between 0 and 9 
inclusive except a1 which should be between 1 and 9 inclusive. 
The weight of such a number is defined as the sum of absolute difference between adjacent numbers. 
Precisely the weight can be defined as,

	weight = 0
	For i = 1 to n-1
  		weight = weight + ABS(ai+1 - ai)


Here ABS is the absolute value of the argument.
Given n and a weight w, find all the n digit numbers having a weight w. 
Since the answer could be very large, print the answer modulo 1000007.*/

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class WeightOfNumbers {

	public static void main(String[] args) throws InterruptedException {
		int t, n, w, count, wi, a[], j;
		String  max;
		BigInteger nBigInteger = null, k, num, rem, sub;
		System.out.println("enter the no of times you want to test the code!!!");
		Scanner scanner = new Scanner(System.in);
		t = scanner.nextInt();
		
		for(int i =1; i<=t; i++)
		{
			count = 0;
			System.out.println("Enter the no of digits!!!");
			n = scanner.nextInt();
			
			System.out.println("enter the weight!!!");
			w = scanner.nextInt();
			
			System.out.println(n + "\t" +w);
			
			a = new int[n];
			Arrays.fill(a, 0);
			a[0] = 1;
			j=0;
			max="";
			nBigInteger=new BigInteger("0");
			while(j<n)
			{
				nBigInteger=(nBigInteger.multiply(BigInteger.TEN)).add(new BigInteger(String.valueOf(a[j])));
				max=max+0;
				j++;
			}
			
			while(nBigInteger.compareTo(new BigInteger(String.valueOf(new BigInteger("1"+max))))<0)
			{
				k=nBigInteger;
				wi=0;
				while((k.divide(BigInteger.TEN)).compareTo(BigInteger.ZERO)>0)
				{
					num = k.divide(BigInteger.TEN);
					num = num.mod(BigInteger.TEN);
					rem = k.mod(BigInteger.TEN);
					sub = rem.subtract(num);

					wi=wi+Math.abs(sub.intValue());
					if(wi>w)
					{
						break;
					}
					k = k.divide(BigInteger.TEN);
				}
				if(wi==w)
				{
					count++;
				}
				//System.out.println(nBigInteger);
				nBigInteger = nBigInteger.add(BigInteger.ONE);
				
			}
				
			System.out.println(count);
		}

	}

}
