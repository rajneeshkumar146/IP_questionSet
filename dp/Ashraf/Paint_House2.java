package InternQuestionDP;

public class Paint_House2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		There are a row of n houses, each house can be painted with one of the k colors.
//		The cost of painting each house with a certain color is different. You have to 
//		paint all the houses such that no two adjacent houses have the same color.
//
//		The cost of painting each house with a certain color is represented by a n x k
//		cost matrix. For example, costs[0][0] is the cost of painting house 0 with color
//		0; costs[1][2] is the cost of painting house 1 with color 2, and so on...
//		Find the minimum cost to paint all houses.
//		Input:
//			costs = [[14,2,11],[11,14,5],[14,3,10]]
//			Output: 10
//			Explanation:
//			The three house use color [1,2,1] for each house. The total cost is 10.

	}

	public int minCostII(int[][] costs) {
		// write your code here
		if (costs == null || costs.length == 0)
			return 0;

		for (int i = 1; i < costs.length; i++) {
			for (int j = 0; j < costs[0].length; j++) {
				int min = Integer.MAX_VALUE;
				for (int k = 0; k < costs[0].length; k++) {
					if (k != j)
						min = Math.min(costs[i - 1][k], min);
				}
				costs[i][j] += min;
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < costs[0].length; i++)
			ans = Math.min(ans, costs[costs.length - 1][i]);
		return ans;
	}
}
