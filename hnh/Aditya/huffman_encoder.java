package may30;

import java.util.PriorityQueue;
import java.util.Scanner;

public class huffman_encoder {

	static class pair implements Comparable<pair> {
		public String c;
		public int freq;
		public pair left;
		public pair right;

		public pair(String c, int freq) {
			this.c = c;
			this.freq = freq;
			
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			
			return this.freq-o.freq ;
		}

	}

	public static void traverse(pair root,String psf){
		if(root.left==null && root.right==null){
			System.out.print(psf+" ");
			return;
		}
		
		traverse(root.left, psf+0);
		traverse(root.right,psf+1);
		
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int t = 1;

		for (int tc = 0; tc < t; tc++) {
			String str=scn.next();
			PriorityQueue<pair> pq=new PriorityQueue<>(); 
			
			for(char c:str.toCharArray()){
				pair p=new pair(c+"",scn.nextInt());
				pq.add(p);
			}
			
			while(pq.size()!=1){
				pair a=pq.poll();
				pair b=pq.poll();
				
				pair merge=new pair(a.c+b.c, a.freq+b.freq);
				merge.left=a;
				merge.right=b;
				
				pq.add(merge);
			}
			
			traverse(pq.peek(),"");
			System.out.println();
		 
		}
	}
}
