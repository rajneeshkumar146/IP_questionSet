package SnS;

public class sort_array_by_parity_2 {

	public static void main(String[] args) {
		int[] arr= {4,2,5,7};
		int[] res=sortArrayByParityII(arr);
		display(res);

	}
	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		
	}
	
	public static int[] sortArrayByParityII(int[] A) {
	     
	        int[] temp=new int[A.length];
	        int oIdx=1;
	        int eIdx=0;
	        for(int i=0;i<A.length;i++){
	            if(A[i]%2==0){
	                temp[eIdx]=A[i];
	                eIdx+=2;
	            }else{
	                temp[oIdx]=A[i];
	                oIdx+=2;
	            }   
	        }
	        
	     return temp;
	    }
}
