package dp;

import java.util.Scanner;

public class Maximum_sum_problem {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		Integer[] dp = new Integer[100001];
		Integer []broken=new Integer[100001];
		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
    System.out.println(func(n, dp,broken));
		}
	}

	public static int func(int n, Integer[] dp,Integer []broken) {
		if(n==0|n==1){
			return n;
		}
		if (dp[n] != null) {
			return dp[n];
		} else {
			
			int v = func(n / 2, dp,broken);
			int c = func(n / 3, dp,broken);
			int l = func(n / 4, dp,broken);
			int sum = v > n / 2 ? v : n / 2 + c > n / 3 ? c : n / 3 + l > n / 4 ? l : n / 4;
            dp[n]=Math.max(n, sum);
            broken[n]=sum;
            return dp[n];
		}
	}
}
