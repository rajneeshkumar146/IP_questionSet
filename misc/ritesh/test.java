import java.util.*;
 import java.io.*;
 public class Main {
 
 //this is a functional problem and you just nee to write the below function 
 // you can use reverse function wherever necessary
 	 public static Node addTwoNumbers(Node n1, Node n2) {
       help nh=new help();
       nh.h=n1;
       reverse(n1,nh);
       nh.h=n2;
       reverse(n2,nh);
       int carry = 0;
         int sum = 0;
         Node head = null;
         Node prev = null;
         while (n1 != null || n2 != null) {
             int ldata = n1 != null ? n1.data: 0;
             int sdata = n2 != null ? n2.data: 0;
             sum = ldata + sdata + carry;
             carry = sum / 10;
             sum = sum % 10;
             if (head == null) {
                 head = new Node(sum, null);
                 prev = head;
             } else {
                 Node n = new Node(sum, null);
                 prev.next = n;
                 prev = n;
             }
             if (n1 != null) {
                 n1 = n1.next;
             }
             if (n2 != null) {
                 n2 = n2.next;
             }
         }
         if (carry != 0) {
             Node n = new Node(carry, null);
             prev.next = n;
         }
 
         return reverse(head);
 
 	 }
 	public static class help{
 	     Node h=null;;
 	 }
 public static void reverse(Node n,help nh)
 {
     if(n==null)
     {
         return ;
     }
     reverse(n.next,nh);
     if(nh.h!=n||n.next!=nh.h.next)
     {
         int temp=nh.h.data;
         nh.h.data=n.data;
         n.data=temp;
         nh.h=nh.h.next;
     }
    
 }
 	 public static void main(String[] args) {
 	 	 Scanner sc = new Scanner(System.in);
 	 	 int n = sc.nextInt();
 	 	 int n1 = sc.nextInt();
 
 	 	 int a1 = sc.nextInt();
 	 	 insert(a1);
 
 	 	 for (int i = 1; i < n; i++) {
 	 	 	 int a = sc.nextInt();
 	 	 	 insert(a);
 	 	 }
 	 	 int a2 = sc.nextInt();
 	 	 insert2(a2);
 
 	 	 for (int i = 1; i < n1; i++) {
 	 	 	 int a = sc.nextInt();
 	 	 	 insert2(a);
 	 	 }
 
 	 	 reshead=addTwoNumbers(head, head2);
 
 	 	 display(reshead);
 
 	 }
 
 	 private static void insert2(int data) {
 	 	 Node nn = new Node(data, null);
 	 	 if (head2 == null) {
 	 	 	 head2 = nn;
 	 	 	 tail2 = nn;
 	 	 } else {
 	 	 	 tail2.next = nn;
 	 	 	 tail2 = nn;
 	 	 }
 	 }
 
 	 private static class Node {
 	 	 int data;
 	 	 Node next;
 
 	 	 public Node(int data, Node next) {
 	 	 	 this.data = data;
 	 	 	 this.next = next;
 	 	 }
 
 	 }
 
 	 static Node head;
 	 static Node tail;
 	 static Node head2;
 	 static Node tail2;
 	 static Node reshead;
 	 static Node restail;
 
 	 public static void insert(int data) {
 
 	 	 Node nn = new Node(data, null);
 	 	 if (head == null) {
 	 	 	 head = nn;
 	 	 	 tail = nn;
 	 	 } else {
 	 	 	 tail.next = nn;
 	 	 	 tail = nn;
 	 	 }
 	 }
 
 	 public static void display(Node n) {
 	 	 for (Node node = n; node != null; node = node.next) {
 	 	 	 System.out.print(node.data + " ");
 	 	 }
 	 }
 
 
 
 }