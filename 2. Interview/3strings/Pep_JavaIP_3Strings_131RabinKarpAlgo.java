package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_131RabinKarpAlgo {

	 public final static int d = 256;
     
	    /* pat -> pattern
	        txt -> text
	        q -> A prime number
	    */


	
	    static void search(String pat, String txt, int q)
	    {
	        int M = pat.length();
	        int N = txt.length();
		// we calculate the hash value for the window of length of pattern 
		//for both txt and pattern 
		//h value is calculated initially as d^M-1.mod q.
		//which is required to obtain the next hash value of window
		//using previous.
		
	        int i, j;
	        int p = 0; // hash value for pattern
	        int t = 0; // hash value for txt
	        int h = 1;
	     
	        // The value of h would be "pow(d, M-1)%q"
	        for (i = 0; i < M-1; i++)
	            h = (h*d)%q;
	     
	        // Calculate the hash value of pattern and first
	        // window of text
	        for (i = 0; i < M; i++)
	        {
		//p and t will represent the hash values of the starting window.
	            p = (d*p + pat.charAt(i))%q;
	            t = (d*t + txt.charAt(i))%q;
	        }
	     
	        // Slide the pattern over text one by one
	        for (i = 0; i <= N - M; i++)
	        {
	     
	            // Check the hash values of current window of text
	            // and pattern. If the hash values match then only
	            // check for characters on by one
	            if ( p == t )
	            {
	                /* Check for characters one by one */
	                for (j = 0; j < M; j++)
	                {
	                    if (txt.charAt(i+j) != pat.charAt(j))
	                        break;
	                }
	     
	                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
	                if (j == M)
	                    System.out.println("Pattern found at index " + i);
	            }
	     
	            // Calculate hash value for next window of text: Remove
	            // leading digit, add trailing digit
	            if ( i < N-M )
	            {
	                t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+M))%q;
	     
	                // We might get negative value of t, converting it
	                // to positive
	                if (t < 0)
	                t = (t + q);
	            }
	        }
	    }
	     
	    /* Driver program to test above function */
	    public static void main(String[] args)
	    {
	        Scanner scn=new Scanner(System.in);
	        
	    	String txt = scn.nextLine();
	        String pat = scn.nextLine();
	        int q = 101; // A prime number
	        search(pat, txt, q);
	    }
}

/*
Test cases:
	This is test case
	test
	-----------------
	Pattern found at index 8
	
	
	GEEKS FOR GEEKS
	GEEKS
	--------------------
	Pattern found at index 0
	Pattern found at index 10
	
	
	PEPCODING-PursuitofExcellence
	Excel
	--------------------
	Pattern found at index 19
	
	
	Source: https://www.geeksforgeeks.org/searching-for-patterns-set-3-rabin-karp-algorithm/
	*/

