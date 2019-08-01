package BackTracking;

import java.util.ArrayList;

public class BinaryWatch {

	public static void main(String[] args) {
		int n = 2;
		ArrayList<String> list = possibletime(n, new boolean[10], 0,0);
		System.out.println(list);
	}

	private static ArrayList<String> possibletime(int n, boolean[] hour, int count,int start) {
		if (count == n) {
			ArrayList<String> baselist = new ArrayList<>();
			int hr = 0;
			for (int i = 0; i < 4; i++) {
				if (hour[i] == true) {
					hr = hr + ((int) Math.pow(2, i));
				}
			}
			int min = 0;
			for (int i = 4; i < 10; i++) {
				if (hour[i] == true) {
					min = min + ((int) Math.pow(2, i - 4));
				}
			}
			String add1 = "";
			if (hr > 11 || min > 59) {
			} else if (min < 9) {
				add1 = hr + ":0" + min;
				baselist.add(add1);
			} else if (min > 9) {
				add1 = hr + ":" + min;
				baselist.add(add1);
			}
			return baselist;
		}
		ArrayList<String> ans = new ArrayList<>();
		for (int i = start; i < 10; i++) {
			if (hour[i] == false) {
				hour[i] = true;
				ArrayList<String> rresult = possibletime(n, hour, count + 1,i+1);
				for (String st : rresult) {
					ans.add(st);
				}
				hour[i] = false;
			}
		}
		return ans;
	}
}
