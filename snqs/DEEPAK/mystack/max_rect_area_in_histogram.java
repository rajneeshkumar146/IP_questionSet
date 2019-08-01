package mystack;
import java.util.*;
public class max_rect_area_in_histogram {
	public static long[] findls(long ht[]){
		Stack<Integer> st=new Stack<>();
		long res[]=new long[ht.length];
		int i=0;
		while(i<ht.length){
			while(!st.isEmpty() && ht[st.peek()]>ht[i]){
				st.pop();
			}
			res[i]=st.size()==0?0:st.peek()+1;
			st.push(i);
			i++;
		}
		for(long v:res){
			System.out.print(v+" ");
		}
		return res;
		
	}
	public static long[] findrs(long[] ht){
		long res[]=new long[ht.length];
		Stack<Integer> st=new Stack<>();
		int i=ht.length-1;
		while(i>=0){
			while(!st.isEmpty() && ht[st.peek()]>ht[i]){
				st.pop();
			}
			res[i]=st.size()==0?ht.length-1:st.peek()-1;
			st.push(i);
			i--;
		}
		System.out.println();
		for(long v:res){
			System.out.print(v+" ");
		}
		return res;
	}
        public static void main(String[] args) {
		// TODO Auto-generated method stub
	    long ht[] = {8,3,8,2,5,6,7,9,5}; 
	    
	    
	    
	    Stack<Integer> st=new Stack<>();
	    
	    long lb[]=findls(ht);
	    long rb[]=findrs(ht);
	    long max=Integer.MIN_VALUE;
	    for(int i=0;i<lb.length;i++){
	    	max=Math.max(((rb[i]-lb[i])+1)*ht[i],max);
	    }
	    System.out.println(max);
	    
	    
	    
//	    long rb[] = new long[ht.length];
//		long lb[] = new long[ht.length];
//		rb[ht.length - 1] = ht.length - 1;
//		st.push (ht.length - 1);
//		for (int i = ht.length - 2; i >= 0; i--) {
//
//			while (st.size() > 0 && ht[(st.peek())] >= ht[(int)i]) {
//				st.pop();
//			}
//			rb[(int) i] = (st.size() > 0) ? st.peek()-1: ht.length-1;
//			st.push(i);
//		}
//
//		while (st.size() > 0) {
//			st.pop();
//		}
//		st.push(0);
//		
//		for(long v:rb){
//			System.out.print(v+" ");
//		}
//		lb[0]=0;
//		for (int i = 1; i < ht.length; i++) {
//			while (st.size() > 0 && ht[(int)(st.peek())] >= ht[(int)i]) {
//				st.pop();
//			}
//			lb[(int) i] = (st.size() > 0) ? st.peek()+1 : 0;
//			st.push(i);
//		}
//		System.out.println();
//		for(long v:lb){
//			System.out.print(v+" ");
//		}
//
//		long maxa = Integer.MIN_VALUE;
//		for (long i = 0; i < ht.length; i++) {
//			maxa = Math.max(maxa, (rb[(int) i] - lb[(int) i]+1) * ht[(int) i]);
//		}
//
//		System.out.println();
//		System.out.println(maxa);
        }
	}

	    
	    
	    
	    
	    
	    
	    
	    
	    


















































