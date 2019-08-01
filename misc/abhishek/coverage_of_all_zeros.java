package may31;

import java.util.Scanner;

public class CoverageOfAllZeros {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		while(T-- > 0){
			int n = s.nextInt();
			int m = s.nextInt();
			
			int[][] arr = new int[n][m];
			
			// Input matrix elements
			for(int i=0; i < n ; i++){
				for(int j=0; j < m; j++){
					arr[i][j] = s.nextInt();
				}
			}
			
			int count = 0;
			
			for(int i = 0; i < arr.length; i++){
				for(int j = 0; j < arr[0].length; j++){
					if(arr[i][j] == 0){
						
						//UP
						if(i > 0 && arr[i-1][j] == 1){
							count++;
						}
						
						//DOWN
						if(i < arr.length - 1 && arr[i+1][j] == 1){
							count++;
						}
						
						//LEFT
						
						if(j > 0 && arr[i][j-1] == 1){
							count++;
						}
						
						//RIGHT
						
						if(j < arr[0].length - 1 && arr[i][j + 1] == 1){
							count++;
						}
					}
				}
			}
			
			System.out.println(count);
			
		}
		
		
			
	}

}
