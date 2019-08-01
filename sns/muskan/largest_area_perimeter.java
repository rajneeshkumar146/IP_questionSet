package pep_sns;

import java.util.Arrays;

public class largest_area_perimeter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2, 1, 2};
		System.out.println(largestPerimeter(A));
		int[] A1 = {3,2,3,4};
		System.out.println(largestPerimeter(A1));
	}
	public static int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for(int i=A.length - 3; i>=0; i--){
            if(A[i + 2] < A[i] + A[i + 1]){
                int perimeter = A[i] + A[i + 1] + A[i + 2];
                return perimeter;
            }
        }
        return 0;
    }

}
