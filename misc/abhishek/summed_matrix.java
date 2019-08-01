package may31;

import java.util.Scanner;

public class SummedMatrix {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		
		while(T-- > 0){
			long n = s.nextLong();
			long q = s.nextLong();
			
			if(n > q){
				System.out.println(q - 1);
			} else{
				System.out.println(2*n - q + 1);
			}
		}
	}

}
