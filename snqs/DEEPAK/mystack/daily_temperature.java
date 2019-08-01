package mystack;
import java.util.*;
public class daily_temperature {
public static int[] findwarmertemp(int temp[] ){
	int res[]=new int[temp.length];
	Stack<Integer> st=new Stack<>();
	for(int i=temp.length-1;i>=0;i-- ){
		while(st.size()>0 && temp[i]>=temp[st.peek()]){
			st.pop();
		}
		res[i]=st.size()==0?0:st.peek()-i;
		st.push(i);
	}
	return res;
}
	public static void main(String[] args) {
int temp[]= {74,72,79,62};
int res[]=findwarmertemp(temp);
for(int i=0;i<res.length;i++){
	System.out.println(res[i]);
}
	}

}
