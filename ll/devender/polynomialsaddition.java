package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class polynomialsaddition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Node poly(Node poly1, Node poly2) {
		Node poly = new Node(0,0);
		while (poly1 != null && poly2 != null) {
			if (poly1.pow > poly2.pow) {
				poly.pow = poly1.pow;
				poly.coeff = poly1.coeff;
				poly1 = poly1.next;
			} else if (poly1.pow < poly2.pow) {
				poly.pow = poly2.pow;
				poly.coeff = poly2.coeff;
				poly2 = poly2.next;
			}else{
			    poly.coeff=poly1.coeff+poly2.coeff;
			    poly.pow=poly1.pow;
			    poly1=poly1.next;
			    poly2=poly2.next;
			}
             System.out.print(poly.coeff+"x^"+poly.pow+" ");
             if(poly1!=null&&poly2!=null){
                 System.out.print("+ ");
             }
            
		}
		while(poly1!=null){
		    System.out.print("+ "+poly1.coeff+"x^"+poly1.pow+" ");
		    poly1=poly1.next;
		}
   while(poly2!=null){
       System.out.print("+ "+poly2.coeff+"x^"+poly2.pow+" ");
       poly2=poly2.next;
   }	}
}
