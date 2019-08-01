package pepques;

public class ques_146_delete_sorted_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

	 public static int minDeletionSize(String[] A) {
	        int N = A.length;
	        int W = A[0].length();
	        // cuts[j] is true : we don't need to check any new A[i][j] <= A[i][j+1]
	        boolean[] cuts = new boolean[N-1];

	        int ans = 0;
	        search: for (int j = 0; j < W; ++j) {
	            // Evaluate whether we can keep this column
	            for (int i = 0; i < N-1; ++i)
	                if (!cuts[i] && A[i].charAt(j) > A[i+1].charAt(j)) {
	                    // Can't keep the column - delete and continue
	                    ans++;
	                    continue search;
	                }

	            // Update 'cuts' information
	            for (int i = 0; i < N-1; ++i)
	                if (A[i].charAt(j) < A[i+1].charAt(j))
	                    cuts[i] = true;
	        }

	        return ans;
	 }
}
