package InternQuestAS1;

import java.util.ArrayList;
import java.util.Scanner;

public class Summary_Ranges {
	public static ArrayList<String> summaryRanges(int[] nums) {
		ArrayList<String> ans = new ArrayList<>();
        boolean cont=false;
		for (int i = 0; i < nums.length; i++) {
			cont=false;
			StringBuilder res = new StringBuilder();
			res.append(nums[i]);
			while (i +1< nums.length && nums[i + 1] - nums[i] == 1) {
				cont=true;
				i++;
			}
			

			if(cont){
			res.append("->").append(nums[i]);
			}
			ans.add(res.toString());

		}

		return ans;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int[] nums = { 0,2,3,4,6,8,9 };
		System.out.println(summaryRanges(nums));

	}

}
