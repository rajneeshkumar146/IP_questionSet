package pepques;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ques_graph_34_escape_a_large_maze {

	static int []xc={1,-1,0,0};
	static int [] yc={0,0,1,-1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]b={{2,1},{1,2},{2,3},{3,2}};
			int []s={0,0};
			int[] t={2,2};

			System.out.println(isEscapePossible(b,s,t));
			
	}
	 public static boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
     	
			visited = new HashSet<Long>();
			for(int[] b:blocked) {
				long tmp = b[0]*1000000+b[1];
				visited.add(tmp);
			}
			int ans = BFS(source,target);
	        return ans>0;
	    }
	    	static Set<Long> visited;
		public static class Pos{
			int x; int y;
			Pos(int x, int y){
				this.x = x;
				this.y = y;
			}
		}
	    	private static int BFS(int[] source, int[] target)
		{
			Queue<Pos> que = new LinkedList<Pos>();
			int[] dx = {0,0,1,-1};
			int[] dy = {1,-1,0,0};
			que.offer(new Pos(source[0],source[1]));
			visited.add((long) (source[0] * 1000000 + source[1]));
			while(!que.isEmpty()) {
				Pos p = que.peek();
				que.poll();
			
				if(Math.abs(p.x - source[0])+
						Math.abs(p.y - source[1])>200) {
					return dfs(source,target)-0;
				}
				if(p.x == target[0] && p.y == target[1]) {
					return 2;
				}
				
				
				
				for(int i=0;i<4;i++) {
					int tx = dx[i]+p.x;
					int ty = dy[i]+p.y;
					
					long tmp = tx*1000000+ty;
					if(tx<0 || ty<0 || tx>=1000000 || ty>=1000000
							|| visited.contains(tmp)) {
						continue;
					}
					visited.add(tmp);
					que.offer(new Pos(tx,ty));
				}
			}
			
			return 0;
		}

	    	private static int dfs(int[] source, int[] target)
	    	{
	    		Queue<Pos> que = new LinkedList<Pos>();
				int[] dx = {0,0,1,-1};
				int[] dy = {1,-1,0,0};
				que.offer(new Pos(target[0],target[1]));
				visited.add((long) (target[0] * 1000000 + target[1]));
				while(!que.isEmpty()) {
					Pos p = que.peek();
					que.poll();
				
					if(Math.abs(p.x - target[0])+
							Math.abs(p.y - target[1])>200) {
						return 1;
					}
					if(p.x == source[0] && p.y == source[1]) {
						return 2;
					}
					
					
					
					for(int i=0;i<4;i++) {
						int tx = xc[i]+p.x;
						int ty = yc[i]+p.y;
						
						long tmp = tx*1000000+ty;
						if(tx<0 || ty<0 || tx>=1000000 || ty>=1000000
								|| visited.contains(tmp)) {
							continue;
						}
						visited.add(tmp);
						que.offer(new Pos(tx,ty));
					}
				}
				
				return 0;
	    	}
}
