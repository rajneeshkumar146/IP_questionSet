package InternshipQuestionAs1;

public class Rotate_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		rotate(a, 7);
		for (int v : a)
			System.out.print(v + " ");
	}

	public static void rotate(int[] a, int k) {

		if (k != 0 || k != a.length) {
			k %= a.length;
			reverse(a, 0, a.length - 1 - k);
			reverse(a, a.length - k, a.length - 1);
			reverse(a, 0, a.length - 1);
		}
	}

	public static void reverse(int[] a, int l, int r) {
		while (l < r) {
			int t = a[r];
			a[r] = a[l];
			a[l] = t;
			l++;
			r--;
		}
	}
}
