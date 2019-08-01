package pep_sns;

public class binary_array_sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 0, 1, 0, 0, 1 };
		f012(arr);
		for(int val: arr) {
			System.out.print(val + " ");
		}
	}

	public static void f012(int[] arr) {
		int i = 0;
		int pidx = 0;
		while(i < arr.length) {
			if(arr[i] == 1) {
				i++;
			}else {
				int temp = arr[i];
				arr[i] = arr[pidx];
				arr[pidx] = temp;
				i++;
				pidx++;
			}
		}
	}
	
}
