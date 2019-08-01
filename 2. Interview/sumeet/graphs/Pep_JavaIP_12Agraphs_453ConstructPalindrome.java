package interview.graphs;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_12Agraphs_453ConstructPalindrome{
	public static void main(String[] args) throws Exception  {
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		int k = scn.nextInt();
		
		int[] arr = new int[n];
		for(int i = 0; i < arr.length; i++){
			arr[i] = i % k;
		}
		
		ArrayList<Integer>[] graph = new ArrayList[k];
		for(int i = 0; i < graph.length; i++){
			graph[i] = new ArrayList<>();
		}
		
		for(int left = 0, right = arr.length - 1; left < right; left++, right--){
			graph[arr[left]].add(arr[right]);
			graph[arr[right]].add(arr[left]);
		}
		
		int[] visited = new int[k];
		dft(graph, 0, visited);
		for(int val: visited){
			System.out.print(val + " ");
		}
		System.out.println(".");
	}
	
	private static void dft(ArrayList<Integer>[] graph, int v, int[] visited){
		visited[v] = 1;
		
		for(int nbr: graph[v]){
			if(visited[nbr] == 0){
				dft(graph, nbr, visited);
			}
		}
	}
	
}

//https://www.geeksforgeeks.org/construct-binary-palindrome-by-repeated-appending-and-trimming/
//Test cases

//Test case 1
/*
7 3
1 0 0 .
*/

// Test case 2
/*
10 4
1 1 0 0 .
*/

