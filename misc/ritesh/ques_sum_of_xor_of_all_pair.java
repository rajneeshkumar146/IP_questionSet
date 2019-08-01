package pepques;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ques_sum_of_xor_of_all_pair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 Scanner s=new Scanner(System.in);
		 int t=s.nextInt();
		 StringBuilder str=new StringBuilder();
		
		 while(t>0)
		 {
		 int n=s.nextInt();
		 int [] no=new int[n];
		 for(int i=0;i<n;i++)
		 {
		 no[i]=s.nextInt();
		 }
		
		 long sum=0;
		
		 for(int i=0;i<n-1;i++){
		
		 for(int j=i+1;j<n;j++){
		
		
		 sum=sum+(no[i]^no[j]);
		 }
		 }
		 str.append(sum+"\n");
		 t--;
		 }
		
		 System.out.println(str);
		
		
	}

}
