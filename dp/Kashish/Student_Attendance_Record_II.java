package InternQuestDP;

import java.util.Scanner;

public class Student_Attendance_Record_II {
	static int mod=(int) (1e9+7);
	public static int checkRecord(int n) {
		if(n==0){
			return 0;
		}
		else if(n==1){
			return 3;
		}
		long dp[][] = new long[n + 1][7];
		dp[2][0] = 2;
		dp[2][1] = 1;
		dp[2][2] = 2;
		dp[2][3] = 1;
		dp[2][4] = 1;
		dp[2][5] = 0;
		dp[2][6] = 1;
		for (int i = 3; i <= n; i++) {
			dp[i][0] = (dp[i-1][2]+dp[i-1][4]+dp[i-1][6])%mod;
			dp[i][1] = (dp[i-1][0]+dp[i-1][1]+dp[i-1][3]+dp[i-1][5])%mod;
			dp[i][2] = (dp[i-1][2]+dp[i-1][4]+dp[i-1][6])%mod;
			dp[i][3] = (dp[i-1][0]%mod+dp[i-1][1]%mod)%mod;
			dp[i][4] = (dp[i-1][2])%mod;
			dp[i][5] = (dp[i-1][3])%mod;
			dp[i][6] = (dp[i-1][4])%mod;
		}
		long sum=0;
		for(int i=0;i<7;i++){
			sum=(sum%mod+(dp[n][i])%mod)%mod;
		}
		
		return (int) (sum%mod);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		System.out.println(checkRecord(n));

	}

}