package dell.eclipse;

import java.util.Scanner;

public class SherlockAndTheGrid {

	public static void main(String[] args) {
		int size, i, j, n = 0, k, h, flag, noOfOutcome = 0;
		String a[][];

		System.out.println("Enter the size of the square matrix : ");
		Scanner scanner = new Scanner(System.in);
		size = scanner.nextInt();

		a = new String[size][size];

		for (i = 0; i < size; i++) {
			for (j = 0; j < size;) {
				System.out.println("Enter either '.' or '#'");
				a[i][j] = scanner.next();
				if ((a[i][j].equals("#")) || (a[i][j].equals("."))) {
					j++;
				}
				else
				{
					System.out.println("Please enter a valid input!!!");
				}
			}
		}
		scanner.close();

		for (i = 0; i < size; i++) {
			for (j = 0; j < size; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		j = n;
		do {
			i = size - 1;
			
			while (i >= 0) {
				if (!a[size - 1][j].equals("#")) {
					flag = 1;
					h = i;
					for (i = size - 1; i >= h; i--) {
						if (a[i][j].equals("#")) {
							flag = 0;
							break;
						}
					}
					if (flag == 0)
						break;
					i = h;
					if (!a[i][j].equals("#")) {
						k = j;
						h = i;
						for (; j < size; j++) {
							if (a[i][j].equals("#")) {
								flag = 0;
								break;
							}
						}
						j = k;
						i = h;
						if (flag == 1) {
							noOfOutcome++;
						}
					}
				} else {
					i--;
					break;
				}
				i--;
			}
			j=++n;
		} while (j < size);
		
		System.out.println("No of outcomes possible for Sherlock in the Grid = "+noOfOutcome);
	}

}
