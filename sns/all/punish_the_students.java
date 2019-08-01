package pep_sns;

public class punish_the_students {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int n = 5;
		double givenavg = 68;
		int[] arr = {3, 2, 4, 1, 5};
		int[] marksarr = {50, 67, 89, 79, 58};*/
		int n = 6;
		double givenavg = 67.5;
		int[] arr = {5, 4, 1, 3, 2, 6};
		int[] marksarr = {78, 98, 86, 67, 78, 79};
		int[] count = new int[n + 1];
	     for(int i=0; i<n-1; i++){
	         for(int j=0; j<n-i-1; j++){
	             if(arr[j] > arr[j + 1]){
	                 count[arr[j]]++;
	                 count[arr[j + 1]]++;
	                 int temp = arr[j];
	                 arr[j] = arr[j + 1];
	                 arr[j + 1] = temp;
	             }
	         }
	     }
	     long sum = 0;
	     for(int i=0; i<n; i++){
	         marksarr[i] -= count[i + 1];
	         sum += marksarr[i];
	     }
	     if(sum/n < givenavg){
	         System.out.println("0");
	     }else{
	         System.out.println("1");
	     }

	}

}
