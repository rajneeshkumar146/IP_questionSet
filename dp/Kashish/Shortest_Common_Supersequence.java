package InternQuestDP;

import java.util.Scanner;

public class Shortest_Common_Supersequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		while(t-->0){
		String s1=scn.next();
		String s2=scn.next();
		int length=ShortComSup(s1,s2);
		System.out.println(length);
		}

	}

	private static int ShortComSup(String s1, String s2) {
		int dp[][]=new int[s1.length()+1][s2.length()+1];
		char []st1=s1.toCharArray();
		char []st2=s2.toCharArray();
		int ans=0;
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[0].length;j++){
				if(i==0 || j==0){
					dp[i][j]=0;
				}
				else{
					if(st1[i-1]==st2[j-1]){
						dp[i][j]=dp[i-1][j-1]+1;
					}
					else{
						dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
					}
				}
			}
			
			
		}
		int maxlen=Math.max(s1.length(), s2.length());
		int smalen=Math.min(s1.length(), s2.length());
		if(dp[s1.length()][s2.length()]==s1.length()|| dp[s1.length()][s2.length()]==s2.length()){
			ans= maxlen;
		}
		else{
			ans= maxlen+(smalen-dp[s1.length()][s2.length()]);
		}
	return ans;
	}

}
