
public class Q109_RedundantConnection1 { 
	    private int Find(int[]parent,int vertex)
		    {
		        if(parent[vertex]==vertex)
		        {
		            return vertex;
		        }
		        else
		        {
		            parent[vertex]=Find(parent,parent[vertex]);
		            return parent[vertex];
		        }
		    }
		    private boolean Union(int[]parent,int[]rank,int i,int j)
		    {
	            int x=Find(parent,i);
	            int y=Find(parent,j);
		        
	            if(x==y)
	            {
	                return true;
	            }
	            if(rank[x]>rank[y])
	            {
	                parent[y]=x;
	            }
	            else if(rank[y]>rank[x])
	            {
	                parent[x]=y;
	            }
	            else
	            {
	                parent[x]=y;
	                rank[y]++;
	            }
	            return false;
		    }
	    public int[] findRedundantConnection(int[][] edges) {
	        
	      int[]parent=new int[edges.length+1];
	        
	        for(int i=0;i<parent.length;i++)
	        {
	            parent[i]=i;
	        }
	        int[]rank=new int[parent.length];
	        
	         for(int[]x:edges)
	         {
	             if(Union(parent,rank,x[0],x[1]))
	             {
	                 return x;
	             }
	         }
	        return new int[0];
	    }

}
