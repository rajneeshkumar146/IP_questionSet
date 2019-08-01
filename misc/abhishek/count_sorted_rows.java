package may31;

import java.util.Scanner;

public class CountSortedRows {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		while(T-- > 0){
			int m = s.nextInt();
			int n = s.nextInt();
			
			int[][] arr = new int[m][n];
			
			for(int i=0; i < m ; i++){
				for(int j=0; j < n; j++){
					arr[i][j] = s.nextInt();
				}
			}
			System.out.println(CountSorted(arr));
			
		}
	}
	
	public static int CountSorted(int[][] arr){
		int res = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			int inc = 1;

			for(int j = 0 ; j < arr[0].length - 1; j++){
				if(arr[i][j] >= arr[i][j + 1]){
					inc = 0;
					break;
				}
			}
			
			if(inc == 1){
				res++;
			}else{
				int dec = 1;
				for(int j = 0 ; j < arr[0].length - 1; j++){
					if(arr[i][j] <= arr[i][j + 1]){
						dec = 0;
						break;
					}
				}
				
				if(dec == 1){
					res++;
				}
			}
		}
		
		return res;
	}

}
