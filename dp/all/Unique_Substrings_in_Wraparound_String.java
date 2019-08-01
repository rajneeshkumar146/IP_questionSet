package InternQuestDP;

import java.util.Scanner;

public class Unique_Substrings_in_Wraparound_String {
	
    public static  int findSubstringInWraproundString(String p) {     
    	        int[] count = new int[26];
    	        int maxLengthCur = 0; 

    	        for (int i = 0; i < p.length(); i++) {
    	            if (i > 0 && (p.charAt(i) - 'a' == (p.charAt(i-1) - 'a' + 1) % 26)) {
    	                maxLengthCur++;
    	            }
    	            else {
    	                maxLengthCur = 1;
    	            }
    	            
    	            int index = p.charAt(i) - 'a';
    	            count[index] = Math.max(count[index], maxLengthCur);
    	        }
    	        
    	        
    	        int sum = 0;
    	        for (int i = 0; i < 26; i++) {
    	            sum += count[i];
    	        }
    	        return sum;
    	    }
    	
    	
        
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		String p=scn.next();
		int count=findSubstringInWraproundString(p);
		System.out.println(count);

		
		

	}

}
