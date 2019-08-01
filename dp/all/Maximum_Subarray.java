package InternQuestionDP;

public class Maximum_Subarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2,-1, 2, 3, 4,  -5 };
		int a = arr[0];
		int b = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (a < 0) {
				a = arr[i];
			} else {
				a += arr[i];
			}
			if (a > b) {
				b = a;
			}
		}
		System.out.println(b);
	}
}
