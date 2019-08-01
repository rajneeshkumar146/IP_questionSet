package SnS;

import java.util.ArrayList;
import java.util.Arrays;

public class Triplet_Family {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {8 ,10 ,16, 6, 15, 25};
		System.out.println(findTriplet(arr));
	}
	 public static ArrayList<Integer> findTriplet(int arr[])
	    {
	        ArrayList<Integer> res=new ArrayList<>();
	        Arrays.sort(arr);
			int curSum = 0;
			int left, right;

			for (int i = arr.length-1;i>=2; i--) {

				left = 0;
				right = i-1;

				while (left < right) {
					curSum = arr[left] + arr[right];
					if (curSum == arr[i]) {
						res.add(arr[left]);
						res.add(arr[right]);
						res.add(arr[i]);
						return res;
					} else if (curSum < arr[i]) {
						left++;
					} else {
						right--;
					}
				}
			}
			return res;

		}

}
