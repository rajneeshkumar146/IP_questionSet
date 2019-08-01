package dp;

public class Maximum_product_array {

	public static void main(String[] args) {
int []func={2,3,-2,4};
System.out.println(func(func));
	}

	public static int func(int[] nums) {
		int []max=new int[2];
		int []min=new int[2];
		min[0]=nums[0];
		max[0]=nums[0];
		for(int i=1;i<nums.length;i++){
			max[i%2]=Math.max(max[(i+1)%2]*nums[i],Math.max(min[(i+1)%2]*nums[i],nums[i]) );
			min[i%2]=Math.min(max[(i+1)%2]*nums[i],Math.min(min[(i+1)%2]*nums[i],nums[i]) );
		}
		return max[(nums.length-1)%2];
		}
}
