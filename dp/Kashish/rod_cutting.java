package InternQuestDP;

import java.util.Scanner;

public class rod_cutting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		while(t-->0){
		int n=scn.nextInt();
		int prices[]=new int[n];
		for(int i=0;i<n;i++){
			prices[i]=scn.nextInt();
		}
		int max_val[]=new int[n+1];
		for(int i=1;i<=n;i++){
			int max=Integer.MIN_VALUE;
			for(int j=0;j<i;j++){
				max=Math.max(max, prices[j]+max_val[i-(j+1)]);
			}
			max_val[i]=max;
		}
		System.out.println(max_val[n]);
		}

	}

}
