package pep_sns;

public class elements_in_range {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     int lr = 2;
	     int rr = 5;
	     int count = 0;
	     int[] arr = {1, 4, 5, 2, 7, 8, 3};
	     for(int i=0; i<arr.length; i++){
	         if(arr[i] >= lr && arr[i] <= rr){
	             count++;
	         }
	     }
	     if(count == rr - lr + 1)
	        System.out.println("Yes");
	     else
	        System.out.println("No");

	}

}
