package pepques;

import java.util.Scanner;

public class ques_14_and_of_no_range {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int no1=s.nextInt();
		int no2=s.nextInt();
		 System.out.println(RangeBitwiseAnd(no1 , no2));
	}
public static int RangeBitwiseAnd(int m,int n)
{
	  int res=m;
      for(int i=m+1;i<=n;i++)
      {
          res=res&i;
      }
      return res;
}


}
