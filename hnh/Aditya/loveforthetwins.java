package hnh;

import java.util.HashMap;
import java.util.Scanner;

public class loveforthetwins {

	public static void main(String[] args) {
Scanner scn=new Scanner(System.in);
int test=scn.nextInt();
for(int t=1;t<=test;t++){
	int n=scn.nextInt();
	int []arr=new int[n];
	for(int i=0;i<n;i++){
		arr[i]=scn.nextInt();
	}
	System.out.println(mt(arr));
}
	}

	public static int mt(int[] arr) {
		HashMap<Integer, Integer> vs = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int val = arr[i];
			if (vs.containsKey(val)) {
				vs.put(val, vs.get(val) + 1);
			} else {

				vs.put(val, 1);
			}
		}
		int res=0;
		for(int val:vs.keySet()){
			res+=(vs.get(val)/2)*2;
		}
		return res;
	}
}
