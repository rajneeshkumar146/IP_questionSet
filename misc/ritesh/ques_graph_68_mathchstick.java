package pepques;

import java.util.Arrays;

public class ques_graph_68_mathchstick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] a={1,1,2,2,2};
		System.out.println(match(a));
	}
	public static class sqr{
		int side[]=new int[4]; 
		int sid;
	}
	
	public static boolean match(int [] a)
	{
	
		Arrays.sort(a);
		
		int permi=0;
		for(int i=0;i<a.length;i++)
		{
			permi+=a[i];
		}
		if(permi%4!=0)
		{
			return false;
		}
		sqr s=new sqr();
		s.sid=permi/4;
//		int j=0;
//		int dir=0;
//		for(int i=a.length-1;i>=0;i--)
//		{
//			boolean f=false;
//			dir%=4;
//			for(int k=0;k<4;k++)
//			{
//				if(s.side[dir]+a[i]<=s.sid)
//				{
//					s.side[dir]=s.side[dir]+a[i];
//					f=true;
//					dir++;
//					break;
//				}
//				dir++;
//				dir%=4;
//			}
//			if(f==false)
//			{
//				return false;
//			}
//		}
//		return true;
		return dfs(s,a,a.length-1);
		
	}
	public static boolean dfs(sqr s,int [] a,int idx)
	{
		   if (idx ==0) {
	            return s.side[0] == s.side[1] && s.side[1] == s.side[2] && s.side[2] == s.side[3];
	        }

	        // Get current matchstick.
	        int element = a[idx];

	        // Try adding it to each of the 4 sides (if possible)
	        for(int i = 0; i < 4; i++) {
	            if (s.side[i] + element <= s.sid) {
	                s.side[i] += element;
	                if (dfs(s,a,idx - 1)) {
	                    return true;
	                }
	                s.side[i] -= element;
	            }
	        }

	        return false;
	}

}
