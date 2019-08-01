package recursion;

public class TowerOfHanoi {

	public static void main(String[] args) {

		toh("A", "C", "B", 3);
	}

	public static void toh(String src, String des, String aux, int n) {

		if (n == 0) {
			return;
		}

		toh(src, aux, des, n - 1);
		System.out.println("Move disk number " + n + " from " + src + " to " + des);
		toh(aux, des, src, n - 1);

	}
}
