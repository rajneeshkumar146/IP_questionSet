package recursion;
import java.util.Scanner;

public class RecursiveSequence {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();
		for (int i = 0; i < testCase; i++) {
			int n = s.nextInt();
			printNthTerm(n, 0, 0, 0);
		}

	}

	public static void printNthTerm(int n, long sumSoFar, int lastTermAdded, int count) {

		if (count == n) {
			System.out.println(sumSoFar);
			return;
		}

		long prod = 1;
		for (int i = lastTermAdded + 1; i <= lastTermAdded + count + 1; i++) {
			prod *= i;
		}

		printNthTerm(n, sumSoFar + prod, lastTermAdded + count + 1, count + 1);

	}
}
