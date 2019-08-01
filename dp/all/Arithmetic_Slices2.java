import java.util.HashMap;

public class Arithmetic_Slices2 {
	// Subsequnce

	public static void main(String[] args) {
		int[] A = { 1, 1, 2, 3, 4,5};
		System.out.println(Arithmetic_Subsequence(A));
	}

	public static int Arithmetic_Subsequence(int[] A) {
		int min = A[0], max = A[0];
		int ans = 0;
		
		//Store the sequence ending with ith element
		//Sequences ending with a particular element will be 
		//multiple(i.e with different common difference)
		//Each entry has a table with common diff plotted with their count 
		HashMap<Integer, Integer>[] strg = new HashMap[A.length];
		
		for (int i = 0; i < strg.length; i++) {
			strg[i]=new HashMap<>();
			
			//Checking the correct sequence to which the 
			//new element can be appended
			for (int j = 0; j < i; j++) {
				
				int value = strg[j].getOrDefault(A[i] - A[j], 0);
				
				//old val is necessary in case of sequences with same comm diff 
				int ov=strg[i].getOrDefault(A[i]-A[j], 0);
				
				//1 is added for a new potential ssequence
				strg[i].put(A[i] - A[j], value+ov+1);
				
				//Taking only those counts which have become a complete sequence
				ans+=value;
			}
		}
		return ans;
	}
}
