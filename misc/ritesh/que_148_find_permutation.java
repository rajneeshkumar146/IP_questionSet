package pepques;

import java.util.LinkedList;

public class que_148_find_permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int [] permu(String s)
	{
		LinkedList<Integer> st=new LinkedList<>();
		
		int a[]=new int [s.length()+1];
		int cnt=1;
		st.addFirst(cnt);
		int j=0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='D')
			{
				cnt++;
				st.addFirst(cnt);
			}
			else{
				cnt++;
				while(st.size()!=0)
				{
					a[j]=st.removeFirst();
					j++;
				}
				st.addFirst(cnt);
				
			}
		
		}
		while(st.size()!=0)
		{
			a[j]=st.removeFirst();
			j++;
		}
		return a;
	}
}
