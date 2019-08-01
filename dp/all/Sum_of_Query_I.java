package InternQuestDP;

import java.util.Scanner;

public class Sum_of_Query_I {
	public static int calculate(int[] dp, int[] dp1, int[] dp2, int l, int r){
		 return (dp2[r]-dp2[l-1])-2*(dp1[r]-dp1[l-1])*(l-1)+(dp[r]-dp[l-1])*(l-1)*(l-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			int dp[] = new int[n + 1];
			int dp1[] = new int[n + 1];
			int dp2[] = new int[n + 1];
			for (int i = 1; i <= n; i++)

			{
				dp[i] += dp[i - 1] + arr[i-1];
				dp1[i] += dp1[i - 1] + arr[i-1] * i;
				dp2[i] += dp2[i - 1] + arr[i-1] * i * i;
			}
			int q = scn.nextInt();
			String ans="";
			for (int i = 0; i < q; i++) {
				int l = scn.nextInt();
				int r = scn.nextInt();
				ans+=calculate(dp,dp1,dp2,l,r)+" ";
	
		}
			System.out.println(ans);

	}

}
}
