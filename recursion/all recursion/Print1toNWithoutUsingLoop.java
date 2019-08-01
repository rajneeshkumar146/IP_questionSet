package recursion;

public class Print1toNWithoutUsingLoop {

	public static void main(String[] args) {

		print1toN(10);
	}

	public static void print1toN(int n) {

		if (n == 0) {
			return;
		}

		print1toN(n - 1);
		System.out.print(n + " ");

	}
}
