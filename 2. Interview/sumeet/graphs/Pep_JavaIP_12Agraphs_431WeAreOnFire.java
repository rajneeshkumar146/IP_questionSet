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

public class Pep_JavaIP_12Agraphs_431WeAreOnFire{
	static int count = 0;
	
	public static void main(String[] args) throws Exception  {
		Scan scn = new Scan();
		Print prn = new Print();
		
		int n = scn.scanInt();
		int m = scn.scanInt();
		int q = scn.scanInt();
		
		int[][] graph = new int[n + 1][m + 1];
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= m; j++){
				graph[i][j] = scn.scanInt();
				count += graph[i][j];
			}
		}
		
		Integer[][] qb = new Integer[n + 1][m + 1];
		for(int i = 1; i <= q; i++){
			int x = scn.scanInt();
			int y = scn.scanInt();
			
			if(qb[x][y] == null){
				dft(graph, x, y);
			}
			
			qb[x][y] = count;
			prn.printLine(count + "");
		}

		prn.close();
	}

	private static void dft(int[][] graph, int x, int y) {
		if(x < 1 || y < 1 || x >= graph.length || y >= graph[0].length){
			return;
		}
		
		if(graph[x][y] == 0){	
			return;
		}
		
		graph[x][y] = 0;
		count--;
		
		dft(graph, x - 1, y);
		dft(graph, x + 1, y);
		dft(graph, x, y - 1);
		dft(graph, x, y + 1);
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


	// https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/we-are-on-fire/
	// Test cases - hackerearth

}
