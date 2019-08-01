package pep_sns;

public class guess_number_higher_or_lower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(guessNumber(10));
	}
	
	public static int guess(int v) {
		if(v < 6) {
			return 1;
		}
		if(v >= 7) {
			return -1;
		}
		if(v == 6) {
			return 0;
		}
		return -1;
	}
	
	public static int guessNumber(int n) {
        int left = 1;
        int right = n;
        while(left <= right){
            int mid = left + (right - left)/2;
            int res = guess(mid);
            if(res == 0){
                return mid;
            }
            if(res == -1){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

}
