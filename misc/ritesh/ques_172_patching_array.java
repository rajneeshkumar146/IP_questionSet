package pepques;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ques_172_patching_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int patches(int[] num,int n)
	{
		int i=0;
		
		int find=1;
		int patch=0;
		
		while(i<num.length && find<=n)
		{
			if(find>=num[i])//it means we are reachable till find
			{
				find+=num[i++];//now we are reachable till find+num[i]cauz
				//if we 1 t0 n no then we can reach find +n by addying in find from 1 to n 
				
			}
			else
			{
				find*=2;//if we have no 1 to n then we can reach till n*2
				//suppose we have 1,2,3 then we can reach 4,5,6 by adding them
				patch++;
			}
		}
		return patch;
		
	}
}
