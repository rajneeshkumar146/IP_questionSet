package InternshipQuestionAs1;

public class Sort_Array_By_Parity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sortArrayByParity(new int[] { 3, 1, 2, 4 });
	}

	public static int[] sortArrayByParity(int[] a) {

		int i = 0;
		int j = 0;

		while (j != a.length) {

			if (a[j] % 2 != 0) {
				j++;
			} else {
				int t = a[j];
				a[j] = a[i];
				a[i] = t;
				i++;
				j++;
			}
		}
		for (int v : a) {
			System.out.print(v + " ");
		}
		return a;

	}
}
