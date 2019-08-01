import java.util.HashSet;

public class BitwiseORSubarray {

	public int subarrayBitwiseORs(int[] A) {
		HashSet<Integer> ans = new HashSet();
		HashSet<Integer> cur = new HashSet();

		// 0 is the identity for OR operation
		cur.add(0);
		for (int x : A) {
			
			HashSet<Integer> cur2 = new HashSet();
			
			// ORing with all the existing subarrays
			// ending with the immediate previous element
			for (int y : cur)
				cur2.add(x | y);
			
			//Adding a new subarray starting with this current element
			cur2.add(x);
			
			cur = cur2;
			ans.addAll(cur);
		}

		return ans.size();
	}
}
