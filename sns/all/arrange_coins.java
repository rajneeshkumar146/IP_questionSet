package pep_sns;

public class arrange_coins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8; //1804289383 -> long test case
		System.out.println(arrangeCoins1(n));
		System.out.println(arrangeCoins2(n));
	}
	
	// using ap
	// sum from 1 -> sum = n * ( n + 1) / 2
	// n => solve using quadratic 
	public static int arrangeCoins1(int n) {
        int v1 = (int)(-1 + Math.sqrt(1 + (8*(long)n)))/2;
        return v1;
    }
	
	//use level wise while
	public static int arrangeCoins2(int n) {
		int stair = 1;
		int countfull = 0;
        while(n - stair >= 0) {
        	n = n - stair;
        	countfull++;
        	stair++;
        }
        return countfull;
    }
}
