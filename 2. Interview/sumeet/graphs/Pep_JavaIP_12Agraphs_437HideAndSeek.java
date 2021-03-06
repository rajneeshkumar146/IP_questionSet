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

public class Pep_JavaIP_12Agraphs_437HideAndSeek{
	public static void main(String[] args) throws Exception  {
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		ArrayList<Pair>[] graph = new ArrayList[n + 1];
		for(int i = 1; i < graph.length; i++){
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= n - 1; i++){
			int a = scn.nextInt();
			int b = scn.nextInt();
			graph[a].add(new Pair(b, 1));
			graph[b].add(new Pair(a, 1));
		}
		
		int[] st = new int[n + 1];
		int[] et = new int[n + 1];
		dft(1, graph, new boolean[n + 1], st, et);
		
		int q = scn.nextInt();
		for(int i = 1; i <= q; i++){
			int dir = scn.nextInt();
			int x = scn.nextInt();
			int y = scn.nextInt();
			
			if(dir == 0){
				System.out.println(st[x] < st[y] && et[x] > et[y]? "YES": "NO");
			} else {
				System.out.println(st[x] > st[y] && et[x] < et[y]? "YES": "NO");
			}
		}
		
	}
	
	static int count = 0;
	private static void dft(int v, ArrayList<Pair>[] graph, boolean[] visited, int[] st, int[] et){
		visited[v] = true;
		
		count++;
		st[v] = count;
		
		
		for(Pair np: graph[v]){
			if(visited[np.v] == false){
				dft(np.v, graph, visited, st, et);
			}
		}
		
		count++;
		et[v] = count;
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


	// https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/mrinal-and-three-musketeers-128f4c52/
	// Test cases - hackerearth

}
