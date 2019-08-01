package pepques;

import java.util.Scanner;

public class ques_52_replace_int {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		
	}
public static  int replace(int n)
{
	 if (n == Integer.MAX_VALUE) return replace(n-1);
     if (n == 1) return 0;
     if (n%2==0) return replace(n/2)+1;  
     
     return Math.min(replace(n-1), replace(n+1))+1;

}
}
