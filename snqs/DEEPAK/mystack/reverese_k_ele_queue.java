package mystack;
import java.util.*;
public class reverese_k_ele_queue {

//	static void reversequek(Queue<Integer> q,int k){
//		Stack<Integer> st=new Stack<>();
//		if(q.isEmpty() || k>q.size() || k<=0)
//			return;
//		for(int i=0;i<k;i++){
//			st.push(q.peek());
//			q.remove();
//		}
//		while(!st.isEmpty()){
//			q.add(st.pop());
//
//		}
//		for(int i=0;i<q.size()-k;i++){
//			q.add(q.peek());
//			q.remove();
//		}
//		display(q);
//	}
//	
//	public static void display(Queue<Integer> q){
//		while(!q.isEmpty()){
//			System.out.println(q.peek());
//			q.remove();
//		}
//	}
//	public static void main(String[] args) {
//
//		
//		Queue<Integer> q=new LinkedList<>();
//		int k=3;
//		q.add(1);
//		q.add(2);
//		q.add(3);
//		q.add(4);
//		q.add(5);
//		
//		System.out.println(q.peek());
//reversequek(q, k);
//	}
//
//}

	
	
	
	public static int scoreOfParentheses(String s) {
        int ans=0;
        Stack<String> stack=new Stack();
        for(int i=0;i<s.length();i++){
            int a=-1;
            if(s.charAt(i)==')'){
                while(!stack.peek().equals("(")){
                    String p=stack.pop();
                    if(a==-1)a=Integer.parseInt(p);
                    else a+=Integer.parseInt(p);
                }
                stack.pop();
                stack.push(("" + (a==-1?1:(2*a))));
            }
            else stack.push(""+s.charAt(i));
        }
        while(stack.size()!=0)ans+=Integer.parseInt(stack.pop());
        return ans;
    }
    
    
    
    public static void main(String[] args) {
        String s="(()())";
        System.out.println(scoreOfParentheses(s));
    }
}