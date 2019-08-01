package pep_sns;

import java.util.Arrays;
import java.util.HashMap;

public class convert_array_to_reduced_form {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0, -1, 10, 30, 40, 20};
		convert(arr);
		for(int val: arr)
			System.out.println(val);
	}

	private static void convert(int[] arr) {
		int[] temp = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			temp[i] = arr[i];
		}
		Arrays.sort(temp);
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<temp.length; i++) {
			map.put(temp[i], i);
		}
		for(int i=0; i<temp.length; i++) {
			arr[i] = map.get(arr[i]);
		}
	}

}
