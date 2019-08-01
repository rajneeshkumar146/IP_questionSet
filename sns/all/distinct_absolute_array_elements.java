package pep_sns;

import java.util.HashSet;

public class distinct_absolute_array_elements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-44, -31, -6, 6, 46, 52, 52, 55, 93};
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<arr.length; i++) {
			if(arr[i] < 0) {
				if(!set.contains(-arr[i]))
					set.add(-arr[i]);
			}else {
				if(!set.contains(arr[i]))
					set.add(arr[i]);
			}
		}
		System.out.println(set.size());
	}
}
