package pepques;

import java.util.Scanner;

public class ques_139_broken_calculater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int x=s.nextInt();
		int y=s.nextInt();
		 int ans = 0;
	        while (y > x) {
	            if (y % 2 == 1)
	                y++;
	            
	            else
	                y /= 2;
	            ans++;
	        }

	         System.out.println(ans + x - y);
	}

}
