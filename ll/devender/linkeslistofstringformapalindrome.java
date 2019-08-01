package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class linkeslistofstringformapalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
   public static check(Node n){
	   StringBuilder sb=new StringBuilder();
	   while(n!=null){
		   sb.append(n.data);
		   n=n.next;
	   }
	   String s=sb.toString();
	   int left=0;
	   int right=s.length()-1;
	   while(left<=right){
		   if(s.charAt(left)!=s.charAt(right)){
			   return false;
		   }
		   left++;
		   right--;
	   }
	   return true;
   }
   
}
