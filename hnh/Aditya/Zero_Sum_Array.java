package may27;

import java.util.HashMap;
import java.util.Scanner;

public class Zero_Sum_Array {

	public static void main(String[] args) {
		Scanner scn= new Scanner(System.in);
		
		int n=scn.nextInt();
		for(int i=0;i<n;i++){
			
			int size=scn.nextInt();
			
			long[] arr=new long[size];
			
			for(int j=0;j<size;j++){
				arr[j]=scn.nextLong();
			}
			
			zerosumarr(arr);
		}

		

	}
	
	static void zerosumarr(long[] arr){
		long sumsofar=0;
		long count=0;
	
		HashMap<Long, Long> hm=new HashMap<>();
		
		for(int i=0;i<arr.length;i++){
			sumsofar+=arr[i];
			
			if(sumsofar==0){
				count++;
			}
			
			if(hm.containsKey(sumsofar)){
				count+=hm.get(sumsofar);
				hm.put(sumsofar, hm.get(sumsofar)+1);
			}
			else{
				hm.put(sumsofar, 1L);
			}
		}
		
		System.out.println(count);
	}
	
	
	

}
