package dell.eclipse;

import java.util.Scanner;

public class HighestPower {

	public static void main(String[] args) {
		long n, maxPow = 1, iPart;
		double b, fPart;

		System.out.println("Enter the no :");
		Scanner abc = new Scanner(System.in);
		n = abc.nextLong();
		abc.close();

		for (int i = 1; i <= n; i++) {
			b = Math.pow(n, 1 / i);
			iPart = (long) b;
			fPart = b - iPart;
			if (fPart == 0) {
				maxPow = i;
				System.out.println(b + "\t" + i + "\t" + fPart);
			}
		}
		System.out.println(maxPow);

	}

}
