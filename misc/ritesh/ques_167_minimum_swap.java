package pepques;

import java.util.LinkedList;
import java.util.Scanner;

public class ques_167_minimum_swap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			String st=s.next();
		
			int i=0;
			int swap=0;
			int unbal=0;
			int cl=0,cr=0;
			
			while(i<st.length())
			{
				if(st.charAt(i)=='[')
				{
					cl++;
					if(unbal > 0)  
	                { 
	                     
	                    swap += unbal;  
	                   
	                    unbal--;    
	                }
				}
				else{
					
					cr++;
					unbal=cr-cl;
				}
				
				i++;
			}
			
			System.out.println(swap);
			t--;
		}
	}

}
