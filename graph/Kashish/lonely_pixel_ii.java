package InternQuestGraph;

import java.util.HashMap;
import java.util.Scanner;

public class lonely_pixel_ii {
	public static int findBlackPixel(char[][] picture, int n) {
		//jitni bhi col mai b pada hai unn row ka sum n ke equal hona chahiye
		
		HashMap<String, Integer> hm = new HashMap<>();
		int[] countcol = new int[picture[0].length];

		for (int i = 0; i < picture.length; i++) {
			int count = 0;
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < picture[0].length; j++) {
				if (picture[i][j] == 'B') {
					countcol[j]++;
					count++;
				}
				sb.append(picture[i][j]);
			}
			if (count == n) {
				if (hm.containsKey(sb.toString())) {
					hm.put(sb.toString(), hm.get(sb.toString()) + 1);
				}else{
					hm.put(sb.toString(),1);
				}
			}
		}
		int ans = 0;
		for (String s : hm.keySet()) {
			for (int i = 0; i < s.length(); i++) {
				if (hm.get(s) == n && s.charAt(i) == 'B' && countcol[i] == n) {
					ans+=n;
				}
			}
		}
		return ans;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

	}

}
