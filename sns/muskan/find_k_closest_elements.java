package pep_sns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class find_k_closest_elements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		int k=4, x=-1;
		int[] arrindx = findClosestElements(arr, k, x);
		for(int i=arrindx[0]; i<arrindx[1]; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	public static int[] findClosestElements(int[] arr1, int k, int x) {
		int n = arr1.length;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr.add(arr1[i]);
        }
        int[] indices = new int[2];
		if (x <= arr.get(0)) {
			indices[1] = k;
			return indices;
		} else if (arr.get(n - 1) <= x) {
			indices[0] = n-k;
			indices[1] = n;
			return indices;
		} else {
			int index = Collections.binarySearch(arr, x);
			if (index < 0)
				index = -index - 1; // insertion point in array
			int low = Math.max(0, index - k - 1);
            int high = Math.min(arr.size() - 1, index + k - 1);

			while (high - low > k - 1) {
				if (low < 0 || (x - arr.get(low)) <= (arr.get(high) - x))
					high--;
				else if (high > arr.size() - 1 || (x - arr.get(low)) > (arr.get(high) - x))
					low++;
			}
			indices[0] = low;
			indices[1] = high+1;
			return indices;
		}
    }
	

}
