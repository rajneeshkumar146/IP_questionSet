package mystack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class generate_binary_number {
	 public static void getBinary(int n){
	        Queue<String> q=new LinkedList<>();
	        q.add("1");
	        while(n-->0){
	            String s=q.remove();
	            System.out.print(s+" ");
	            String news=s;
	            q.add(s+"0");
	            q.add(news+"1");
	        }
	        System.out.println(q.size());
	        while(!q.isEmpty()){
	        	System.out.println("dfsfw");
	        	System.out.println(q.peek());
	        	q.poll();
	        }
	    }
	 
	public static void main(String[] args) {
//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
getBinary(5);
	}

}
