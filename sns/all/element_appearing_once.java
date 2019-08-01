package pep_sns;

public class element_appearing_once {
	
	public static void main(String[] args) {
		int n = 5;
	     int[] arr = {1,1,2,2,3};
	     int xorval = 0;
	     for(int i=0; i<n; i++){
	         xorval ^= arr[i];
	     }
	     System.out.println(xorval);
	}

}
