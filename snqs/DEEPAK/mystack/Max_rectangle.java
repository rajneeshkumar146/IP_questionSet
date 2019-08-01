package mystack;

import java.util.Stack;

public class Max_rectangle {
	public static int[] findls(int ht[]){
		Stack<Integer> st=new Stack<>();
		int res[]=new int[ht.length];
		int i=0;
		while(i<ht.length){
			while(!st.isEmpty() && ht[st.peek()]>=ht[i]){
				st.pop();
			}
			res[i]=st.size()==0?0:st.peek()+1;
			st.push(i);
			i++;
		}
		
		return res;
		
	}
	public static int[] findrs(int[] ht){
		int res[]=new int[ht.length];
		Stack<Integer> st=new Stack<>();
		int i=ht.length-1;
		while(i>=0){
			while(!st.isEmpty() && ht[st.peek()]>=ht[i]){
				st.pop();
			}
			res[i]=st.size()==0?ht.length-1:st.peek()-1;
			st.push(i);
			i--;
		}
		
		return res;
	}
	public static int findarea(int[] ht){
		 int lb[]=findls(ht);
		    int rb[]=findrs(ht);
	  
		    int max=Integer.MIN_VALUE;
		    for(int i=0;i<lb.length;i++){
		    	max=Math.max(((rb[i]-lb[i])+1)*ht[i],max);
		    }
		    return max;
	}
	 public static int maxrect(int arr[][]){
		 int ht[]=new int[arr[0].length];
		 int maxar=Integer.MIN_VALUE;
		 for(int i=0;i<arr.length;i++){
			 for(int j=0;j<arr[0].length;j++){
				 if(i==0){
					ht[j]=arr[i][j]; 
				 }else{
				 if(arr[i][j]==0){
					 ht[j]=0;
				 }else{
					 ht[j]+=1;
				 }
			 }
			 }
			 maxar=Math.max(findarea(ht),maxar);
		 }
		 return maxar;
	 }
	      
	public static void main(String[] args) {
		int arr4[][]={
				{0, 0, 1, 0 ,0 ,0 ,0, 0},
				{1 ,1 ,1 ,1 ,1 ,1 ,1,0}

		};
		int arr[][] = {
				{1,0,0,1,1,1},  
                {1,0,1,1,0,1},  
                {0, 1, 1, 1, 1,1}, 
                {0, 0,1, 1, 1, 1}, 
               }; 
		int arr3[][]={
				{1,1,0,0},
				{1,1,0,0},
				{1,1,1,1},
				
		};
		
		int arr2[][]={
				{0,1,1,0},
				{1,1,1,1},
				{1,1,1,1},
				{1,1,0,0},
		};
		
          System.out.println( maxrect(arr2));
    
	}

}
