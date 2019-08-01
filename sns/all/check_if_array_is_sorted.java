package pep_sns;

public class check_if_array_is_sorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 20, 30, 40, 50}; //{90, 80, 100, 70, 40, 30};
		boolean flag = false;
		for (int i = arr.length - 1; i >= 1; i--) {
			if (arr[i] < arr[i - 1]) {
				flag = true;
				break;
			}
		}
		System.out.println(flag == false ? "1" : "0");
	}

}
