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

public class Pep_JavaIP_12Agraphs_433SimulateNetwork{
	public static void main(String[] args) throws Exception  {
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		int m = scn.nextInt();
		
		Edge[] graph = new Edge[m];
		for(int i = 0; i < graph.length; i++){
			int u = scn.nextInt();
			int v = scn.nextInt();
			int cost = scn.nextInt();
			graph[i] = new Edge(u, v, cost);
		}
		
		int[] arr = new int[scn.nextInt()];
		for(int i = 0; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}

		
		ArrayList<Edge> mst = kruskals(graph, n);
		System.out.println(solve(mst, arr));
	}
	
	private static long solve(ArrayList<Edge> mst, int[] arr){
		long cost = 0;

		Collections.sort(mst, Collections.reverseOrder());
		Arrays.sort(arr);
		
		int i = 0;
		for(Edge e: mst){
			if(i < arr.length && e.cost > arr[i]){
				cost += arr[i];
				i++;
			} else {
				cost += e.cost;
			}
		}

		return cost;
	}
	
	private static ArrayList<Edge> kruskals(Edge[] graph, int n){
		ArrayList<Edge> mst = new ArrayList<>();
		
		int[] partition = new int[n + 1];
		int[] size = new int[n + 1];
		for(int i = 1; i < partition.length; i++){
			partition[i] = i;
			size[i] = 1;
		}
		
		Arrays.sort(graph);
		for(int i = 0; i < graph.length; i++){
			Edge re = graph[i];
			
			int setu = find(partition, re.u);
			int setv = find(partition, re.v);
			if(setu != setv){
				merge(partition, size, re.u, re.v);
				mst.add(re);
			}
		}
		
		return mst;
	}
	
	private static int find(int[] partition, int v){
		if(partition[v] == v){
			return v;
		} else {
			partition[v] = find(partition, partition[v]);
			return partition[v];
		}
	}
	
	private static void merge(int[] partition, int[] size, int u, int v){
		int setu = find(partition, u);
		int setv = find(partition, v);
		
		if(size[setu] < size[setv]){
			partition[setu] = setv;
			size[setv] += size[setu];
		} else {
			partition[setv] = setu;
			size[setu] += size[setv];
		}
	}
	
	public static class Edge implements Comparable<Edge> {
		int u;
		int v;
		int cost;
		
		Edge(int u, int v, int cost){
			this.u = u;
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}

	// https://www.hackerearth.com/practice/algorithms/graphs/minimum-spanning-tree/practice-problems/algorithm/mr-president/
	// Test cases - hackerearth

}
