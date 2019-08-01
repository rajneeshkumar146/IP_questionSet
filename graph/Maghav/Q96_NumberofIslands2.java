import java.util.*;
public class Q96_NumberofIslands2 {
	    
	    public int find(int i,int[]parent)
	    {
	        if (parent[i] != i && parent[i]!=-1) 
	            parent[i] = find(parent[i],parent);
	      return parent[i];
	    }
	    
	    public void Union(int x, int y,int[]rank,int[]parent) { // union with rank
	      int rootx = find(x,parent);
	      int rooty = find(y,parent);
	        if(rootx==-1)
	        {
	            parent[x]=rooty;
	        }
	        else if(rooty==-1)
	        {
	            parent[y]=rootx;
	        }
	     else if (rootx != rooty) {
	        if (rank[rootx] > rank[rooty]) {
	          parent[rooty] = rootx;
	        } else if (rank[rootx] < rank[rooty]) {
	          parent[rootx] = rooty;
	        } else {
	          parent[rooty] = rootx; rank[rootx] += 1;
	        }
	      } 
	    }

	    
	    public List<Integer> numIslands2(int m, int n, int[][] positions) {
	        
	        int number=0;
	        
	        int[][]grid=new int[m][n];
	        List<Integer>ans=new ArrayList<>();
	        
	        int[]parent=new int[m*n];
	        int[]rank=new int[m*n];
	        
	        Arrays.fill(parent,-1);
	        
	        for(int[]pos:positions)
	        {
	            int x=pos[0];
	            int y=pos[1];
	            
	            if(grid[x][y]==0)
	            grid[x][y]=1;
	            else
	            {
	                ans.add(number);
	                continue;
	            } 
	            
	            int num=x*(n)+y;
	            
	            //Check whether my neighours are 1's or not
	            //If yes, then union both of them, if they have different parents, decrease the 
	            //number of islands by 1
	            
	            int[][]dirs={
	                {1,0},
	                {0,1},
	                {-1,0},
	                {0,-1}
	            };
	            int count=0;
	            for(int p[]:dirs)
	            {
	                int newx=x+p[0];
	                int newy=y+p[1];
	                if(newx>=0 && newx<grid.length && newy>=0 && newy<grid[0].length
	                  && grid[newx][newy]==1)
	                {
	                    int check=newx*(n)+newy;

	                    if(find(check,parent)!=find(num,parent))
	                    {
	                        Union(check,num,rank,parent);
	                        number--;
	                        count++;
	                    }
	                }
	            }
	            if(count==0)
	            {
	                parent[num]=num;
	                rank[num]++;
	            }
	            number++;
	            ans.add(number);
	        }
	        return ans;
	    }

}
