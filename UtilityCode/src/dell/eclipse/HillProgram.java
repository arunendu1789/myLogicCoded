/**
 * 
 */
package dell.eclipse;

import java.util.Scanner;

/**
 * @author ArunenduRavi
 *
 */
public class HillProgram {
	
	public boolean hasAnyHillNumber(int a[][], int i, int j, int size)
	{
		
		int k,l,hillNo,f=1;
		hillNo = a[i][j];
		
		mainLoop:
		for(k=(i-1);k<=(i+1);k++)
		{
			if((k<0)||(k==size))
				continue;
			for(l=(j-1);l<=(j+1);l++)
			{
				if((l<0)||(l==size)||(l==j&&k==i))
					continue;
				if(hillNo<a[k][l])
				{
					f=0;
					break mainLoop;
				}
				else if(hillNo==a[k][l])
				{
					f=0;
					break mainLoop;
				}
			}	
		}
		if(f == 1)
		{
			return true;
		}
		return false;
	}

	public int averageOfSurroundingNumbers(int[][] a, int i, int j, int size) 
	{
		int k,l,sum=0,count=0;
		
		for(k=(i-1);k<=(i+1);k++)
		{
			if((k<0)||(k==size))
				continue;
			for(l=(j-1);l<=(j+1);l++)
			{
				if((l<0)||(l==size)||((k==i)&&(l==j)))
					continue;
				sum+=a[k][l];
				count++;
			}
		}
		System.out.println("\n"+sum/count);
		return sum/count;
	}
	
	public void displayMatrix(int[][] a, int size)
	{
		System.out.println("\n\n\n Matrix as of now: ");
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
	
	public boolean hasAnyHillNumberInTheArray(int[][] a, int size)
	{
		
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				if(hasAnyHillNumber(a, i, j, size))
				{
					System.out.println(a[i][j]);
					return true;
				}
			}	
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[][] = new int[3][3], i,j, size=3;
		
		HillProgram obj = new HillProgram();
		Scanner scanner = new Scanner(System.in);
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				System.out.println("Enter a no: ");
				a[i][j] = scanner.nextInt();
			}
		}
		scanner.close();
		
		System.out.println("\n\n\n Entered Matrix is :");
		obj.displayMatrix(a, size);
		
		while(obj.hasAnyHillNumberInTheArray(a, size))
		{
			for(i=0;i<3;i++)
			{
				for(j=0;j<3;j++)
				{
					if(obj.hasAnyHillNumber(a, i, j, size))
					{
						System.out.println("\n\n\n Hill Number is: "+a[i][j]);
						
						a[i][j] = obj.averageOfSurroundingNumbers(a, i, j, size);
						
						System.out.println("\n\n\n Matrix after first process: ");
						obj.displayMatrix(a, size);
					}	
				}
			}
		}
		obj.displayMatrix(a, size);
	}

}
