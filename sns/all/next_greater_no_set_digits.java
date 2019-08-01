package pep_sns;

public class next_greater_no_set_digits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//134 -> 314
		int n = 17422;
		int length = String.valueOf(n).length();
		int[] arr = new int[length];
		int x = n;
		int indx = length - 1;
		while (x != 0) {
			arr[indx] = x % 10;
			x = x / 10;
			indx--;
		}
		int leftsmallest = 0;
		int i;
		for (i = length - 1; i > 0; i--) {
			if (arr[i - 1] < arr[i]) {
				leftsmallest = i - 1;
				break;
			}
		}
		if (i == 0) {
			System.out.println("not possible");
			return;
		}
		int nextgreatest = Integer.MAX_VALUE;
		int ngi = 0;
		for (int j = leftsmallest; j < length - 1; j++) {
			if (arr[j + 1] > arr[leftsmallest] && arr[j + 1] <= nextgreatest) {
				ngi = j + 1;
				nextgreatest = arr[j + 1];
			}
		}
		int temp = arr[leftsmallest];
		arr[leftsmallest] = nextgreatest;
		arr[ngi] = temp;
		i = length - 1;
		for (int j = leftsmallest + 1; j <= i; j++, i--) {
			int temp1 = arr[j];
			arr[j] = arr[i];
			arr[i] = temp1;
		}
		for (int val : arr) {
			System.out.print(val);
		}
		System.out.println();

	}

}
