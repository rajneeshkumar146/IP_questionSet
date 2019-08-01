package mystack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class max_sum_in_subarray {
	 public static void findlargest(long arr[],int n) {
	     long sum=0;
		        for(int i=0;i<n-1;i++)
		        {
		            sum=Math.max(sum,arr[i]+arr[i+1]);
		        }
		        System.out.println(sum);
		    }
	public static void main(String[] args) throws Exception {
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		    int t=Integer.parseInt(br.readLine().trim());
		    while(t-->0)
		    {
		        int n=Integer.parseInt(br.readLine().trim());
		        long arr[]=new long[n];
		        String line=br.readLine();
		        String T[]=line.trim().split("\\s+");
		        for(int i=0;i<n;i++)
		        {
		            arr[i]=Long.parseLong(T[i]);
		        }
		        findlargest(arr,n);
		}
	}

}
