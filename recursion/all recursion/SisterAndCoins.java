import java.util.Scanner;

public class SisterAndCoins {

	public static void main(String[] args) {

		int[] denom = { 1, 2, 3, 0, 6 };
		int gila = 0;
		int mila = 6;
		for (int i = 0; i < denom.length; i++) {
			gila += denom[i];
		}
		if ((gila + mila) % 2 != 0) {
			System.out.println(false);
		} else {
			System.out.println(isDistributionPossible(gila, mila, denom, 0));
		}
	}

	public static boolean isDistributionPossible(int gila, int mila, int[] denom, int i) {

		if (mila > gila || i == denom.length) {
			return false;
		}
		if (mila == gila) {
			return true;
		}

		boolean moneyGivenToMila = isDistributionPossible(gila - denom[i], mila + denom[i], denom, i + 1);
		boolean moneyNotGivenToGila = isDistributionPossible(gila, mila, denom, i+1);

		return moneyGivenToMila || moneyNotGivenToGila;

	}

}
