package june1;

import java.util.Scanner;

public class MrsSJavaSetBits1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		while(T-- > 0){
			long n = scn.nextLong();
			
			int setCount = 0;
			int unsetCount = 0;
			
			while(n > 0){
				if((n & 1) == 1){
					setCount++;
				}else{
					unsetCount++;
				}
				
				n = n >> 1;  // or n = n / 2
			}
			
			System.out.println(setCount + " " + unsetCount);
		}
	}

}
