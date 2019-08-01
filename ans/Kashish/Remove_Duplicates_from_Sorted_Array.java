package InternQuestAS1;

import java.util.Arrays;
import java.util.Scanner;

public class Remove_Duplicates_from_Sorted_Array {
public static  int removeDuplicates(int[] nums) {

	int count=1;
	int j=0;
	
	for(int i=1;i<nums.length;i++){
		if(nums[i]!=nums[i-1]){
			count++;
			j++;
			nums[j]=nums[i];
		}
	}
	return count;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		Scanner scn=new Scanner(System.in);
		int []nums={1,1,2};
		System.out.println(removeDuplicates(nums));
		
		

	}

}
