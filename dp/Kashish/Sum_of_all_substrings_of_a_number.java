package InternQuestDP;

import java.util.Scanner;

public class Sum_of_all_substrings_of_a_number {
	public static long sumOfSubstrings(String n) 
    {  
        long sumofdigit[] = new long[n.length()]; 
       
      
        sumofdigit[0] = n.charAt(0)-'0'; 
        long res = sumofdigit[0]; 
       
        for (int i = 1; i < n.length(); i++) 
        { 
            int numi = n.charAt(i)-'0'; 
            sumofdigit[i] = (i+1) * numi + 10 * sumofdigit[i-1]; 
            res += sumofdigit[i]; 
        } 
        return res;      
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		while(t-->0){
		String n=scn.next();
		long res=sumOfSubstrings(n);
		System.out.println(res);
		}
	 

	}

}
