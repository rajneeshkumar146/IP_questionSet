package hnh;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class countofdistele {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int test=scn.nextInt();
		for(int t=1;t<=test;t++){
			int n=scn.nextInt();
			int [][]arr=new int[n][n];
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					arr[i][j]=scn.nextInt();
				}
			}
		countdistinct(arr);
		}
	}

	public static void countdistinct(int[][] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			HashSet<Integer> st = new HashSet<>();
			for (int j = 0; j < arr[0].length; j++) {
				if (!st.contains(arr[i][j])) {
					st.add(arr[i][j]);
					if (map.containsKey(arr[i][j])) {
						map.put(arr[i][j], map.get(arr[i][j]) + 1);
					} else {
						map.put(arr[i][j], 1);
					}
				}
			}
		}
		for(int i:map.keySet()){
			if(map.get(i)==arr.length){
				System.out.println(i+" ");
			}
		}
	}
}
