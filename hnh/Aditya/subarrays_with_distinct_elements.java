package june1;

import java.util.HashSet;
import java.util.Scanner;

public class subarrays_with_distinct_elements {

	// ((j – i +1)*(j – i +2))/2

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		
		int t=scn.nextInt();
		
		for(int tc=0;tc<t;tc++){
			int n=scn.nextInt();
			
			int[] arr=new int[n];
			for(int i=0;i<n;i++){
				arr[i]=scn.nextInt();
			}
			
			int end=0,ans=0;
			HashSet<Integer> visited=new HashSet<>();
			
			for(int i=0;i<n;i++){
				while(end<n && !visited.contains(arr[end])){
					visited.add(arr[end]);
					end++;
				}
				
				ans+=((end - i )*(end - i +1))/2 ; //total number of subsequences between i and end
				visited.remove(arr[i]);
				
			}
			
			System.out.println(ans);
		}
	}

}
