package hnh;

import java.util.HashSet;
import java.util.Scanner;

public class uniquenumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int test=scn.nextInt();
		for(int t=1;t<=test;t++){
			int l=scn.nextInt();
			int r=scn.nextInt();
			System.out.println(numners(l,r));
		}
		

	}
public static int numners(int l,int r){
	int count=0;
	for(int i=l;i<=r;i++){
		int num=i;
		HashSet<Integer> st=new HashSet<>();
		while(num>0){
			if(st.contains(num%10)){
				break;
			}
			st.add(num%10);
			num=num/10;
		}
		if(num==0){
			count++;
		}
	}
	return count;
}
}
