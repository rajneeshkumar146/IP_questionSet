package interview.binaryTree;

import java.util.HashMap;
import java.util.Scanner;

import javax.print.DocFlavor.CHAR_ARRAY;

public class Pep_JavaIP_10BinaryTrees_348CustomTree {
	private static class Node {
		char data;
		Node left;
		Node right;
		boolean isRoot = true;

		Node(char data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";

		str += node.left == null ? "." : node.left.data;
		str += " <= " + node.data + " => ";
		str += node.right == null ? "." : node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		String str1 = scn.nextLine();
		String str2 = scn.nextLine();
		
		solve(str1, str2);
	}
	
	private static void solve(String str1, String str2){
		HashMap<Character, Node> map = new HashMap<>();
		populateMap(str1, map);
		populateMap(str2, map);
		
		for(int i = 0; i < str1.length(); i++){
			char ch1 = str1.charAt(i);
			char ch2 = str2.charAt(i);
			
			Node n1 = map.get(ch1);
			Node n2 = map.get(ch2);
			// n2 won't be a root now
			n2.isRoot = false;
	
			// n2 will become a child of n1.
			if(n1.left == null){
				n1.left = n2;
			} else if(n1.right == null){
				n1.right = n2;
			}
		}
		
		for(Character key: map.keySet()){
			Node node = map.get(key);
			if(node.isRoot){
				display(node);
				System.out.println();
			}
		}
	}
	
	// a node against each unique char
	private static void populateMap(String str, HashMap<Character, Node> map){
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			if(map.containsKey(ch) == false){
				map.put(ch, new Node(ch, null, null));
			}
		}
	}
	
}
// https://www.geeksforgeeks.org/custom-tree-problem/
/* Test case 1 
aabcdczyx
bgcdefyxw
b <= a => g
c <= b => .
d <= c => f
e <= d => .
. <= e => .
. <= f => .
. <= g => .

y <= z => .
x <= y => .
w <= x => .
. <= w => . 
*/

/* Test case 2 
abba
bcde
b <= a => e
c <= b => d
. <= c => .
. <= d => .
. <= e => .
*/