package pepques;

import java.util.Scanner;

public class ques_41_nim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
			int t;
			t=s.nextInt();
			while(t-->0){
			    int n=s.nextInt();;
			    
			    if((n&1)>0)
			    System.out.print("Player A\n");
			    else 
			    	System.out.print("Player B\n");
			}
			
	}

}
