package InternQuestDP;

import java.util.Scanner;
//check
public class Pizza_Mania {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int cap = scn.nextInt();
			int cost[] = new int[3];
			int pizzar[] = new int[3];
			for (int i = 0; i < 3; i++) {
				pizzar[i] = scn.nextInt();
			}
			for (int i = 0; i < 3; i++) {
				cost[i] = scn.nextInt();
			}

			int min_cost[] = new int[cap + 1];
			if (cap <= pizzar[0]) {
				System.out.println(cost[0]);
		
			} else {

				for (int i = 1; i <= pizzar[0]; i++) {
					min_cost[i] = cost[0];
				}
				int mincost = Minimumcost(pizzar, cost, cap, min_cost);
				System.out.println(mincost);
			}

		}

	}

	private static int Minimumcost(int[] pizzar, int[] cost, int cap, int[] min_cost) {
		if (cap < 0) {
			return 0;
		}
		if (cap <= pizzar[0]) {
			return min_cost[cap];
		}
		if (min_cost[cap] != 0) {
			return min_cost[cap];
		}

		min_cost[cap] = Math.min(Minimumcost(pizzar, cost, cap - pizzar[0], min_cost) + cost[0],
				Math.min(Minimumcost(pizzar, cost, cap - pizzar[1], min_cost) + cost[1],
						Minimumcost(pizzar, cost, cap - pizzar[2], min_cost) + cost[2]));

		return min_cost[cap];

	}

}
