package pepques;

import java.util.Scanner;

public class ques_142_choose_swap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<t;i++)
		{
		    String s=sc.nextLine();
		    int arr[]=new int[26];
		    for(int y=0;y<s.length();y++)
		    {
		        arr[s.charAt(y)-'a']++;
		    }
		    int m=0;
		    while(arr[m]<=0)
		    {
		        m++;
		    }
		    for(int z=0;z<s.length();z++)
		    {
		       if(s.charAt(z)-'a'>m)
		       {
		           char x=(char)(m+'a');
		           String as=""+s.charAt(z);
		           String aa=""+x;
		           s=s.replaceAll(aa,"0");
		           s=s.replaceAll(as,aa);
		           s=s.replaceAll("0",as);
		           break;
		       }
		       else if(s.charAt(z)-'a'==m)
		       {
		           m++;
		           while(m<26&&arr[m]<=0)
		           {
		                m++;
		           }      
		       }
		    }
		    System.out.println(s);
		}
	
		
		
	}

}
