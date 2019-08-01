package mystack;
import java.util.*;
public class online_stock_span {
		static Stack<Integer> pri,prevpri;
		    public online_stock_span() {
		        pri=new Stack<>();
		    prevpri=new Stack<>();
		    }
		    
		    public static int next(int price) {
		        int d=1;
		        while(!pri.isEmpty() && pri.peek()<=price){
		            pri.pop();
		            d=d+prevpri.pop();
		        }
		     pri.push(price);
		     prevpri.push(d);
		        return d;
		    }
		
	public static void main(String[] args) {
		online_stock_span s=new online_stock_span();
		System.out.println(s.next(110));
		System.out.println(s.next(80));
		System.out.println(s.next(60));
		System.out.println(s.next(70));
		System.out.println(s.next(60));
		System.out.println(s.next(75));
		System.out.println(s.next(90));


	}

}
