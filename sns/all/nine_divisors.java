package pep_sns;

import java.util.Arrays;

public class nine_divisors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 40;
		int count=0;
        int len = (int)Math.sqrt(n);
        int prime[] = new int[len+1];
        for(int i=0;i<=len;i++) 
            prime[i]=i;
        for(int i=2;i<=len;i++){
            if(prime[i]==i){
                for(int j=i*i;j<=len;j+=i){
                    if(prime[j]==j) prime[j]=i;
                }
            }
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            int p = prime[i];
            int q = prime[i / prime[i]];
            if (p * q == i && q != 1 && p != q) { 
                count += 1; 
            } else if (prime[i] == i) {
                if (Math.pow(i, 8) <= n) { 
                    count += 1; 
                } 
            }
        }
        System.out.println(count);
		/*int count = 0;
		int left = 0;
		int right = n;
		while (left < right) {
			if (primes[left] == true && primes[right] == true) {
				int leftsq = left * left;
				int rightsq = right * right;
				if (leftsq * rightsq < n) {
					count++;
				}
				right--;
			} else {
				right = primes[right] != true ? right - 1 : right;
				left = primes[left] != true ? left + 1 : left;
			}
		}
		System.out.println(count);*/

	}

}
