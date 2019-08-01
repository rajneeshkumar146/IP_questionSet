package pep_sns;

import java.util.Arrays;
import java.util.HashSet;

public class count_possible_triangles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 6, 5, 7 , 8, 9};
		Arrays.sort(arr);
		int count  = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			int k = i + 2;
			for (int j = i + 1; j < arr.length; j++) {
				while(k < arr.length && arr[i] + arr[j] > arr[k])
					k++;
				if(k>j)
					count += k - j - 1;
			}
		}
		System.out.println(count);
	}

}
