package dp;

import java.util.Scanner;

public class Min_cost_climbing_stairs {

	public static void main(String[] args) {
	int []costs={
			10,15,20
	};
	System.out.println(func(costs));
	}

	public static int func(int[] costs) {
		int[] dp = new int[2];
		int x = 0;
		int y = costs[costs.length - 2], z = costs[costs.length - 1];

		for (int i = costs.length - 3; i >= 0; i--) {
			x = Math.min(y, z) + costs[i];
               z=y;
               y=x;
               
		}
return Math.min(x, z);
	}
}
