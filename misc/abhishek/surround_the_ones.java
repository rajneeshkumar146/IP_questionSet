package may31;

import java.util.Scanner;

public class SurroundTheOnes {

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
			
			int res = 0;
			
			for(int i=0; i < n ; i++){
				for(int j=0; j < m; j++){
					int ones = 0;
					
					if(arr[i][j] == 1){
						
						//Up
						if(i > 0 && arr[i-1][j] == 0){
							ones++;
						}
						
						//Down
						if(i < arr.length - 1 && arr[i+1][j] == 0){
							ones++;
						}
						
						//Left
						if(j > 0 && arr[i][j - 1] == 0){
							ones++;
						}
						
						//Right
						if(j < arr[0].length - 1 && arr[i][j + 1] == 0){
							ones++;
						}
						
						//Top-Left
						if(i > 0  && j > 0 && arr[i-1][j-1] == 0){
							ones++;
						}
						
						//Top-Right
						if(i > 0 && j < arr[0].length - 1 && arr[i-1][j+1] == 0){
							ones++;
						}
						
						//Bottom-Left
						if(i < arr.length - 1 && j > 0 && arr[i + 1][j-1] == 0){
							ones++;
						}
						
						//Bottom-Right
						if(i < arr.length - 1 && j < arr[0].length - 1 && arr[i + 1][j + 1] == 0){
							ones++;
						}
					}
					
					if(ones % 2 == 0 && arr[i][j] == 1 && ones > 0){
						res++;
					}
				}
			}
			
			System.out.println(res);
			
		}
	}

}
