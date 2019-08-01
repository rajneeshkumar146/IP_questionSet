package SnS;

import java.util.ArrayList;
import java.util.Arrays;

public class three_way_partitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> al=new ArrayList<>(Arrays.asList(4,2,3,1,4));
		System.out.println(threeWayPartition(al,2, 3));
 
	}

	public static void swap(ArrayList<Integer> A, int i, int j) {
		int t1 = A.get(i);
		int t2 = A.get(j);
		A.set(j, t1);
		A.set(i, t2);

	}

	public static ArrayList<Integer> threeWayPartition(ArrayList<Integer> A, int a, int b) {
		int fhalf, thalf;
		fhalf = 0;
		thalf = A.size() - 1;
		int i = 0;
		while (i <= thalf) {

			if (A.get(i) < a) {
				swap(A, i, fhalf);
				fhalf++;
				i++;
			} else if (A.get(i) > b) {
				swap(A, i, thalf);
				thalf--;
			} else {
				i++;
			}
		}
		ArrayList<Integer> res = new ArrayList<>();
		for (i = 0; i < A.size(); i++) {
			res.add(A.get(i));
		}
		return res;

	}
}
