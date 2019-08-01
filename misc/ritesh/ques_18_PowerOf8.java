package pepques;

import java.util.Scanner;

public class ques_18_PowerOf8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int  t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int count=0;
			
			
			while(n!=0)
			{
			
				if(n%8!=0 ){
					if(count!=0)
					{
						
						System.out.println("No");
						return;
					}
					count++;
				}
				n=n/8;
				
			}
		System.out.println("Yes");
			t--;
			
			
		}
	}
	  public static boolean checkPowerof8(int n) 
	    { 
	        /* calculate log8(n) */
	        double i = Math.log(n) / Math.log(8); 
	      
	        /* check if i is an integer or not */
	        return (i - Math.floor(i) < 0.000001); 
	    }  

}
