package pep_sns;

public class koko_eating_bananas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] piles = {30,11,23,4,20};
		int H = 5;
		System.out.println(minEatingSpeed(piles, H));

	}
	public static int minEatingSpeed(int[] piles, int H) {
        int lo = 1;
        int hi = (int)Math.pow(10, 9);
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (!caneat(piles, H, mid))
                lo = mid + 1;
            else
                hi = mid;
        }

        return lo;
    }
	public static boolean caneat(int[] piles, int h, int k) {
        int t = 0;
        for (int p: piles)
            t += (p - 1) / k + 1;
        return t <= h;
    }

}
