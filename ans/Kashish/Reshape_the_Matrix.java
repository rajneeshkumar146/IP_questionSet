package InternQuestAS1;

import java.util.ArrayList;
import java.util.Scanner;



public class Reshape_the_Matrix {
public static int[][] matrixReshape(int[][] nums, int r, int c) {
	if(r*c!=nums.length*nums[0].length){
		return nums;
	}
	ArrayList<Integer> ar=new ArrayList<>();
	int [][] ans=new int[r][c];
	
	for(int i=0;i<nums.length;i++){
		for(int j=0;j<nums[0].length;j++){
			ar.add(nums[i][j]);
		}
	}
	
	for(int i=0;i<r;i++){
		for(int j=0;j<c;j++){
			ans[i][j]=ar.get(0);
			ar.remove(0);
		}
	}
	return ans;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
	int[][]	nums = 
				{{1,2},
				 {3,4}};
				int r = 1;
				int c = 4;
				
		

	}

}
