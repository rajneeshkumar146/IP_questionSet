package pepques;

import java.util.Scanner;

public class ques_77_alternate_bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//code
		Scanner s=new Scanner(System.in);
		int  t=s.nextInt();
		while(t>0)
		{
			 long n = s.nextLong();
			    int flag=1;
			    String st = Long.toBinaryString(n);
			    
			    for(int i=0;i<st.length()-1;i++){
			        if(st.charAt(i) == st.charAt(i+1)){
			            flag=0;
			            break;
			        }
			    }
			    if(flag==0){
			        System.out.println(0);
			    }else{
			        System.out.println(1);
			    }
			
			t--;
			
		}
	}
}
