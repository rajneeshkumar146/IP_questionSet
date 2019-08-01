package hnh;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class equivalentsubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int test=scn.nextInt();
		for(int t=1;t<=test;t++){
			int n=scn.nextInt();
			int []arr=new int[n];
			for(int  i=0;i<n;i++){
				arr[i]=scn.nextInt();
			}
System.out.println(val(arr));
		}
	}

	public static int val(int[] arr) {
		int ans = 0;
		int right = 0;
		int totalk = 0;
		int n = arr.length;
		HashSet<Integer> vs = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			vs.add(arr[i]);
		}
		int k=vs.size();
		vs.clear();
		HashMap<Integer, Integer> ele = new HashMap<>();
		
		for (int i = 0; i < arr.length; i++) {
			while (right < arr.length && totalk < k) {
				if (ele.containsKey(arr[right])) {
					
					ele.put(arr[right], ele.get(arr[right]) + 1);
					
				} else {
					ele.put(arr[right], 1);
					totalk++;
				}
				right++;
			}
			if (totalk == k) {
				ans += n - right + 1;
			}
			ele.put(arr[i], ele.get(arr[i]) - 1);
			if (ele.get(arr[i]) == 0) {
				ele.remove(arr[i]);
				totalk--;
			}

		}
return ans;
	}
}
