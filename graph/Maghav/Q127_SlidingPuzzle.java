import java.util.*;
public class Q127_SlidingPuzzle {
		public int slidingPuzzle(int[][] board) {
		        String target = "123450";
		        String start = "";
		        for (int i = 0; i < board.length; i++) {
		            for (int j = 0; j < board[0].length; j++) {
		                start += board[i][j];
		            }
		        }
		        HashSet<String> visited = new HashSet<>();
		    
		        // all the positions 0 can be swapped to
		        int[][] dirs = new int[][] { { 1, 3 }, { 0, 2, 4 },
		                { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
		    
		        LinkedList<String>Q = new LinkedList<>();
		        Q.addLast(start);
		        visited.add(start);
		    
		        int res = 0;
		        while (Q.size()>0) {
		            // level count, has to use size control here, otherwise not needed
		            int size =Q.size();
		            for (int i = 0; i < size; i++) {
		                String current = Q.removeFirst();
		                if (current.equals(target)) {
		                    return res;
		                }
		                int zero = current.indexOf('0');
		                
		                // swap if possible
		                for (int dir : dirs[zero]) {
		                    String next = swap(current, zero, dir);
		                    if (visited.contains(next)) {
		                        continue;
		                    }
		                    visited.add(next);
		                    Q.addLast(next);

		                }
		            }
		            res++;
		        }
		        return -1;
		    }

		    private String swap(String str, int i, int j) {
		        StringBuilder sb = new StringBuilder(str);
		        sb.setCharAt(i, str.charAt(j));
		        sb.setCharAt(j, str.charAt(i));
		        return sb.toString();
		    } 
		    
}
