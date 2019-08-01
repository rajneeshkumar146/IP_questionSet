package may30;

import java.util.HashMap;
import java.util.Scanner;

public class smallest_subarray_with_all_occurances_of_most_frequent_element {

	

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		for (int tc = 0; tc < t; tc++) {
			int n = scn.nextInt();
			int[] arr = new int[n];

			HashMap<Integer, Integer> count = new HashMap<>();
			HashMap<Integer, Integer> starts=new HashMap<>();

			int maxend=-1;
			int maxfreq=-1;
			int maxfval=-1;
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
				
				count.put(arr[i], count.getOrDefault(arr[i], 0)+1);
				if(!starts.containsKey(arr[i])){
					starts.put(arr[i], i);
				}
				
				
				if(count.get(arr[i])>maxfreq){
					maxfreq=count.get(arr[i]);
					maxend=i;
					maxfval=arr[i];
				}
				else if(count.get(arr[i])==maxfreq){
					if(i-starts.get(arr[i])+1<maxend-starts.get(maxfval)+1){
						maxfreq=count.get(arr[i]);
						maxend=i;
						maxfval=arr[i];
					}
				}
			}
			
			
			
		
			
			for(int i=starts.get(maxfval) ; i<=maxend;i++){
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}

	}
}
