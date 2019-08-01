package mystack;
import java.util.*;
public class minsubarrays {

static class pair{
	int val;
	int count;
	pair(int v,int c){
		val=v;
		count=c;
	}
	
	

public static int sumsubarrmins(int arr[]){
	int mod=1000000007;
	Stack<pair> st=new Stack<>();
	int ans=0;
	int curr=0;
	for(int j=0;j<arr.length;j++){
	int count=1;
	while(!st.isEmpty() && st.peek().val>=arr[j]){
		pair rp=st.pop();
		count+=rp.count;
		curr-=rp.val*rp.count;
	}
	st.push(new pair(arr[j],count));
	curr+=arr[j]*count;
	ans+=curr;
	ans%=mod;
	}
	return ans;
}

	public static void main(String[] args) {

		int arr[]={2,4,3,1};
		System.out.println(sumsubarrmins(arr));
	}
}
}
