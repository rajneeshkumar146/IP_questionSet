package InternQuestDP;

import java.util.Arrays;
import java.util.Scanner;

public class video_stitching {
	static int MAX=100000;
	public static int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T+ 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for(int i = 0; i <= T; i++) {
            for(int[] c : clips) {
                if(i >= c[0] && i<= c[1])
                { dp[i]= Math.min(dp[i], dp[c[0]] + 1);}
                
            }
            if(dp[i] >=MAX ) return -1;// if i does not cover
        }
        return dp[T];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int [][]clips={{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
		int T=10;
		int minclips=videoStitching(clips, T);
		System.out.println(minclips);

	}

}
