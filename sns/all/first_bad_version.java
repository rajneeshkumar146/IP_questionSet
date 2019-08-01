package pep_sns;

public class first_bad_version {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstBadVersion(5));
	}
	
	//THIS FUNCTION WAS PROVIDED AS AN API ONLINE.
	public static boolean isBadVersion(int v) {
		if(v < 3)
			return false;
		else
			return true;
	}
	
	public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(isBadVersion(mid) && !isBadVersion(mid - 1)){
                return mid;
            }
            if(!isBadVersion(mid) && isBadVersion(mid + 1)){
                return mid + 1;
            }
            if(isBadVersion(mid) && isBadVersion(mid - 1)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

}
