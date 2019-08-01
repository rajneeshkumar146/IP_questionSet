import java.util.*;
	import java.lang.*;
	import java.io.*;
public class Q129_SteppingNumbers {
	    static ArrayList<Integer>ans;
	    static HashMap<Integer,Boolean>Unique;
	    
	    private static void DFS(int digit,int start, int end,int num)
	    {
	        num=num*10+digit;
	        
	        if(num>end)
	        {
	            return;
	        }
	        
	        if(!Unique.containsKey(num) && num>=start)
	        {
	            Unique.put(num,true);
	            ans.add(num);
	        }
	        
	        if(digit+1<=9)
	        {
	            DFS(digit+1,start,end,num);
	        }
	        
	        if(digit-1>=0)
	        {
	            DFS(digit-1,start,end,num);
	        }
	        
	        
	    }
		public static void main (String[] args) {
			Scanner sc=new Scanner(System.in);
			
			int tc=sc.nextInt();
			
			for(int t=0;t<tc;t++)
			{
			    int start=sc.nextInt();
			    int end=sc.nextInt();
			    
			    ans=new ArrayList<>();
			    Unique=new HashMap<>();
			    
			    for(int k=start;k<=9;k++)
			    {
			        Unique.put(k,true);
			        ans.add(k);
			    }
			    
			    for(int i=1;i<=9;i++)
			    {
			          DFS(i,start,end,0);
			    }
			    
			    System.out.println(ans.size());
			}
		}

}
