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

public class Pep_JavaIP_12Agraphs_436MinimizePathCost{
	public static void main(String[] args) throws Exception  {
		Scanner scn = new Scanner(System.in);
		
		int n = Integer.parseInt(scn.next());
		int m = Integer.parseInt(scn.next());
		
		HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
		for(int i = 1; i <= n; i++){
			String v = scn.next();
			map.put(v, new HashMap<>());
		}
		
		for(int i = 1; i <= m; i++){
			String v1 = scn.next();
			String v2 = scn.next();
			int d = Integer.parseInt(scn.next());
			
			map.get(v1).put(v2, d);
			map.get(v2).put(v1, d);
		}
		
		HashMap<String, HashMap<String, Integer>> res = floydwarshall(map);
		int q = Integer.parseInt(scn.next());
		for(int i = 1; i <= q; i++){
			String s = scn.next();
			String d = scn.next();
			System.out.println(res.get(s).get(d));
		}
	}

	private static HashMap<String, HashMap<String, Integer>> floydwarshall(HashMap<String, HashMap<String, Integer>> map){
		HashMap<String, HashMap<String, Integer>> res = new HashMap<>();
		
		for(String sv: map.keySet()){
			res.put(sv, new HashMap<>());
			for(String dv: map.keySet()){
				res.get(sv).put(dv, sv.equals(dv)? 0: (map.get(sv).containsKey(dv)? map.get(sv).get(dv): Integer.MAX_VALUE));
			}
		}
		
		for(String nv: map.keySet()){
			for(String sv: map.keySet()){
				for(String dv: map.keySet()){
					if(nv.equals(sv) || nv.equals(dv)){
						continue;
					} else if(res.get(sv).get(nv) == Integer.MAX_VALUE || res.get(nv).get(dv) == Integer.MAX_VALUE){
						continue;
					} else if(res.get(sv).get(nv) + res.get(nv).get(dv) < res.get(sv).get(dv)){
						res.get(sv).put(dv, res.get(sv).get(nv) + res.get(nv).get(dv));
					}
				}
			}
		}
		
		return res;
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


	// https://www.hackerearth.com/practice/algorithms/graphs/shortest-path-algorithms/practice-problems/algorithm/minimizing-path-cost/
	// Test cases - hackerearth

}
