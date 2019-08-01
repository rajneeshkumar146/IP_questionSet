package june1;

import java.util.Scanner;

public class MysticFallsSchool {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		
		while(T-- > 0){
			int x = scn.nextInt();
			int g = scn.nextInt();
			System.out.println(~x + g);
		}
	}

}
