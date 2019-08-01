package pep_sns;

public class missing_number_in_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 10;
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 10 };
		int xorarr = 0;
		int xorn = 0;
		for (int i = 0; i < n - 1; i++) {
			xorarr ^= arr[i];
		}
		for (int i = 1; i <= n; i++) {
			xorn ^= i;
		}
		System.out.println(xorn ^ xorarr);
	}

}
