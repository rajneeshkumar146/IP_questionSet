package InternshipQuestionAs1;

import java.util.ArrayList;

public class Summary_Ranges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<String> summaryRanges(int[] a) {

		ArrayList<String> ans = new ArrayList<>();
		int i = 0, li = 0;

		while (i < a.length) {

			StringBuilder sb = new StringBuilder();
			sb.append(a[i]);
			li = i;

			while (i < a.length - 1 && a[i] == a[i + 1] - 1)
				i++;

			if (li == i)
				ans.add(sb.toString());
			else {
				sb = sb.append("->");
				sb = sb.append(a[i]);
				ans.add(sb.toString());
			}
			i++;
		}
		return ans;
	}
}
