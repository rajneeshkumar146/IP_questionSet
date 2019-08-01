package SnS;
import java.util.ArrayList;

public class pancake_sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {3,2,4,1};
		//no. of flips
		ArrayList<Integer> al=pancakeSort(arr);
		System.out.println(al);
	}

	public static ArrayList<Integer> pancakeSort(int[] A) {
		ArrayList<Integer> list = new ArrayList<>();
		int num = A.length;
		while (num > 1) {
			int idx = findIdx(A, num);

			if (idx == num - 1) {
				num--;
				continue;
			}

			flip(A, idx);
			list.add(idx + 1);

			flip(A, num - 1);
			list.add(num);

			num--;
		}

		return list;

	}

	public static int findIdx(int[] arr, int end) {
		int idx = 0;
		for (int i = 1; i < end; i++) {
			if (arr[i] > arr[idx]) {
				idx = i;
			}
		}
		return idx;
	}

	public static void flip(int[] arr, int end) {
		int i = 0;
		while (i < end) {
			int temp = arr[i];
			arr[i] = arr[end];
			arr[end] = temp;

			i++;
			end--;
		}
	}

}
