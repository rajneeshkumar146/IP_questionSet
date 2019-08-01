package may28;

public class set_mismatch {
	
	public static void main(String[] args) {
		int[] arr={1,2,2,4};
		findErrorNums(arr);
	}
	
	public static int[] findErrorNums(int[] nums) {
			int len=nums.length;
			int axorb=0;
			
			int[] count=new int[len+1];
			int twice=0;
			
			for(int i=0;i<len;i++){
				axorb=axorb^nums[i]^(i+1);
				count[nums[i]]++;
				if(count[nums[i]]>1){
					twice=nums[i];
				}
			}
			
			int missing =axorb ^ twice;
			
			int[] ret={twice,missing};
			
			return ret;
			
			
			
	}
}
