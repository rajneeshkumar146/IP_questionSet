package misc;

import java.util.Arrays;

public class queue_reconstruction_by_height {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr= {{2,4},{3,4},{9,0},{0,6},{7,1},{6,0},{7,3},{2,5},{1,1}};
		int[][] res=reconstructQueue(arr);
		for(int i=0;i<res.length;i++) {
			System.out.print("["+res[i][0]+" "+res[i][1]+"]" );
		}
		System.out.println();
	}

	public static int[][] reconstructQueue(int[][] people) {
		pair[] arr = new pair[people.length];
		int[][] res = new int[people.length][2];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = new pair(people[i][0], people[i][1]);
			res[i][0] = res[i][1] = -1;
		}

		// Arrays.fill(res,-1);
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			int pos = 0;
			while (count <= arr[i].k && pos < arr.length) {
				if (res[pos][0] == -1) {
					count++;
				}
				pos++;
			}
			res[pos - 1][0] = arr[i].h;
			res[pos - 1][1] = arr[i].k;
		}
		return res;
	}

	public static class pair implements Comparable<pair> {
		int h;
		int k;

		pair(int h, int k) {
			this.h = h;
			this.k = k;
		}

		public int compareTo(pair o) {
			if (this.h == o.h) {
				return o.k - this.k;
			} else {
				return this.h - o.h;
			}
		}
	}

}
