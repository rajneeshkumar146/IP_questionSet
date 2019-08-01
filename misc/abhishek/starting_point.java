package may31;

import java.util.Scanner;

public class StartingPoint {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int T = s.nextInt();
		while(T-- > 0){
			
			// Starting pos
			int X = s.nextInt();
			int Y = s.nextInt();
			
			int N = s.nextInt(); // no of paths
						
			for(int i=0; i < N; i++){
				int m = s.nextInt();
				X -= m;   
				
				int n = s.nextInt();
				Y -= n;
			}
			
			System.out.println(X + " " + Y);
			
		}
	}

}
