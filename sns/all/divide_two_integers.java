package pep_sns;

public class divide_two_integers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(-2147483648, -1));
	
	}
	public static int divide(int dividend, int divisor) {
        if (divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
	if (divisor == 1) return dividend;
	if (divisor == -1) return -dividend;

	long left = 0;
	long right = Math.abs((long) dividend);
	long sign = dividend < 0 ^ divisor < 0 ? -1 : 1;        

	while (left < right) {
	  long mid = left + (right - left) / 2;

	  if (Math.abs(mid * divisor) > Math.abs((long) dividend)) {
		right = mid;
	  } else {
		left = mid + 1;
	  }
	}

	return (int) (sign * (left - 1));
    }

}
