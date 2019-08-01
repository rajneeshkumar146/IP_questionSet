package june1;

import java.util.Arrays;
import java.util.Scanner;

public class XORingAndClearing {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		while(T-- > 0){
			int n = scn.nextInt();
			int arr[] = new int[n];
			
			for(int i=0; i < n; i++){
				arr[i] = scn.nextInt();
			}
			
			xor1ToN(arr, n);
			printArr(arr, n);
			setToZero(arr, n);
			printArr(arr, n);
		}
	}
	
	private static void printArr(int arr[],int n)
    {
        for(int i=0; i < n; i++) {
        	System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
   private static void setToZero(int arr[],int n)
    {
	   Arrays.fill(arr, 0);
    }
    
   private static void xor1ToN(int arr[], int n)
    {
        
        for(int i=0; i < n; i++){
        	arr[i] = arr[i] ^ i;
        }
        
    }

}
