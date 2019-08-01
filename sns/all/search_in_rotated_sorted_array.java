package SnS;

public class search_in_rotated_sorted_array{
	
	public static void main(String[] args) {
		int[] arr= {4,5,6,7,1,2,3};
		System.out.println(search(arr, 11));
	}

	public static boolean search(int[] nums, int target) {
        int high1=nums.length-1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==target){
                return true;
            }else if(nums[i]>nums[i+1]){
                high1=i;
                break;
            }
        }
        
        return binarySearch(nums,0,high1,target)||binarySearch(nums,high1+1,nums.length-1,target);
        
    }
    
    public static boolean binarySearch(int[] arr,int low,int high,int target){
        
        while(low<=high){
            int mid=(low+high)/2;
            if(target==arr[mid]){
                return true;
            }else if(arr[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        
        return false;
    }

}
