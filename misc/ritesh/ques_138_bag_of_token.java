package pepques;

import java.util.Arrays;
import java.util.Scanner;

public class ques_138_bag_of_token {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
				int[] token=new int[n];
				int p=s.nextInt();
	}
public static int bagoftoken(int[] token,int p)
{
	 if(token.length==0) return 0;
    Arrays.sort(token);
    
     int point=0;
     int i=0;
     int j=token.length-1;
    
    int max=0;
    while(i<=j)
    {
        while(i<=j&&p>=token[i])
        {
            p-=token[i];
            i++;
            point++;
        }
        max=Math.max(point,max);
        if(point<=0) break; 
        p+=token[j];
        point--;
        j--;
    }
    return max;

}
}
