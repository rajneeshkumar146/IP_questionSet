package recursion;

public class WaterOverflow {

	public static void main(String[] args) {

		System.out.println(pourWater(1, 2, 3));

	}

	public static double pourWater(int c, int r, int k) {

		if (c == 0) {
			return 0;
		}
		if (c == r + 1) {
			return 0;
		}
		if (c == 1 && r == 1) {
			return k;
		}

		double inputToTheUpperLeftJar = pourWater(c - 1, r - 1, k);
		double inputToTheUpperRightJar = pourWater(c, r - 1, k);
		double outFlowFromUpperLeft = Math.max(0, inputToTheUpperLeftJar - 1);
		double outFlowFromUpperRight = Math.max(0, inputToTheUpperRightJar - 1);
		double inputToTheFinalJar = outFlowFromUpperLeft / 2 + outFlowFromUpperRight / 2;
		double answer = Math.min(1, inputToTheFinalJar);
		return answer;

	}

}
