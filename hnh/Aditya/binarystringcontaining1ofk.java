package hnh;

import java.util.Scanner;

public class binarystringcontaining1ofk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int  test=scn.nextInt();
		for(int t=1;t<=test;t++){
			String s=scn.next();
			int k=scn.nextInt();
			System.out.println(count(s, k));}

	}

	public static int count(String s,int k) {
		int[] freq = new int[s.length() + 1];
		freq[0] = 1;
		int sum = 0;
		int res=0;
		for (int i = 0; i < s.length(); i++) {
			sum += (int) (s.charAt(i) - '0');
			freq[sum] = freq[sum] + 1;
			if(sum>=k){
				res+=freq[sum-k];
			}

		}
		return res;
	}

}
