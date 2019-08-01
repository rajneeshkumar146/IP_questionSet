package InternQuestAS1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Stamping_The_Sequence {

	public static int[] movesToStamp(String stamp, String target) {
		char[] st = stamp.toCharArray();
		char[] tar = target.toCharArray();
		boolean[] visited = new boolean[target.length() - stamp.length() + 1];
		ArrayList<Integer> res=new ArrayList<>();
		int count = 0;
		while (count < tar.length) {
			boolean placed=false;
			for (int i = 0; i < tar.length - st.length + 1; i++) {
				boolean put = true;
				for (int j = 0; j < st.length; j++) {
					if (tar[i + j] != '?' && tar[i + j] != st[j]) {
						put = false;
					}
				}

				if (put && !visited[i]) {
					visited[i] = true;
					res.add(i);
					place(tar, st, i);
					placed=true;
				}
				count = totalcount(tar);
				if(count==tar.length){
					break;
				}
				
			}
			if(!placed){
				return  new int[0];
			}

		}
		
		  int[] resArray = new int[res.size()];
	        for (int i = 0; i < res.size(); i++) {
	            resArray[i] = res.get(res.size()-i-1);
	        }
	        return resArray;

	}

	private static int totalcount(char[] tar) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < tar.length; i++) {
			if (tar[i] == '?') {
				count++;
			}
		}
		return count;
	}

	private static void place(char[] tar, char[] st, int s) {
		// TODO Auto-generated method stub
		for (int i = 0; i < st.length; i++) {
			tar[s + i] = '?';
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		 String stamp = "abc";
		 String target = "ababc";
		 int ans[]=movesToStamp(stamp, target);
		 for(int v: ans){
			 System.out.print(v+" ");
		 }
		

	}

}
