package InternshipQuestionAs1;

public class Merge_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		merge(new int[] { 1, 2, 3, 0, 0, 0, 0 }, 3, new int[] { 4, 5, 6, 8 }, 4);

	}

	public static void merge(int[] num1, int m, int[] num2, int n) {

		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;

		while (i >= 0 && j >= 0) {
			if (num1[i] >= num2[j]) {
				num1[k] = num1[i];
				i--;
				k--;
			} else {
				num1[k] = num2[j];
				j--;
				k--;
			}
		}
		while (j >= 0 && k >= 0) {
			num1[k] = num2[j];
			k--;
			j--;
		}
		for (int v : num1)
			System.out.print(v + " ");
	}
}
