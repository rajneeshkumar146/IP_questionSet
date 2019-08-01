package pep_sns;

public class common_elements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = { 1, 5, 10, 20, 40, 80 };
		int arr2[] = { 6, 7, 20, 80, 100 };
		int arr3[] = { 3, 4, 15, 20, 30, 70, 80, 120 };

		int p1 = 0, p2 = 0, p3 = 0;
		boolean flag = false;
		while (p1 < arr1.length && p2 < arr2.length && p3 < arr3.length) {
			if (arr1[p1] == arr2[p2] && arr2[p2] == arr3[p3]) {
				System.out.println(arr1[p1] + " ");
				p1++;
				p2++;
				p3++;
				flag = true;
			} else if (arr1[p1] < arr2[p2])
				p1++;
			else if (arr2[p2] < arr3[p3])
				p2++;
			else
				p3++;
		}
		if (flag == false)
			System.out.println(-1);
	}

}
