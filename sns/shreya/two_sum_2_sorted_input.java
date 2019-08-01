package SnS;

public class two_sum_2_sorted_input {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers= {2,7,11,15};
		int[] res=twoSum(numbers,9);
		for(int i=0;i<res.length;i++) {
			System.out.print(res[i]+" ");
		}
	}
	
	 public static int[] twoSum(int[] numbers, int target) {
	        
	        int left=0;
	        int right=numbers.length-1;
	        
	        while(left<right){
	            if(numbers[left]+numbers[right]<target){
	              left++;  
	            }else if(numbers[left]+numbers[right]>target){
	                right--;
	            }else{
	                int[] res={left+1,right+1};
	                return res;
	            }
	        }
	        
	        return null;
	    }


}
