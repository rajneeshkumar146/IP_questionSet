package mystack;
import java.util.*;
public class next_warmer_day {
public static int[] warmerday(int temp[]){
	Stack<Integer> st=new Stack<>();
int res[]=new int[temp.length];
for(int i=temp.length-1;i>=0;i--){
	while(st.size()>0 && temp[i]>=temp[st.peek()]){
		st.pop();
	}
	res[i]=st.size()==0?0:st.peek()-i;
	st.push(i);
}
return res;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int temp[]={74,72,79,62,56,23,99};
int res[]=warmerday(temp);
for(int val:res){
	System.out.print(val+" ");
}
	}

}
