package pep_sns;

public class inversion_of_array {

	static long[] arr = {2, 4, 1, 3, 5};
	static long inversions;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		inversions = 0;
		mergesort(arr, 0, n-1);
		System.out.println(inversions);
	}
	
	public static void mergesort(long[] arr, int low, int high){
	     if(low >= high){
	        return;
	     }
	     int mid = (low + high)/2;
	     mergesort(arr, low, mid);
	     mergesort(arr, mid + 1, high);
	     merge(low, mid, high);
	 }
	 
	 public static void merge(int s, int m, int e) {
		long[] tempArr = new long[e-s+1];
	    int p1 = s;
	    int p2 = m+1;
	    int k = 0;
	    while(p1<=m && p2<=e){
	        if(arr[p2]<arr[p1]){
	            inversions += m-p1+1;
	            tempArr[k] = arr[p2];
	            p2++;
	        }else{
	            tempArr[k] = arr[p1];
	            p1++;
	        }
	        k++;
	    }
	    
	    while(p1<=m){
	        tempArr[k] = arr[p1];
	        p1++;
	        k++;
	    }
	    
	    while(p2<=e){
	       tempArr[k] = arr[p2];
	       p2++;
	       k++;
	    }
	    
	    for(int i=0;i<=e-s;i++){
	        arr[s+i] = tempArr[i];
	    }

	}

}
