package may31;

import java.util.HashSet;

public class line_reflection {

	public boolean isReflected(int[][] points) {

		int maxX = Integer.MIN_VALUE;
		int minX = Integer.MAX_VALUE;

		HashSet<String> pts = new HashSet<>();

		for (int i = 0; i < points.length; i++) {
			maxX = Integer.max(maxX, points[i][0]);
			minX = Integer.min(minX, points[i][0]);

			String pt = points[i][0] + "," + points[i][1];
			pts.add(pt);
		}

		int lineX = (maxX + minX) / 2;
		int sum = maxX + minX;

		for (int i = 0; i < points.length; i++) {

			String pt_mirror = (sum - points[i][0]) + "," + points[i][1];   //for any two pts mirror of each other the sum
			if (!pts.contains(pt_mirror)) {									//of x of both must be equal to the sum of min and max 
				return false;
			}
		}

		return true;

	}

	// public boolean isReflected(int[][] points) {
	// int max = Integer.MIN_VALUE;
	// int min = Integer.MAX_VALUE;
	// HashSet<String> set = new HashSet<>();
	// for(int[] p:points){
	// max = Math.max(max,p[0]);
	// min = Math.min(min,p[0]);
	// String str = p[0] + "a" + p[1];
	// set.add(str);
	// }
	// int sum = max+min;
	// for(int[] p:points){
	// //int[] arr = {sum-p[0],p[1]};
	// String str = (sum-p[0]) + "a" + p[1];
	// if( !set.contains(str))
	// return false;
	//
	// }
	// return true;
	// }
}
