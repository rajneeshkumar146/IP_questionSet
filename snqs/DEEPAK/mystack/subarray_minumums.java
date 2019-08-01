package mystack;
import java.util.*;
public class subarray_minumums {
	 public static int sumSubarrayMins(int[] A) {
	        int MOD = 1_000_000_007;

	        Stack<Pair> stack = new Stack();
	        int ans = 0, curr = 0;
	        for (int j = 0; j < A.length; ++j) {
	            int count = 1;
	            while (!stack.isEmpty() && stack.peek().val >= A[j]) {
	                Pair rp = stack.pop();
	                count += rp.count;
	                curr -= rp.val * rp.count;
	            }
	            stack.push(new Pair(A[j], count));
	            curr += A[j] * count;
	            ans += curr;
	            ans %= MOD;
	        }

	        return ans;
	    }


	static class Pair {
	    int val, count;
	    Pair(int v, int c) {
	        val = v;
	        count = c;
	    }
	}
	    public static void main(String[] args){
	        Scanner sc=new Scanner(System.in);
	        int n=sc.nextInt();
	        int[] A=new int[n];
	        for(int i=0;i<n;i++)A[i]=sc.nextInt();
	        System.out.println(sumSubarrayMins(A));
	    }

}
