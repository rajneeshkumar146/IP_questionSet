package InternQuestDP;

import java.util.Scanner;

public class Unique_Paths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int m=scn.nextInt();
		int n=scn.nextInt();
		int paths=UniquePaths(m,n);
		System.out.println(paths);

	}

	private static int UniquePaths(int m, int n) {
		// TODO Auto-generated method stub
		int path[][]=new int[m][n];
		for(int j=path[0].length-1;j>=0;j--){
			path[m-1][j]=1;
			
		}
		for(int i=0;i<path.length;i++){
			path[i][n-1]=1;
		}
		for(int i=m-2;i>=0;i--){
			for(int j=n-2;j>=0;j--){
				path[i][j]=path[i+1][j]+path[i][j+1];
			}
		}
	
		return path[0][0];
	}

}
