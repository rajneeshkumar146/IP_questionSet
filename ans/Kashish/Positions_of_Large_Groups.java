package InternQuestAS1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Positions_of_Large_Groups {
	public static ArrayList<ArrayList<Integer>> largeGroupPositions(String S) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		int j=0;
		int i=0;
		for(;i<S.length();i++){
			if(S.charAt(i)!=S.charAt(j)){
				if(i-j>=3){
					ans.add(new ArrayList<>(Arrays.asList(j,i-1)));
				}
				j=i;
			}
		}
		if(i-j>=3){
			ans.add(new ArrayList<>(Arrays.asList(j,i-1)));
		}

		return ans;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		String s = "aaa";
		System.out.println(largeGroupPositions(s));

	}

}
