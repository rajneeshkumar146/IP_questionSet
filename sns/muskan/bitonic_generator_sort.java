package pep_sns;

import java.util.Arrays;

public class bitonic_generator_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {88, 57, 44, 92, 28, 66, 60, 37, 33, 52, 38, 29, 76, 8, 75}; 
		bitonicgen(arr);
	}
	
	public static void bitonicgen(int[] arr) {
		int partition = arr.length/2; //o1
		int[] even; int[] odd;		
		//o 1
		if(arr.length%2 == 0) {
			even = new int[partition];
			odd = new int[partition];
		}else {
			even = new int[partition + 1];
			odd = new int[partition];
		}
		int j1 = 0, j2 = 0;
		//o n
		for(int i=0; i<arr.length; i++) {
			if(i%2 == 0) {
				even[j1] = arr[i];
				j1++;
			}else {
				odd[j2] = arr[i];
				j2++;
			}
		}
		//o nlogn + o nlogn
		Arrays.sort(even);
		for(int val: even)
			System.out.print(val + " ");
		Arrays.sort(odd);
		System.out.println();
		for(int val: odd)
			System.out.print(val + " ");
		int end = odd.length - 1;
		//o n
		for(int i=0; i<arr.length; i++) {
			if(i < even.length) {
				arr[i] = even[i];
			}else {
				arr[i] = odd[end];
				end--;
			}
		}
		for(int val: arr)
			System.out.print(val + " ");
	}

}
