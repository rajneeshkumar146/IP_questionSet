package mystack;
import java.util.*;
public class Asteroids_collision {
	 public static int[] asteroidCollision(int[] asteroids) {
	        
	       Stack<Integer> st=new Stack<>();
	        for(int i=0;i<asteroids.length;i++){
	            int ast=asteroids[i];
	            condition:{
	                while(!st.isEmpty() && ast<0 && st.peek()>0){
	                    if(st.peek()<Math.abs(ast)){
	                        st.pop();
	                        continue;
	                    }else if(st.peek()==Math.abs(ast)){
	                        st.pop();
	                    }
	                    break condition;
	                }
	                st.push(ast);
	            }
	        }
	        int[] res=new int[st.size()];
	        for(int i=res.length-1;i>=0;i--){
	            res[i]=st.peek();
	            st.pop();
	        }
	        return res;
	    }
	  
	public static void main(String[] args) {
	    int ast[]={-2,-1,1,2};
	    int res[]=asteroidCollision(ast);
	    for(int v:res){
	    	System.out.println(v);
	    }
	}

}
