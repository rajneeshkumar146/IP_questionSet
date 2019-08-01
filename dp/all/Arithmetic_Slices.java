
public class Arithmetic_Slices {

	public static void main(String[] args) {
		int[] A= {1,3,5,7,9,15,20,25,28,29};
		int[] A2= {1,3,5,7,9};
		System.out.println(Arithmetic_Slices2(A2));
	}
	public static int Arithmetic_Slices(int[] A) {
		int ans=0;
		
		// to store the count of slices including the element i in the last
		int[] dp=new int[A.length];
		for (int i = 2; i < A.length; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				// new count will be 1 more due to A[i-2],A[i-1],A[i]
				dp[i]=dp[i-1]+1;
				ans+=dp[i];
			}
		}
		return ans;
	}
	
	//without dp
	public static int Arithmetic_Slices2(int[] A) {
		int ans=0;
		int s=0, e=2;
		while(e<A.length) {
			if(A[e]-A[e-1]==A[e-1]-A[e-2]) {
				ans+=(e-s-1);
			}
			else s=e-1;
			e++;
		}
		return ans;
	}
}
