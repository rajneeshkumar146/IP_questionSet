
public class Q126_SimilarStrings {
	    private boolean isSimilar(String[]A,int i, int j)
	    {
	        int count=0;
	        
	        for(int k=0;k<A[i].length();k++)
	        {
	            if(A[i].charAt(k)!=A[j].charAt(k))
	            {
	                count++;
	            }
	        }
	        if(count==2||count==0)
	        {
	            return true;
	        }
	        else
	        {
	            return false;
	        }
	    }
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
	    private void Union(int[]parent,int i,int j)
	    {
	        parent[Find(parent,i)]=Find(parent,j);
	    }
	    public int numSimilarGroups(String[] A) {
	        int[]parent=new int[A.length];
	        for(int i=0;i<parent.length;i++)
	        {
	            parent[i]=i;
	        }
	        
	        for(int i=0;i<A.length;i++)
	        {
	            for(int j=0;j<A.length;j++)
	            {
	                if(isSimilar(A,i,j))
	                {
	                    Union(parent,i,j);
	                }
	            }
	        }
	        
	        int ans=0;
	        for(int i=0;i<A.length;i++)
	        {
	            if(parent[i]==i)
	            {
	                ans++;
	            }
	        }
	        return ans;
	    }

}
