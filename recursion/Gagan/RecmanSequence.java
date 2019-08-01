package recursion;
import java.util.*;

class Recman {
	static List<Integer> list = new ArrayList<>();

	public static void main(String args[]) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		RSequence(n - 1);

		for (int i : list)
			System.out.print(i + " ");

		System.out.println();
		list.clear();
	}

	public static void RSequence(int n) {
		if (n == 0) {
			list.add(0);
			return;
		}

		RSequence(n - 1);
		if ((list.get(n - 1) - n) > 0 && !list.contains(list.get(n - 1) - n)) {
			list.add(list.get(n - 1) - n);
		} else
			list.add(list.get(n - 1) + n);
	}
}