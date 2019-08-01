package interview.graphs;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_12Agraphs_430ConnectedHorses{
	static int div = 1000000007;
	static int countDash = 0;
	
	public static void main(String[] args) throws Exception  {
		Scan scn = new Scan();
		Print prn = new Print();
		
		long[] f = new long[1000000];
		f[1] = 1;
		for(int i = 2; i < f.length; i++){
			f[i] = ((i) * (f[i - 1])) % div;
		}
		
		int t = scn.scanInt();
		while(t-- > 0){
			int n = scn.scanInt();
			int m = scn.scanInt();
			int q = scn.scanInt();
			
			int[][] graph = new int[n + 1][m + 1];
			for(int i = 1; i <= q; i++){
				int x = scn.scanInt();
				int y = scn.scanInt();
				graph[x][y] = 1;
			}
			
			
			
			int[][] visited = new int[n + 1][m + 1];
			long count = 1;
			for(int r = 1; r < graph.length; r++){
				for(int c = 1; c < graph[0].length; c++){
					if(visited[r][c] == 0 && graph[r][c] == 1){
						countDash = 0;
						dft(graph, r, c, visited);
						count = ((count) * (f[countDash])) % div;
					}
				}
			}
			
			prn.printLine(count + "");
		}
		prn.close();
	}
	
	private static void dft(int[][] graph, int r, int c, int[][] visited){
		visited[r][c] = 1;
		countDash++;
		
		int[][] dirs = {
				{-2, -1},
				{-2, 1},
				{-1, -2},
				{-1, 2},
				{1, -2},
				{1, 2},
				{2, -1},
				{2, 1}
		};
		
		for(int i = 0; i < dirs.length; i++){
			int rdash = r + dirs[i][0];
			int cdash = c + dirs[i][1];
			
			if(rdash < 1 || cdash < 1 || rdash >= graph.length || cdash >= graph[0].length || 
			   graph[rdash][cdash] == 0 || visited[rdash][cdash] == 1){
				continue;
			}
			
			dft(graph, rdash, cdash, visited);
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


	// https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/connected-horses-10/
	// Test cases - hackerearth

}
