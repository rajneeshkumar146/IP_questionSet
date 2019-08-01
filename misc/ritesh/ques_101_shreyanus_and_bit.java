package pepques;

import java.util.Scanner;

public class ques_101_shreyanus_and_bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
		    long n = sc.nextLong();
		    if((n &(n+1))==0) {
		        System.out.println("0");
		        continue;
		    }
		    int size=0;
		   String s=Long.toBinaryString(n);
		   size=s.length();
		    int a[] = new int[size];
		    int k=size-1;
		    int c1=0;
		    while(n>0) {
		        if((n&((long)1)) == 0) {
		            a[k]=0;
		        } else {
		            a[k]=1;
		            c1++;
		        }
		        k--;
		        n>>=1;
		    } 
		    long ans=0;
		    for(int i=0;i<size;i++) {
		        if(a[i]==1) {
		            int p = size-i-1;
		            ans += (nCr(p,c1));
		            c1--;
		        }
		    }
		    System.out.println(ans);
		}
	}
	
	static long nCr(int n,int r) {
		    int i=1;
		    long ans=1;
		    while(i<=r) {
		        ans*=n;
		        ans/=i;
		        n--;
		        i++;
		    }
		    return ans;
	}

}
