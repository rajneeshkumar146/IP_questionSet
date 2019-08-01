
public class CountwaystoexpressNasSumof134 {
static int countWays(int n) 
		{ 
			int DP[] = new int[n + 1]; 

			// base cases 
			DP[0] = DP[1] = DP[2] = 1; 
			DP[3] = 2; 

			// iterate for all values from 4 to n 
			for (int i = 4; i <= n; i++) 
				DP[i] = DP[i - 1] + DP[i - 3] 
						+ DP[i - 4]; 

			return DP[n]; 
		} 


}
