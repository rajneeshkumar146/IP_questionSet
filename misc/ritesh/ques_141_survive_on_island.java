package pepques;

import java.util.Scanner;

public class ques_141_survive_on_island {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t>0){
		    int s = scn.nextInt();
		    int n = scn.nextInt();
		    int m = scn.nextInt();
		    
		    if( n*6 < m*7 && s>6  )
		    {
		        System.out.println("-1");
		    }
		    else if(m>n)
		    {
		    	  System.out.println("-1");
		    }
		    else
		    {
		        int days = (s*m) / n;
		        if((s*m)%n !=0 )
		        {
		            days++;
		        }
		        System.out.println(days);
		    }
		    t--;
		}
	}

}
