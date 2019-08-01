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
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_12Agraphs_435Marathon{
	public static void main(String[] args) throws Exception  {
		Scan scn = new Scan();
		Print prn = new Print();
		
		int n = scn.scanInt();
		int m = scn.scanInt();
		int k = scn.scanInt();
		int ex = scn.scanInt();
		
		int[] vces = new int[n + 1];
		for(int i = 1; i <= k; i++){
			vces[scn.scanInt()] = 1;
		}
		
		ArrayList<Pair>[] graph = new ArrayList[n + 1];
		for(int i = 1; i < graph.length; i++){
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= m; i++){
			int x = scn.scanInt();
			int y = scn.scanInt();
			int d = scn.scanInt();
			
			Pair p1 = new Pair(y, d);
			graph[x].add(p1);
			
			Pair p2 = new Pair(x, d);
			graph[y].add(p2);
		}
		
		int a = scn.scanInt();
		int b = scn.scanInt();
		
		// shortest paths from a
		int[] dresa = djikstra(a, n, graph);
		// shortest paths from b
		int[] dresb = djikstra(b, n, graph);
		
		int res = Integer.MAX_VALUE;
		for(int i = 1; i < dresa.length; i++){
			// all chocolate cities which are not far from b
			if(dresa[i] != Integer.MAX_VALUE && vces[i] == 1 && dresb[i] <= ex){ // chocolate here and b not far away
				res = Math.min(res, dresa[i] + dresb[i]);
			}
		}
				
		res = res == Integer.MAX_VALUE? -1: res;
		prn.printLine(res + "");
		prn.close();
	}
	
	private static int[] djikstra(int src, int n, ArrayList<Pair>[] graph){
		int[] res = new int[n + 1];
		int[] visited = new int[n + 1];
		
		PriorityQueue<DPair> pq = new PriorityQueue<>();
		for(int i = 1; i <= n; i++){
			pq.add(new DPair(i, i == src? 0: Integer.MAX_VALUE));
			res[i] = i == src? 0: Integer.MAX_VALUE;
		}
		
		while(pq.size() > 0){
			DPair rp = pq.remove();
			
			// instead of updating pq
			if(visited[rp.v] == 1){
				continue;
			}
			visited[rp.v] = 1;
			
			// rp is reachable from src
			if(rp.csf == Integer.MAX_VALUE){
				continue;
			}
			
			for(Pair np: graph[rp.v]){
				if(rp.csf + np.dist < res[np.v]){
					res[np.v] = rp.csf + np.dist;
					pq.add(new DPair(np.v, rp.csf + np.dist));
				}
			}
		}
		
		return res;
	}
	
	static class DPair implements Comparable<DPair>{
		int v;
		int csf;
		
		public DPair(int v, int csf) {
			this.v = v;
			this.csf = csf;
		}

		@Override
		public int compareTo(DPair o) {
			// TODO Auto-generated method stub
			return this.csf - o.csf;
		}
		
		
	}
	
	static class Pair {
		int v;
		int dist;
		
		Pair(int v, int dist){
			this.v = v;
			this.dist = dist;
		}
	}
	
	static class Scan {
		private InputStream in;
		private byte[] buf = new byte[1024];
		private int index;
		private int total;

		public Scan() {
			in = System.in;
		}

		public int scan() throws IOException {
			if (total < 0)
				throw new InputMismatchException();
			if (index >= total) {
				index = 0;
				total = in.read(buf);
				if (total <= 0)
					return -1;
			}
			return buf[index++];
		}

		public int scanInt() throws IOException {
			int integer = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n)) {
				if (n >= '0' && n <= '9') {
					integer *= 10;
					integer += n - '0';
					n = scan();
				} else
					throw new InputMismatchException();
			}
			return neg * integer;
		}

		public double scanDouble() throws IOException {
			double doub = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n) && n != '.') {
				if (n >= '0' && n <= '9') {
					doub *= 10;
					doub += n - '0';
					n = scan();
				} else
					throw new InputMismatchException();
			}
			if (n == '.') {
				n = scan();
				double temp = 1;
				while (!isWhiteSpace(n)) {
					if (n >= '0' && n <= '9') {
						temp /= 10;
						doub += (n - '0') * temp;
						n = scan();
					} else
						throw new InputMismatchException();
				}
			}
			return doub * neg;
		}

		public String scanString() throws IOException {
			StringBuilder sb = new StringBuilder();
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			while (!isWhiteSpace(n)) {
				sb.append((char) n);
				n = scan();
			}
			return sb.toString();
		}

		private boolean isWhiteSpace(int n) {
			if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
				return true;
			return false;
		}
	}

	static class Print {
		private final BufferedWriter bw;

		public Print() {
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		public void print(String str) throws IOException {
			bw.append(str);
		}

		public void printLine(String str) throws IOException {
			print(str);
			bw.append("\n");
		}

		public void close() throws IOException {
			bw.close();
		}
	}


	// https://www.hackerearth.com/practice/algorithms/graphs/shortest-path-algorithms/practice-problems/algorithm/successful-marathon-0691ec04/
	// Test cases - hackerearth

}
