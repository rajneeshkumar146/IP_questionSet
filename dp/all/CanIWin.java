
public class CanIWin {

	public boolean canIWin(int choose, int total) {

		if (choose >= total)

			return true;

		if (choose * (choose + 1) / 2 < total)

			return false;

		Boolean memo[] = new Boolean[1 << (choose + 1)];

		return dp(0, 0, choose, total, memo);

	}

	private boolean dp(int cur, int used, int choose, int total, Boolean[] memo) {

		if (memo[used] != null)

			return memo[used];

		for (int i = choose; i > 0; i--) {

			if ((used & (1 << i)) == 0) {

				if (cur + i >= total) {

					memo[used] = true;

					return true;

				}

				if (!dp(cur + i, used | (1 << i), choose, total, memo)) {

					memo[used] = true;

					return true;

				}
			}

		}

		memo[used] = false;

		return false;

	}
}
