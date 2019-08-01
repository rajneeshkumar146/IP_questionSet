package may31;

import java.util.Scanner;

public class rotateMatrixElements {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		while(T-- > 0){
			int m = s.nextInt();
			int n = s.nextInt();
			
			int[][] arr = new int[m][n];
			
			// Input matrix elements
			for(int i=0; i < m ; i++){
				for(int j=0; j < n; j++){
					arr[i][j] = s.nextInt();
				}
			}
			
			
			
			int rmin = 0;
			int rmax = arr.length - 1;
			int cmin = 0;
			int cmax = arr[0].length - 1;
			
			while(cmin < cmax && rmin < rmax){
				
				int prev = arr[rmin + 1][cmin];
				
				for(int j = cmin; j <= cmax; j++){
					int curr = arr[rmin][j];
					arr[rmin][j] = prev;
					prev = curr;
				}
				rmin++;
				
				for(int i = rmin; i <= rmax; i++){
					int curr = arr[i][cmax];
					arr[i][cmax] = prev;
					prev = curr;
				}
				cmax--;
				
				for(int j = cmax; j >= cmin; j--){
					int curr = arr[rmax][j];
					arr[rmax][j] = prev;
					prev = curr;
				}
				rmax--;
				
				for(int i = rmax; i >= rmin; i--){
					int curr = arr[i][cmin];
					arr[i][cmin] = prev;
					prev = curr;
				}
				cmin++;
	
			}
			
			for(int i=0; i < m ; i++){
				for(int j=0; j < n; j++){
					System.out.print(arr[i][j] + " ");
				}
			}
			System.out.println();
			
			
		}
	}

}
