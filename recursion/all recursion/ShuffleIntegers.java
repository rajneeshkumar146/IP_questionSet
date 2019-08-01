package recursion;
import java.util.Arrays;

public class ShuffleIntegers {

	public static void main(String[] args) {

		int a[] = { 1, 3, 5, 7, 2, 4, 6, 8 };

		shufleArray(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));

	}

	public static void shufleArray(int a[], int f, int l) {
		if (l - f == 1)
			return;

		int mid = (f + l) / 2;

		int temp = mid + 1;

		int mmid = (f + mid) / 2;

		for (int i = mmid + 1; i <= mid; i++) {
			int temp1 = a[i];
			a[i] = a[temp];
			a[temp++] = temp1;
		}

		shufleArray(a, f, mid);
		shufleArray(a, mid + 1, l);
	}
}
