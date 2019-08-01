package InternshipQuestionAs1;

import java.util.HashMap;

public class ZigZag_Conversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("PAYPALISHIRING", 3));
	}

	public static String convert(String s, int numRows) {

		if (s.length() <= numRows || numRows == 0)
			return s;

		HashMap<Integer, StringBuilder> hm = new HashMap<>();
		boolean inc = true;
		int pos = 0;

		for (char c : s.toCharArray()) {

			if (pos == 1)
				inc = true;
			if (pos == numRows)
				inc = false;
			if (inc)
				pos++;
			else
				pos--;

			if (!hm.containsKey(pos))
				hm.put(pos, new StringBuilder());
			hm.get(pos).append(c);

		}
//		System.out.println(hm);
		StringBuilder ans = new StringBuilder();
		for (int pst = 1; pst <= numRows; pst++) {
			ans.append(hm.get(pst));
		}

		return ans.toString();
	}
}
