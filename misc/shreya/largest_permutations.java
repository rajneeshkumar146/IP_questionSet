package misc;

import java.util.Scanner;

public class largest_permutations {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();

		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			int k = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			int count = 0;
			for (int i = 0; count < k % n && i < n; i++) {
				int idx = i;
				for (int j = i + 1; j < n; j++) {
					if (arr[j] > arr[idx]) {
						idx = j;
					}
				}
				if (i != idx) {
					int temp = arr[i];
					arr[i] = arr[idx];
					arr[idx] = temp;
					count++;
				}
			}

			for (int i = 0; i < n; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}
	
/*	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();

		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			int k = scn.nextInt();
			int[] arr = new int[n];
			int[] pos=new int[n+1];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
				pos[arr[i]]=i;
			}
			int count=0;
			for(int i=0;count<k%n&&i<n;i++){
			    if(pos[n-i]!=i){
			        
			        int temp=pos[n-i];
			        pos[arr[i]]=pos[n-i];
			        pos[n-i]=i;
			        
			        arr[temp]=arr[i];
			        arr[i]=n-i;
			        count++;
			    }
			}
			
			for(int i=0;i<n;i++){
			    System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
	}
*/}
