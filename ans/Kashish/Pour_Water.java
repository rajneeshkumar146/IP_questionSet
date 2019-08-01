package InternQuestAS1;

import java.util.Scanner;

public class Pour_Water {
	public static int[] pourWater(int[] heights, int v, int k) {
		 for(int i = 0; i < v; i++) {
	            int cur =k ;//place where a drop of water is poured
	            // Move left
	            while(cur > 0 && heights[cur] >= heights[cur - 1]) {
	                cur--;
	            }
	            // Move right
	            while(cur < heights.length - 1 && heights[cur] >= heights[cur + 1]) {
	                cur++;
	            }
	            // Move left to K
	            while(cur >k  && heights[cur] >= heights[cur - 1]) {
	                cur--;
	            }
	            heights[cur]++;
	        }

	        return heights;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int[] heights = { 1,1,1,1};
		int V = 4;
		int K = 3;
		int ans[]=pourWater(heights, V, K);
		for(int v:ans){
			System.out.print(v+" ");
		}
	}

}
