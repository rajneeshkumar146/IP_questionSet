package SnS;

import java.util.Arrays;
import java.util.Scanner;

public class super_primes {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int tc=scn.nextInt();
		for(int i=0;i<tc;i++){
		    int n=scn.nextInt();
		    countSuperPrime(n);
		}
	}
	
	public static void checkPrime(boolean[] isprime,int N){
	    
	    Arrays.fill(isprime,true);
	    isprime[0]=false;
	    isprime[1]=false;
	    for(int i=2;i*i<=N;i++)
	    {
	        if(isprime[i]==true){
	            for(int j=i;j*i<=N;j++){
	                isprime[j*i]=false;
	            }
	        }
	    }
	    
	}
	
	public static void countSuperPrime(int N){
	    
	    boolean[] isprime=new boolean[N+1];
	    checkPrime(isprime,N);
	    int primeCount=0;
	    int [] primes=new int[N+1];
	    
	    for(int i=2;i<isprime.length;i++){
	        if(isprime[i]==true){
	            primes[primeCount++]=i;
	        }
	    }
	    int count=0;
	    for(int i=0;i<primeCount;i++){
	       // System.out.println(primes[i]);
	        if(primes[i]!=3&&isprime[i+1]==true){
	            count++;
	            //System.out.println(primes[i]);
	       
	        }
	    }
	    
	    System.out.println(count);
	}

}
