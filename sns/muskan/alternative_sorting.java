package pep_sns;

import java.util.Arrays;

public class alternative_sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 6, 9, 4, 3, 7, 8, 2};//{ 7, 1, 2, 3, 4, 5, 6 };
		int[] alt_sorted = altsort(arr);
		for(int val: alt_sorted) {
			System.out.print(val + " ");
		}
	}

	public static int[] altsort(int[] arr) {
		Arrays.sort(arr);
		int[] newarr = new int[arr.length];
		int i = 0;
		int left = 0;
		int right = arr.length - 1;
		while(left < right) {
			newarr[i + 1] = arr[left];
			newarr[i] = arr[right];
			left++;
			right--;
			i += 2;
		}
		if(left == right)
			newarr[i] = arr[left];
		return newarr;
	}

}
