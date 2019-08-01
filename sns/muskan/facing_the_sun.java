package pep_sns;

public class facing_the_sun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
	     int[] arr = {7,4,8,2,9};
	     int cb = arr[0];
	     int youcansee = 1;
	     for(int i=1; i<n; i++){
	         if(arr[i] > cb){
	             youcansee++;
	             cb = arr[i];
	         }
	     }
	     System.out.println(youcansee);

	}

}
