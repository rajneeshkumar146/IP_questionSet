package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class subtractionoflinkedlist {

	public static void main(String[] args) {

	}

	private static class Node {
		int data;
		Node next;

		Node(int val) {
			this.data = val;
		}
	}

	int getLength(Node node)  
    { 
        int size = 0; 
        while (node != null) 
        { 
            node = node.next; 
            size++; 
        } 
        return size; 
    } 
  
    /* A Utility that padds zeros in front  
    of the Node, with the given diff */
    Node paddZeros(Node sNode, int diff) 
    { 
        if (sNode == null) 
            return null; 
  
        Node zHead = new Node(0); 
        diff--; 
        Node temp = zHead; 
        while ((diff--) != 0) 
        { 
            temp.next = new Node(0); 
            temp = temp.next; 
        } 
        temp.next = sNode; 
        return zHead; 
    } 
  boolean borrow=false;
    /* Subtract LinkedList Helper is a recursive 
    function, move till the last Node, and  
    subtract the digits and create the Node and 
    return the Node. If d1 < d2, we borrow the  
    number from previous digit. */
    Node subtractLinkedListHelper(Node l1, Node l2) 
    { 
        if (l1 == null && l2 == null && borrow == false) 
            return null; 
  
        Node previous = subtractLinkedListHelper((l1 != null) ?  
                                 l1.next : null, (l2 != null) ?  
                                 l2.next : null); 
  
        int d1 = l1.data; 
        int d2 = l2.data; 
        int sub = 0; 
  
        /* if you have given the value value to  
        next digit then reduce the d1 by 1 */
        if (borrow) 
        { 
            d1--; 
            borrow = false; 
        } 
  
        /* If d1 < d2 , then borrow the number from 
        previous digit. Add 10 to d1 and set  
        borrow = true; */
        if (d1 < d2) 
        { 
            borrow = true; 
            d1 = d1 + 10; 
        } 
  
        /* subtract the digits */
        sub = d1 - d2; 
  
        /* Create a Node with sub value */
        Node current = new Node(sub); 
  
        /* Set the Next pointer as Previous */
        current.next = previous; 
  
        return current; 
    } 
  
    /* This API subtracts two linked lists and  
    returns the linked list which shall have the 
    subtracted result. */
    Node sublinkedList(Node l1, Node l2) 
    { 
        // Base Case. 
        if (l1 == null && l2 == null) 
            return null; 
  
        // In either of the case, get the lengths 
        // of both Linked list. 
        int len1 = getLength(l1); 
        int len2 = getLength(l2); 
  
        Node lNode = null, sNode = null; 
  
        Node temp1 = l1; 
        Node temp2 = l2; 
  
        // If lengths differ, calculate the smaller  
        // Node and padd zeros for smaller Node and 
        // ensure both larger Node and smaller Node 
        // has equal length. 
        if (len1 != len2) 
        { 
            lNode = len1 > len2 ? l1 : l2; 
            sNode = len1 > len2 ? l2 : l1; 
            sNode = paddZeros(sNode, Math.abs(len1 - len2)); 
        } 
  
        else
        { 
           
            while (l1 != null && l2 != null) 
            { 
                if (l1.data != l2.data) 
                { 
                    lNode = l1.data > l2.data ? temp1 : temp2; 
                    sNode = l1.data > l2.data ? temp2 : temp1; 
                    break; 
                } 
                l1 = l1.next; 
                l2 = l2.next; 
            } 
        } 
  
        // After calculating larger and smaller Node, 
        // call subtractLinkedListHelper which returns 
        // the subtracted linked list. 
        borrow = false; 
        return subtractLinkedListHelper(lNode, sNode); 
    }

}
