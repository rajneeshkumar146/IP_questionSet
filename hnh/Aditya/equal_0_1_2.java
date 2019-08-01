package may31;

import java.util.HashMap;
import java.util.Scanner;

public class equal_0_1_2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		for (int tc = 0; tc < t; tc++) {

			String line = scn.next();

			HashMap<String, Integer> map = new HashMap<>();
			int ans = 0;
			int count0 = 0, count1 = 0, count2 = 0;

			map.put("0*0", 1);
			for (int i = 0; i < line.length(); i++) {

				char b = line.charAt(i);

				switch (b) {
				case '0':
					count0++;
					break;
				case '1':
					count1++;
					break;
				case '2':
					count2++;
					break;
				}

				String temp = (count0 - count1) + "*" + (count0 - count2);  // if count0[i] -count0[j] = count1[i] -count1[j] = count2[i] -count2[j] 
				if (map.containsKey(temp)) {								// then valid,ie if c0[i]-c1[i] = c0[j]-c1[j] and the other sequence
					ans += map.get(temp);
					map.put(temp, map.get(temp) + 1);
				} else {
					map.put(temp, 1);
				}
			}

			System.out.println(ans);

		}

	}

}
