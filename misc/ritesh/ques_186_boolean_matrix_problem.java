package pepques;


import java.util.*;
import java.io.*;
import java.lang.*;



public class ques_186_boolean_matrix_problem {

	
	
	
	static long time = 0, mp = Integer.MAX_VALUE, k = 0, cnt = 0, edge = 0, no = 0;

	static int[] goal;
	static int[] init;
	static int[] col;
	static char[][] g;
	static String sb = "";
	static ArrayList<Integer>[] a;

	static ArrayList<Integer> p = new ArrayList<>();
	static int mod=(int) (1e9+7);

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Reader s=new Reader();
		
		int t=s.nextInt();
		while(t>0)
		{
			StringBuilder str=new StringBuilder();
			int n=s.nextInt();
			int m=s.nextInt();
			int [][]dp=new int[n][m];
			int a[][]=new int [n][m];
			ArrayList<Integer> row=new ArrayList<>();
			ArrayList<Integer> col=new ArrayList<>();
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++)
				{
					a[i][j]=s.nextInt();
					if(a[i][j]==1)
					{
						row.add(i);
						col.add(j);
					}
				}
			}
			for(int i=0;i<row.size();i++)
			{
				int ro=row.get(i);
				for(int j=0;j<m;j++)
				{
				dp[ro][j]=1;
				}
			}
			for(int i=0;i<col.size();i++)
			{
				int co=col.get(i);
				for(int j=0;j<n;j++)
				{
				dp[j][co]=1;
				}
			}
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++)
				{
					str.append(dp[i][j]+" ");
				}
				str.append("\n");
			}
			System.out.print(str);
			
			t--;
		}
	}
	
	
	static class pair implements Comparable<pair> {
		int n = 0;
		int cnt = 0;
		String s="";
		// int cnt;

		pair(int b, int a, String k) {
			this.n = b;
			this.cnt = a;
			s=k;
			// cnt = x;
		}

		@Override
		public int compareTo(pair o) {

			return 1;

		}
	}

	// -----------PrintWriter for faster output---------------------------------
	public static PrintWriter out;

	public static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[100000 + 1]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}

		public int[] nextIntArray(int n) throws IOException {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextInt();
			}
			return arr;
		}

		public long[] nextLongArray(int n) throws IOException {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextLong();
			}
			return arr;
		}

		public int[][] nextInt2DArray(int m, int n) throws IOException {
			int[][] arr = new int[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++)
					arr[i][j] = nextInt();
			}
			return arr;
		}

	}
	

}
