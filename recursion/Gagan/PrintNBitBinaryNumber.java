package recursion;
import java.util.Scanner;

public class PrintNBitBinaryNumber {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		print(n);
	}

	public static void print(int n) {

		print(n, "", 0);
	}

	public static void print(int n, String asf, int countOfOne) {

		if (asf.length() == n) {
			System.out.println(asf);
			return;

		}
		print(n, asf + 1, countOfOne + 1);
		if (countOfOne > 0) {
			print(n, asf + 0, countOfOne - 1);
		}

	}
}
