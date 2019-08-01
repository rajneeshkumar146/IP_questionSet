
public class _2KeyKeyboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(_2KeysKeyboard(30));
	}

	// problem reduces to finding the sum of all the 
	// prime factors(all and not unique) of the given target number
	public static int _2KeysKeyboard(int n) {
		int ans = 0;
		int fact = 2;
		
		//getting the all the 2 
		while (n % 2 == 0) {
			ans += 2;
			n /= 2;
		}
		
		// now the num is not div by 2
		fact = 3;
		while (fact * fact <= n) {
			//fact is always gonna be a prime number
			while (n % fact == 0) {
				ans += fact;
				n /= fact;
			}
			fact += 2;
			
		}
		
		// If the num is prime then it must not have become 1
		// To get the number as a factor it is added explicitly
		ans += n != 1 ? n : 0;
		
		return ans;
	}

}
