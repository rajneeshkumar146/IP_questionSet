package interview.graphs;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

import javax.print.DocFlavor.CHAR_ARRAY;

public class Pep_JavaIP_12Agraphs_449CharacterPrecedence{
	public static void main(String[] args) throws Exception  {
		Scanner scn = new Scanner(System.in);
		
		String input = scn.nextLine();
		String[] words = input.split(" ");
		
		ArrayList<Integer>[] graph = new ArrayList[26];
		for(int i = 0; i < graph.length; i++){
			graph[i] = new ArrayList<>();
		}
		
		String prev = words[0];
		for(int i = 1; i < words.length; i++){
			String curr = words[i];
			
			// prev is one behind
			int j = 0;
			int k = 0;
			while(j < prev.length() && k < curr.length()){
				char pch = prev.charAt(j);
				char cch = curr.charAt(k);
				
				if(pch != cch){
					graph[pch - 'a'].add(cch - 'a');
					break;
				}
				
				j++;
				k++;
			}
			
			prev = curr;
		}
		
		int[] visited = new int[26];
		LinkedList<Integer> stack = new LinkedList<>();
		for(int i = 0; i < 26; i++){
			if(visited[i] == 0){
				topologicalSort(graph, i, visited, stack);
			}
		}
		
		HashSet<Character> unique = new HashSet<>();
		for(int i = 0; i < input.length(); i++){
			unique.add(input.charAt(i));
		}
		while(stack.size() > 0){
			char ch = (char)('a' + stack.removeFirst());
			if(unique.contains(ch)){
				System.out.print(ch + " ");
			}
		}
		System.out.println(".");
	}
	
	private static void topologicalSort(ArrayList<Integer>[] graph, Integer ch, int[] visited, LinkedList<Integer> stack){
		visited[ch] = 1;
		for(int nbr: graph[ch]){
			if(visited[nbr] == 0){
				topologicalSort(graph, nbr, visited, stack);
			}
		}
		
		stack.addFirst(ch);
	}

// https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
// Test cases

/* Test case 1
baa abcd abca cab cad
b d a c .
*/
	
/* Test case 2
caa aaa aab
c a b .
*/	

}
