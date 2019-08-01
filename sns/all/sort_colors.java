package SnS;

public class sort_colors {

	public static void main(String[] args) {
		int[] nums= {0,1,2,1,2,1,2,0,0};
		sortColors(nums);
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]+" ");
		}
		System.out.println();
	}
	public  static void sortColors(int[] nums) {
        int zero=0;
        //int one=0;
        int two=nums.length-1;
        int i=0;
        while(i<=two){
            if(nums[i]==0){
                swap(nums,i,zero);
                zero++;
                i++;
            }else if(nums[i]==2){
                swap(nums,i,two);
                two--;
            }else{
                i++;
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


}
