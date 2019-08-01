package may28;

import java.util.HashSet;
import java.util.Scanner;

public class Sums_equal_to_sum {
	
	
	

	public static void main(String[] args) {
		
		
		Scanner scn=new Scanner(System.in);
		
		int t=scn.nextInt();
		
		for(int tc=0;tc<t;tc++){
			
			int n=scn.nextInt();
			int[] arr=new int[n];
			
			
			
			for(int i=0;i<n;i++){
				arr[i]=scn.nextInt();
			}
			
			HashSet<Integer> sums=new HashSet<>();
			Boolean bool=false;
			
			for(int i=0;i<n && bool==false;i++){
				for(int j=i+1;j<n;j++){
					if(sums.contains(arr[i]+arr[j])){
						bool=true;
						System.out.println(1);
						break;
					}
					else{
						sums.add(arr[i]+arr[j]);
					}
				}
			}
			
			if(bool==false){
				System.out.println(0);
			}
		}
		

	}

}
