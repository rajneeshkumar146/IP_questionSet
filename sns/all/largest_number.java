package pep_sns;

import java.util.Arrays;
import java.util.Comparator;

public class largest_number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10, 2 => 210
		int[] nums = {3, 30, 34, 5, 9};
		System.out.println(largestNumber(nums));

	}
	
	public static class compareStr implements Comparator<String>{
        @Override
        public int compare(String s1, String s2){
            return (s2 + s1).compareTo(s1 + s2);
        }
    }
    
    public static String largestNumber(int[] nums) {
        String str = "";
        String[] sarr = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            sarr[i] = (nums[i] + "");
        }
        Arrays.sort(sarr, new compareStr());
        str = "";
        
        //check for all zeroes
        if(sarr[0].equals("0")){
            str = "0";
            return str;
        }
        
        for(int i = 0; i<=sarr.length-1; i++){
            str += sarr[i];
        }
        return str;
    }

}
