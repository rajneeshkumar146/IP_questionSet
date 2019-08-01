package mystack;
import java.util.*;
public class maximum_of_min_for_every_wind {
public static int[] findls(int[] arr){
	int res[]=new int[arr.length];
	Stack<Integer> st=new Stack<>();
	int i=arr.length-1;
	while(i>=0){
		res[i]=-1;
		while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
			res[st.pop()]=i;
			
		}
		st.push(i);
		i--;
	}
	for(int v:res){
		System.out.print(v+" ");
	}
	return res;
}

public static int[] findrs(int[] arr){
	int res[]=new int[arr.length];
	Stack<Integer> st=new Stack<>();
	int i=0;
	while(i<arr.length){
		res[i]=arr.length;
		while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
			res[st.pop()]=i;
		
		}
		st.push(i);
		i++;
	}
	for(int v:res){
		System.out.print(v+" ");
	}
	return res;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int arr[]={10,20,30};
int ls[]=findls(arr);
System.out.println();
int rs[]=findrs(arr);
	}

}
