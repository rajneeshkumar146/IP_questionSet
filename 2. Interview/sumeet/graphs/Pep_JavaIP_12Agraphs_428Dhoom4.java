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

public class Pep_JavaIP_12Agraphs_428Dhoom4{
	public static void main(String[] args) throws Exception  {
		Scanner scn = new Scanner(System.in);
		
		int key = scn.nextInt();
		int lock = scn.nextInt();
	
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		
		int[] visited = new int[100001];
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(key);
		while(queue.size() > 0){
			int rp = queue.removeFirst();
			
			if(rp == lock){
				System.out.println(visited[rp]);
				return;
			}
			
			for(int np: arr){
				long v = ((long)rp * (long)np) % 100000;
				int nv = (int) v;
				if(visited[nv] == 0){
					visited[nv] = visited[rp] + 1;
					queue.addLast(nv);
				}
			}
		}
		
		System.out.println(-1);
	}
}

//https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/dhoom-4/
//Test cases - hackerearth

