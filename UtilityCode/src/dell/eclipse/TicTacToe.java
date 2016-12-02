package dell.eclipse;

import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {
		int size, i, j, horXposs[]={0,0}, verXposs[]={0,0}, diagXposs[]={0,0}, horOposs[]={0,0}, verOposs[]={0,0}, diagOposs[]={0,0};
		char a[][], input;
		String requiredIndexesForX="",requiredIndexesForO="";
		boolean winPossible=true;
		
		System.out.println("Enter the size of tic tac toe!!!");
		Scanner scanner = new Scanner(System.in);
		size = scanner.nextInt();
		
		a = new char[size][size];
		
		for(i=0;i<size;i++)
		{
			for(j=0;j<size;j++)
			{
				System.out.println("Enter either 'X','x','O','o','.'");
				a[i][j]=scanner.next().charAt(0);
				if(!((a[i][j]=='X')||(a[i][j]=='x')||(a[i][j]=='O')||(a[i][j]=='o')||(a[i][j]=='.')))
				{
					System.out.println("Enter a valid input!!!");
					j--;
				}
			}
		}
		
		do{
			System.out.println("What you want to input X or O?");
			input = scanner.next().charAt(0);
			if(!((input=='X')||(input=='x')||(input=='O')||(input=='o')))
			{
				System.out.println("Enter a valid input!!!");
			}
			
		}while(!((input=='X')||(input=='x')||(input=='O')||(input=='o')));
		
		
		scanner.close();
		for(i=0;i<size;i++)
		{
			for(j=0;j<size;j++)
			{
				System.out.print(a[i][j]+"  ");
			}
			System.out.println();
		}
		
		System.out.println("You have only one chance... I will tell you whether you will win or not!!!");
		
		for(i=0;i<size-1;i++)
		{
			if(horXposs[0]>=0)
			{
				if((a[0][i]=='X')||(a[0][i]=='x')||(a[0][i]=='.'))
				{
					if((a[0][i+1]=='.')||(a[0][i]=='.'))
					{
						horXposs[0]++;
					}
					else if((a[0][i+1]=='O')||(a[0][i+1]=='o'))
					{
						horXposs[0]=-1;
					}
				}
			}
			if(horXposs[1]>=0)
			{
				if((a[size-1][i]=='X')||(a[size-1][i]=='x')||(a[size-1][i]=='.'))
				{
					if((a[size-1][i+1]=='.')||(a[size-1][i]=='.'))
					{
						horXposs[1]++;
					}
					else if((a[size-1][i+1]=='O')||(a[size-1][i+1]=='o'))
					{
						horXposs[1]=-1;
					}
				}
			}
			if(verXposs[0]>=0)
			{
				if((a[0][i]=='X')||(a[0][i]=='x')||(a[0][i]=='.'))
				{
					if((a[0][i+1]=='.')||(a[0][i]=='.'))
					{
						verXposs[0]++;
					}
					else if((a[0][i+1]=='O')||(a[0][i+1]=='o'))
					{
						verXposs[0]=-1;
					}
				}
			}
			if(verXposs[1]>=0)
			{
				if((a[size-1][i]=='X')||(a[size-1][i]=='x')||(a[size-1][i]=='.'))
				{
					if((a[size-1][i+1]=='.')||(a[size-1][i]=='.'))
					{
						verXposs[1]++;
					}
					else if((a[size-1][i+1]=='O')||(a[size-1][i+1]=='o'))
					{
						verXposs[1]=-1;
					}
				}
			}
			if(horOposs[0]>=0)
			{
				if((a[0][i]=='O')||(a[0][i]=='o')||(a[0][i]=='.'))
				{
					if((a[0][i+1]=='.')||(a[0][i]=='.'))
					{
						horOposs[0]++;
					}
					else if((a[0][i+1]=='X')||(a[0][i+1]=='x'))
					{
						horOposs[0]=-1;
					}
				}
			}
			if(horOposs[1]>=0)
			{
				if((a[size-1][i]=='O')||(a[size-1][i]=='o')||(a[size-1][i]=='.'))
				{
					if((a[size-1][i+1]=='.')||(a[size-1][i]=='.'))
					{
						horOposs[1]++;
					}
					else if((a[size-1][i+1]=='X')||(a[size-1][i+1]=='x'))
					{
						horOposs[1]=-1;
					}
				}
			}
			if(verOposs[0]>=0)
			{
				if((a[0][i]=='O')||(a[0][i]=='o')||(a[0][i]=='.'))
				{
					if((a[0][i+1]=='.')||(a[0][i]=='.'))
					{
						verOposs[0]++;
					}
					else if((a[0][i+1]=='X')||(a[0][i+1]=='x'))
					{
						verOposs[0]=-1;
					}
				}
			}
			if(verOposs[1]>=0)
			{
				if((a[size-1][i]=='O')||(a[size-1][i]=='o')||(a[size-1][i]=='.'))
				{
					if((a[size-1][i+1]=='.')||(a[size-1][i]=='.'))
					{
						verOposs[1]++;
					}
					else if((a[size-1][i+1]=='X')||(a[size-1][i+1]=='x'))
					{
						verOposs[1]=-1;
					}
				}
			}
			if(diagOposs[0]>=0)
			{
				if((a[i][i]=='O')||(a[i][i]=='o')||(a[i][i]=='.'))
				{
					if((a[i+1][i+1]=='.')||(a[i][i]=='.'))
					{
						diagOposs[0]++;
					}
					else if((a[i+1][i+1]=='X')||(a[i+1][i+1]=='x'))
					{
						diagOposs[0]=-1;
					}
				}
			}
			if(diagOposs[1]>=0)
			{
				if((a[i][size-i-1]=='O')||(a[i][size-i-1]=='o')||(a[i][size-i-1]=='.'))
				{
					if((a[i+1][size-i-2]=='.')||(a[i][size-i-1]=='.'))
					{
						diagOposs[1]++;
					}
					else if((a[i+1][size-i-2]=='X')||(a[i+1][size-i-2]=='x'))
					{
						diagOposs[1]=-1;
					}
				}
			}
			if(diagXposs[0]>=0)
			{
				if((a[i][i]=='X')||(a[i][i]=='x')||(a[i][i]=='.'))
				{
					if((a[i+1][i+1]=='.')||(a[i][i]=='.'))
					{
						diagXposs[0]++;
					}
					else if((a[i+1][i+1]=='O')||(a[i+1][i+1]=='o'))
					{
						diagXposs[0]=-1;
					}
				}
			}
			if(diagXposs[1]>=0)
			{
				if((a[i][size-1-i]=='X')||(a[i][size-1-i]=='x')||(a[i][size-1-i]=='.'))
				{
					if((a[i+1][size-i-2]=='.')||(a[i][size-1-i]=='.'))
					{
						diagXposs[1]++;
					}
					else if((a[i+1][size-i-2]=='O')||(a[i+1][size-1-2]=='o'))
					{
						diagXposs[1]=-1;
					}
				}
			}
		}
		
		System.out.println(horXposs[0] +" "+ horXposs[1]+" "+diagXposs[0]+" "+diagXposs[1]+" "+horOposs[0] +" "+ horOposs[1]+" "+diagOposs[0]+" "+diagOposs[1]+" ");
		
		if((input=='X')||(input=='x'))
		{
			if(horXposs[0]==1 || horXposs[1]==1||diagXposs[0]==1||diagXposs[1]==1||verXposs[0]==1 || verXposs[1]==1)
			{
				System.out.println(winPossible);
			}
			else
			{
				System.out.println(!winPossible);
			}
		}
		else if((input=='O')||(input=='o'))
		{
			if(horOposs[0]==1 || horOposs[1]==1||diagOposs[0]==1||diagOposs[1]==1||verOposs[0]==1 || verOposs[1]==1)
			{
				System.out.println(winPossible);
			}
			else
			{
				System.out.println(!winPossible);
			}
		}
		
	}
}
