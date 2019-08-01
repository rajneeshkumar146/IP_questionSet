package InternshipQuestionAs1;

public class Valid_Mountain_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean validMountainArray(int[] a) {

		int n = a.length;
		if (n <= 2)
			return false;
		
		int i = 0;

		while (i + 1 < n && a[i] < a[i + 1])
			i++;

		if (i == 0 || i == n - 1) // start point hi h y last m pahoonch gya h to sirf inc y dec hoga
			return false;

		while (i + 1 < n && a[i] > a[i + 1])
			i++;

		if (i == n - 1) // last chla gya without any interrupt to shi h
			return true;

		return false;

	}
}
