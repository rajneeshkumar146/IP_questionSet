package ll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class polynomialaddition {

	public static void main(String[] args) {
	}

	public static int val(Node n, Node m) {
		  Node h1=n;
		  Node h2=m;
		  Node poly=null;
		  Node polyhead=null;
		  while(h1!=null&&h2!=null){
			  h1=h1.next;
			  h2=h2.next;
			  if(h1.pow<h2.pow){
				  Node next=h1.next;
				  
				  poly=h1;
				  h1.next=h1;
				  
			  }
		  }
				}
	
}
