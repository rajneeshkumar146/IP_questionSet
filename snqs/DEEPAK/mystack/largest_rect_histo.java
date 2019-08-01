package mystack;
import java.util.*;
public class largest_rect_histo {
	 public int largestRectangleArea(int[] ht) {
	        if(ht.length==0)
	            return 0;
	        Stack<Integer> st=new Stack<>();
	        int rb[] = new int[ht.length];
			int lb[] = new int[ht.length];
			rb[ht.length - 1] = ht.length - 1;
			st.push(ht.length - 1);
			for (int i = ht.length - 2; i >= 0; i--) {

				while (st.size() > 0 && ht[st.peek()] >= ht[i]) {
					st.pop();
				}
				rb[i] = (st.size() > 0) ? st.peek()-1: ht.length-1;
				st.push(i);
			}

			while (st.size() > 0) {
				st.pop();
			}
			st.push(0);
			lb[0]=0;
			for (int i = 1; i < ht.length; i++) {
				while (st.size() > 0 && ht[st.peek()] >= ht[i]) {
					st.pop();
				}
				lb[i] = (st.size() > 0) ? st.peek()+1 : 0;
				st.push(i);
			}

			int maxa = Integer.MIN_VALUE;
			for (int i = 0; i < ht.length; i++) {
				maxa = Math.max(maxa, (rb[i] - lb[i]+1) * ht[i]);
			}

	    return maxa;
		}

	public static void main(String[] args) {

	}

}
