package SnS;

public class valid_perfect_square {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPerfectSquare(808201));
	}

	public static boolean isPerfectSquare(int num) {

		if (num == 1) {
			return true;
		}
		long mid, left, right;
		right = num / 2;
		left = 1;

		while (left <= right) {
			mid = left + (right - left) / 2;
			long mulRes = mid * mid;
			if (mulRes == num) {
				return true;
			} else if (mulRes < num) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;

	}
}
