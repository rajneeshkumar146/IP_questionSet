package hnh;

import java.util.HashMap;
import java.util.Scanner;

public class pairofnoncoincidentpoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 1; t <= test; t++) {
			int n = scn.nextInt();
			pair []arr=new pair[n];
			for (int i = 0; i < n; i++) {
				arr[i]=new pair();
				arr[i].x = scn.nextInt();
				arr[i].y=scn.nextInt();
			}
			System.out.println(val(arr));
		}
	}

	public static int val(pair[] arr) {
		HashMap<Integer, Integer> xs = new HashMap<>();
		HashMap<pair, Integer> xys = new HashMap<>();
		HashMap<Integer, Integer> ys = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int x = arr[i].x;
			int y = arr[i].y;
			if (xs.containsKey(x)) {
				xs.put(arr[i].x, xs.get(arr[i].x) + 1);
			} else {
				xs.put(arr[i].x, 1);
			}

			if (ys.containsKey(y)) {
				ys.put(arr[i].y, ys.get(arr[i].y) + 1);
			} else {
				ys.put(arr[i].y, 1);
			}
			if (xys.containsKey(arr[i])) {
				xys.put(arr[i], xys.get(arr[i]) + 1);
			}else{
				xys.put(arr[i], 1);
			}

		}
		int xans = 0;
		int yans = 0;
		int xyans = 0;
		for (int x : xs.keySet()) {
			int va = xs.get(x);
			xans += (va * (va - 1)) / 2;
		}
		for (int y : ys.keySet()) {
			int va = ys.get(y);

			yans += (va * (va - 1)) / 2;

		}
		for (pair xy : xys.keySet()) {
			int val = xys.get(xy);
			xyans += (val * (val - 1)) / 2;
		}
		return xans + yans - xyans;
	}

	public static class pair {
		int x;
		int y;

		public final int hashCode() {
		    final int temp=14;
			return x*14 + y;
		}

		public boolean equals(Object p) {
		    if(this==p){
		        return true;
		    }
		    if(p==null){
		        return false;
		    }
		    if(this.getClass()!=p.getClass()){
				return false;
			}
			pair pt=(pair)p;
			if (this.x != pt.x) {
				return false;
			} else if (this.y != pt.y) {
				return false;
			}
			return true;
		}
	}
}
