package InternshipQuestionAs1;

import java.util.HashMap;

public class Roman_to_Integer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int romanToInt(String s) {

		HashMap<Character, Integer> map = new HashMap();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int sum = 0;
		int prev = Integer.MAX_VALUE;
		int curr = 0;

		for (int i = 0; i < s.length(); i++) {
			curr = map.get(s.charAt(i));
			sum += curr;
			if (curr > prev)
				sum -= 2 * prev;// beacuase we added prev 2 times and only one time small occure befor larger

			prev = curr;
		}
		return sum;
	}
}
