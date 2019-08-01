package pepques;

import java.util.Scanner;

public class ques_59_alive_in_circle {

	  static class Node{
	        
	        int data;
	        Node next;
	        Node(int x){
	            data=x;
	            next=null;
	        }
	        
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			
			  Node head=new Node(1);
		        Node p=head;
		        for(int i=2;i<=n;i++){
		            p.next=new Node(i);
		            p=p.next;
		        }
		        
		        p.next=head;
		        p=head;
		        while(p.next!=p){
		            
		            p.next=p.next.next;
		            p=p.next;

		        }
		        
		        System.out.println(p.data);
			t--;
		}
	        
	    }
	}

}
